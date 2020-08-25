package fr.abennsir.poc.album.repository.core


import app.cash.turbine.test
import fr.abennsir.poc.album.domain.data.Resource
import fr.abennsir.poc.album.repository.core.tools.SuspendCallProducer
import fr.abennsir.poc.album.repository.core.tools.SuspendCallWatcher
import fr.abennsir.poc.album.repository.data.NetworkResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldNotBeNull
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.IOException
import java.net.UnknownHostException
import java.util.concurrent.CancellationException
import kotlin.time.ExperimentalTime

@FlowPreview
@ExperimentalCoroutinesApi
@OptIn(ExperimentalTime::class)
class FetchResourceDataAccessStrategyKtTest {

    //TODO: investigate why turbine assert not count into coverage.
    private val testDispatcher = TestCoroutineDispatcher()
    private lateinit var networkCall: SuspendCallProducer<NetworkResponse<String>>
    private lateinit var saveCall: SuspendCallWatcher<String, Unit>


    @Before
    fun setUp() {
        networkCall = SuspendCallProducer { NetworkResponse.Fresh("") }
        saveCall = SuspendCallWatcher {
        }
    }


    @Test
    fun fetchResourceAndCacheShouldSuccess() = runBlockingTest {

        fetchResourceAndCache(
            networkCall = networkCall::execute,
            saveCallResult = saveCall::execute,
            dispatcher = testDispatcher
        ).test {
            expectItem().shouldBeInstanceOf<Resource.Loading<Unit>>().let {
                it.data.shouldNotBeNull()
            }
            expectItem().shouldBeInstanceOf<Resource.Success<Unit>>()
            expectComplete()
        }
        //test network and db save called
        networkCall.invokeCount shouldBeEqualTo 1
        saveCall.invokeCount shouldBeEqualTo 1
    }

    @Test
    fun fetchResourceAndCacheShouldNotSaveDbIfCache() = runBlockingTest {

        networkCall = SuspendCallProducer { NetworkResponse.Cached }

        fetchResourceAndCache(
            networkCall = networkCall::execute,
            saveCallResult = saveCall::execute,
            dispatcher = testDispatcher
        ).test {
            expectItem().shouldBeInstanceOf<Resource.Loading<Unit>>().let {
                it.data.shouldNotBeNull()
            }
            expectItem().shouldBeInstanceOf<Resource.Success<Unit>>().data
            expectComplete()
        }
        //test network and db save called
        networkCall.invokeCount shouldBeEqualTo 1
        saveCall.invokeCount shouldBeEqualTo 0
    }


    @Test
    fun etchResourceWithApiResponseErrorShouldReturnError() = runBlockingTest {

        networkCall = SuspendCallProducer { NetworkResponse.Error(UnknownHostException()) }

        fetchResourceAndCache(
            networkCall = networkCall::execute,
            saveCallResult = saveCall::execute,
            dispatcher = testDispatcher
        ).test {
            expectItem().shouldBeInstanceOf<Resource.Loading<Unit>>().let {
                it.data.shouldNotBeNull()
            }
            expectItem().shouldBeInstanceOf<Resource.Error<Unit>>().throwable shouldBeInstanceOf UnknownHostException::class
            expectComplete()
        }
        //test network and db save called
        networkCall.invokeCount shouldBeEqualTo 1
        saveCall.invokeCount shouldBeEqualTo 0
    }


    @Test
    fun networkCallShouldNotBlocCancellation() = runBlockingTest {
        networkCall = SuspendCallProducer {
            throw CancellationException()
        }

        fetchResourceAndCache(
            networkCall = networkCall::execute,
            saveCallResult = saveCall::execute,
            dispatcher = testDispatcher
        ).test {
            expectItem().shouldBeInstanceOf<Resource.Loading<Unit>>().let {
                it.data.shouldNotBeNull()
            }
        }
        //test network and db save called
        networkCall.invokeCount shouldBeEqualTo 1
        saveCall.invokeCount shouldBeEqualTo 0

    }

    @Test
    fun saveCallShouldNotBlocCancellation() = runBlockingTest {

        saveCall = SuspendCallWatcher {
            //here we offer exception second list as update from database
            throw CancellationException()
        }

        fetchResourceAndCache(
            networkCall = networkCall::execute,
            saveCallResult = saveCall::execute,
            dispatcher = testDispatcher
        ).test {
            expectItem().shouldBeInstanceOf<Resource.Loading<Unit>>().let {
                it.data.shouldNotBeNull()
            }
        }

        //test network and db save called
        networkCall.invokeCount shouldBeEqualTo 1
        saveCall.invokeCount shouldBeEqualTo 1

    }


    @Test
    fun saveCallErrorShouldThrowIfError() = runBlockingTest {

        saveCall = SuspendCallWatcher {
            //here we offer second list as update from database
            throw IOException()
        }

        fetchResourceAndCache(
            networkCall = networkCall::execute,
            saveCallResult = saveCall::execute,
            dispatcher = testDispatcher
        ).test {
            expectItem().shouldBeInstanceOf<Resource.Loading<Unit>>().let {
                it.data.shouldNotBeNull()
            }
            expectError() shouldBeInstanceOf IOException::class
        }

        //test network and db save called
        networkCall.invokeCount shouldBeEqualTo 1
        saveCall.invokeCount shouldBeEqualTo 1

    }

    @After
    fun tearDown() {
        testDispatcher.cleanupTestCoroutines()
    }

}