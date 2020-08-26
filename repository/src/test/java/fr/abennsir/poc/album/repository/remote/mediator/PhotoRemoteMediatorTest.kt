package fr.abennsir.poc.album.repository.remote.mediator

import androidx.paging.*
import androidx.paging.PagingSource.LoadResult.Page.Companion.COUNT_UNDEFINED
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.anyOrNull
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import fr.abennsir.poc.album.repository.data.NetworkResponse
import fr.abennsir.poc.album.repository.data.PhotoEntity
import fr.abennsir.poc.album.repository.local.LocalPhotoRepository
import fr.abennsir.poc.album.repository.mockPhoto1Entity
import fr.abennsir.poc.album.repository.mockPhoto2Entity
import fr.abennsir.poc.album.repository.remote.RemotePhotoRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.*
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
@ExperimentalPagingApi
class PhotoRemoteMediatorTest {

    private val state = PagingState<Int, PhotoEntity>(
        pages = listOf(),
        anchorPosition = null,
        config = PagingConfig(10),
        leadingPlaceholderCount = COUNT_UNDEFINED
    )

    private val photoData = listOf(
        mockPhoto1Entity,
        mockPhoto2Entity
    )

    private lateinit var mockLocalRepository: LocalPhotoRepository
    private lateinit var mockRemoteRepository: RemotePhotoRepository
    private lateinit var remoteMediator: PhotoRemoteMediator

    @Before
    fun setUp() {
        mockLocalRepository = mock {
            onBlocking { saveAllPhoto(anyOrNull(), any()) } doReturn Unit
        }

        mockRemoteRepository = mock {
            onBlocking { getAlbum() } doReturn NetworkResponse.Fresh(
                data = photoData
            )
        }
        remoteMediator = PhotoRemoteMediator(
            localPhotoRepository = mockLocalRepository,
            remotePhotoRepository = mockRemoteRepository
        )
    }

    @Test
    fun mediatorShouldIgnoreLoadAPPEND() = runBlockingTest {
        val callResult = remoteMediator.load(
            LoadType.APPEND, state = state
        )
        //test
        val response = callResult.shouldBeInstanceOf<RemoteMediator.MediatorResult.Success>()
        response.endOfPaginationReached.shouldBeTrue()
    }

    @Test
    fun mediatorShouldIgnoreLoadPrepend() = runBlockingTest {

        val callResult = remoteMediator.load(
            LoadType.PREPEND, state = state
        )
        //test
        val response = callResult.shouldBeInstanceOf<RemoteMediator.MediatorResult.Success>()
        response.endOfPaginationReached.shouldBeTrue()
    }

    @Test
    fun mediatorWithRefreshShouldCallRemote() = runBlockingTest {
        val callResult = remoteMediator.load(
            LoadType.REFRESH, state = state
        )
        //test
        Verify on mockRemoteRepository that mockRemoteRepository.getAlbum() was called
        val response = callResult.shouldBeInstanceOf<RemoteMediator.MediatorResult.Success>()
        response.endOfPaginationReached.shouldBeTrue()
    }

    @Test
    fun mediatorWithRefreshShouldReturnRemoteError() = runBlockingTest {
        //given
        When calling mockRemoteRepository.getAlbum() itReturns NetworkResponse.Error(
            IllegalStateException()
        )

        //when
        val callResult = remoteMediator.load(
            LoadType.REFRESH, state = state
        )
        //test
        Verify on mockRemoteRepository that mockRemoteRepository.getAlbum() was called
        VerifyNoFurtherInteractions on mockRemoteRepository
        val response = callResult.shouldBeInstanceOf<RemoteMediator.MediatorResult.Error>()
        response.throwable shouldBeInstanceOf IllegalStateException::class
    }

    @Test
    fun mediatorWithRefreshShouldNotCallLocalIfRemoteError() = runBlockingTest {

        When calling mockRemoteRepository.getAlbum() itReturns NetworkResponse.Error(
            IllegalStateException()
        )

        val callResult = remoteMediator.load(
            LoadType.REFRESH, state = state
        )
        //test
        VerifyNoInteractions on mockLocalRepository
        val response = callResult.shouldBeInstanceOf<RemoteMediator.MediatorResult.Error>()
        response.throwable shouldBeInstanceOf IllegalStateException::class
    }


