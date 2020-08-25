package fr.abennsir.poc.album.repository.remote

import fr.abennsir.poc.album.repository.data.NetworkResponse
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import okhttp3.ResponseBody
import org.amshove.kluent.coInvoking
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldThrow
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import java.net.UnknownHostException

@ExperimentalCoroutinesApi
class RemoteNetworkStrategyKtTest {


    private val message = "OK"

    //    private val responseBody = ResponseBody.create(null, "")
    private val successResponse: Response<String> = Response.success(message)
    private val errorResponse: Response<String> =
        Response.error<String>(404, ResponseBody.create(null, ""))

    private val cachedResponse: Response<String> = Response.success(
        "",
        okhttp3.Response.Builder().request(successResponse.raw().request())
            .networkResponse(successResponse.raw()).protocol(successResponse.raw().protocol())
            .message(successResponse.raw().message())
            .code(successResponse.code())
            .cacheResponse(successResponse.raw()).build()
    )

    private lateinit var mapper: MapperCall<String, Int>

    @Before
    fun setUp() {
        mapper = MapperCall { it.length }
    }

    @Test
    fun getApiResponseFreshIsOk() = runBlockingTest {
        val response = getApiResponse(call = { successResponse }, mapper = mapper)
        //test
        response shouldBeInstanceOf (NetworkResponse.Fresh::class)
        //test mapper invoked
        mapper.invokeCount shouldBeEqualTo 1
        (response as NetworkResponse.Fresh<Int>)
        response.data shouldBeEqualTo 2
    }

    @Test
    fun getApiResponseFailShouldReturnError() = runBlockingTest {

        val response = getApiResponse(call = { errorResponse }, mapper = mapper)
        //test
        response shouldBeInstanceOf (NetworkResponse.Error::class)
        (response as NetworkResponse.Error)
        response.exception shouldBeInstanceOf IllegalStateException::class
        //mapper not invoked
        mapper.invokeCount shouldBeEqualTo 0
    }

    @Test
    fun getApiResponseFromCacheReturnCache() = runBlockingTest {

        val response = getApiResponse(call = { cachedResponse }, mapper = mapper)
        //test
        response shouldBeInstanceOf (NetworkResponse.Cached::class)
        mapper.invokeCount shouldBeEqualTo 0

    }

    @Test
    fun getApiShouldNotBlockCancellation() = runBlockingTest {

        coInvoking {
            getApiResponse(call = { throw CancellationException() }, mapper = mapper)
        } shouldThrow CancellationException::class
        mapper.invokeCount shouldBeEqualTo 0

    }

    @Test
    fun getApiShouldNotBlockCancellationOnMapper() = runBlockingTest {

        mapper = MapperCall { throw CancellationException() }
        coInvoking {
            getApiResponse(call = { successResponse }, mapper = mapper)
        } shouldThrow CancellationException::class
        mapper.invokeCount shouldBeEqualTo 1
    }

    @Test
    fun getApiShouldReturnErrorOnException() = runBlockingTest {
        val response = getApiResponse(call = { throw UnknownHostException() }, mapper = mapper)
        //test
        response shouldBeInstanceOf (NetworkResponse.Error::class)
        (response as NetworkResponse.Error)
        response.exception shouldBeInstanceOf UnknownHostException::class
        mapper.invokeCount shouldBeEqualTo 0

    }

    @Test
    fun getApiShouldReturnBaseObjectWithoutMapper() = runBlockingTest {
        val response = getApiResponse(call = { throw UnknownHostException() }, mapper = mapper)
        //test
        response shouldBeInstanceOf (NetworkResponse.Error::class)
        (response as NetworkResponse.Error)
        response.exception shouldBeInstanceOf UnknownHostException::class
        mapper.invokeCount shouldBeEqualTo 0

    }

    @Test
    fun getApiResponseFreshIsOkDefaultMapper() = runBlockingTest {
        val response = getApiResponse(call = { successResponse })
        //test
        response shouldBeInstanceOf (NetworkResponse.Fresh::class)
        //test
        (response as NetworkResponse.Fresh<String>)
        response.data shouldBeEqualTo message
    }

    private class MapperCall<T, R>(private val block: (T) -> R) : (T) -> R {
        var invokeCount = 0
        override operator fun invoke(data: T): R {
            invokeCount++
            return block(data)
        }
    }
}