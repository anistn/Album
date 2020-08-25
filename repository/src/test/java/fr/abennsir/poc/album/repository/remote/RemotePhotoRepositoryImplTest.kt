package fr.abennsir.poc.album.repository.remote

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import fr.abennsir.poc.album.repository.data.NetworkResponse
import fr.abennsir.poc.album.repository.data.PhotoEntity
import fr.abennsir.poc.album.repository.mockPhoto1Entity
import fr.abennsir.poc.album.repository.mockPhoto2Entity
import fr.abennsir.poc.album.repository.remote.api.PhotoService
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import okhttp3.ResponseBody
import org.amshove.kluent.*
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import java.net.UnknownHostException

@ExperimentalCoroutinesApi
class RemotePhotoRepositoryImplTest {

    private val responseBody = ResponseBody.create(null, "")
    private val photoList = listOf(mockPhoto1Entity, mockPhoto2Entity)
    private val successResponse: Response<List<PhotoEntity>> =
        Response.success(photoList)
    private val errorResponse: Response<List<PhotoEntity>> = Response.error(404, responseBody)

    private val cachedResponse: Response<List<PhotoEntity>> = Response.success(
        photoList,
        okhttp3.Response.Builder().request(successResponse.raw().request())
            .networkResponse(successResponse.raw()).protocol(successResponse.raw().protocol())
            .message(successResponse.raw().message())
            .code(successResponse.code())
            .cacheResponse(successResponse.raw()).build()
    )

    private lateinit var mockPhotoService: PhotoService
    private lateinit var remoteRepository: RemotePhotoRepositoryImpl

    @Before
    fun setUp() {
        mockPhotoService = mock { onBlocking { getPhotoAlbum() } doReturn successResponse }
        remoteRepository = RemotePhotoRepositoryImpl(mockPhotoService)
    }

    @Test
    fun getAlbumResponseFreshIsOk() = runBlockingTest {
        val response: NetworkResponse<List<PhotoEntity>> = remoteRepository.getAlbum()
        //test
        response shouldBeInstanceOf (NetworkResponse.Fresh::class)

        (response as NetworkResponse.Fresh<List<PhotoEntity>>)
        response.data shouldBeEqualTo photoList
    }

    @Test
    fun getAlbumResponseFailShouldReturnError() = runBlockingTest {

        When calling mockPhotoService.getPhotoAlbum() itReturns errorResponse
        val response: NetworkResponse<List<PhotoEntity>> = remoteRepository.getAlbum()
        //test
        response shouldBeInstanceOf (NetworkResponse.Error::class)
        (response as NetworkResponse.Error)
        response.exception shouldBeInstanceOf IllegalStateException::class
    }

    @Test
    fun getAlbumResponseFromCacheReturnCache() = runBlockingTest {

        When calling mockPhotoService.getPhotoAlbum() itReturns cachedResponse
        val response: NetworkResponse<List<PhotoEntity>> = remoteRepository.getAlbum()
        //test
        response shouldBeInstanceOf (NetworkResponse.Cached::class)
    }

    @Test
    fun getAlbumShouldNotBlockCancellation() = runBlockingTest {
        When calling mockPhotoService.getPhotoAlbum() itThrows CancellationException()
        //test
        coInvoking { remoteRepository.getAlbum() } shouldThrow CancellationException::class
    }


    @Test
    fun getAlbumShouldReturnErrorOnException() = runBlockingTest {
        When calling mockPhotoService.getPhotoAlbum() itAnswers { throw  UnknownHostException() }
        //test
        val response: NetworkResponse<List<PhotoEntity>> = remoteRepository.getAlbum()
        (response as NetworkResponse.Error)
        response.exception shouldBeInstanceOf UnknownHostException::class

    }

}