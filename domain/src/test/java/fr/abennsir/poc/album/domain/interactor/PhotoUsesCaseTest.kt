package fr.abennsir.poc.album.domain.interactor

import com.nhaarman.mockitokotlin2.mock
import fr.abennsir.poc.album.domain.repository.PhotoRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.*
import org.junit.Before
import org.junit.Test


@FlowPreview
@ExperimentalCoroutinesApi
class PhotoUsesCaseTest {

    private val mockRepo = mock<PhotoRepository>()
    private lateinit var usesCase: PhotoUsesCase

    @Before
    fun setUp() {
        usesCase = PhotoUsesCase(mockRepo)
    }

    @Test
    fun retrievePhotoStream() = runBlockingTest {
        usesCase.retrievePhotoStream()
        Verify on mockRepo that mockRepo.getPagedPhotoStream() was called
        VerifyNoFurtherInteractions on mockRepo

    }

    @Test
    fun retrieveAllPhotoStream() = runBlockingTest {
        usesCase.retrieveAllPhotoStream()
        Verify on mockRepo that mockRepo.getPhotoStreamAsResource() was called
        VerifyNoFurtherInteractions on mockRepo
    }

    @Test
    fun synchronizePhotos() = runBlockingTest {
        usesCase.synchronizePhotos()
        Verify on mockRepo that mockRepo.synchronizePhoto() was called
        VerifyNoFurtherInteractions on mockRepo
    }
}