    @Test
    fun mediatorWithRefreshShouldReturnSuccessIfRemoteCache() = runBlockingTest {

        When calling mockRemoteRepository.getAlbum() itReturns NetworkResponse.Cached

        val callResult = remoteMediator.load(
            LoadType.REFRESH, state = state
        )
        //test
        Verify on mockRemoteRepository that mockRemoteRepository.getAlbum() was called
        VerifyNoFurtherInteractions on mockRemoteRepository
        val response = callResult.shouldBeInstanceOf<RemoteMediator.MediatorResult.Success>()
        response.endOfPaginationReached.shouldBeTrue()
    }

    @Test
    fun mediatorWithRefreshShouldNotCallLocalIfRemoteCache() = runBlockingTest {
        When calling mockRemoteRepository.getAlbum() itReturns NetworkResponse.Cached

        val callResult = remoteMediator.load(
            LoadType.REFRESH, state = state
        )
        //test
        VerifyNoInteractions on mockLocalRepository
        val response = callResult.shouldBeInstanceOf<RemoteMediator.MediatorResult.Success>()
        response.endOfPaginationReached.shouldBeTrue()
    }

    @Test
    fun mediatorWithRefreshShouldCallLocalWhenRemoteSuccess() = runBlockingTest {
        val callResult = remoteMediator.load(
            LoadType.REFRESH, state = state
        )
        //test
        Verify on mockRemoteRepository that mockRemoteRepository.getAlbum() was called
        VerifyNoFurtherInteractions on mockRemoteRepository


        Verify on mockLocalRepository that mockLocalRepository.saveAllPhoto(
            photoData,
            true
        ) was called
        VerifyNoFurtherInteractions on mockLocalRepository

        val response = callResult.shouldBeInstanceOf<RemoteMediator.MediatorResult.Success>()
        response.endOfPaginationReached.shouldBeTrue()
    }

    @Test
    fun mediatorWithRefreshShouldReturnErrorIfLocalSavingFail() = runBlockingTest {

        When calling mockLocalRepository.saveAllPhoto(
            anyOrNull(),
            any()
        ) itThrows IllegalStateException()
        val callResult = remoteMediator.load(
            LoadType.REFRESH, state = state
        )
        //test
        Verify on mockRemoteRepository that mockRemoteRepository.getAlbum() was called
        VerifyNoFurtherInteractions on mockRemoteRepository


        Verify on mockLocalRepository that mockLocalRepository.saveAllPhoto(
            photoData,
            true
        ) was called
        VerifyNoFurtherInteractions on mockLocalRepository

        val response = callResult.shouldBeInstanceOf<RemoteMediator.MediatorResult.Error>()
        response.throwable shouldBeInstanceOf IllegalStateException::class
    }

    @Test
    fun mediatorWithRefreshShouldNotBlocCoroutinesCancellationFromRemote() = runBlockingTest {
        When calling mockRemoteRepository.getAlbum() itThrows CancellationException()

        //test
        coInvoking {
            remoteMediator.load(
                LoadType.REFRESH,
                state = state
            )
        } shouldThrow CancellationException::class
        Verify on mockRemoteRepository that mockRemoteRepository.getAlbum() was called
        VerifyNoFurtherInteractions on mockRemoteRepository
        VerifyNoInteractions on mockLocalRepository
    }

    @Test
    fun mediatorWithRefreshShouldNotBlocCoroutinesCancellationFromLocal() = runBlockingTest {
        When calling mockLocalRepository.saveAllPhoto(
            anyOrNull(),
            any()
        ) itThrows CancellationException()

        //test
        coInvoking {
            remoteMediator.load(
                LoadType.REFRESH,
                state = state
            )
        } shouldThrow CancellationException::class
        Verify on mockRemoteRepository that mockRemoteRepository.getAlbum() was called
        VerifyNoFurtherInteractions on mockRemoteRepository
        Verify on mockLocalRepository that mockLocalRepository.saveAllPhoto(
            anyOrNull(),
            any()
        ) was called
        VerifyNoFurtherInteractions on mockLocalRepository
    }

}