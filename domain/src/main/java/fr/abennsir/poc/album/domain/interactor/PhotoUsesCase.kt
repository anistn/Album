package fr.abennsir.poc.album.domain.interactor

import androidx.paging.PagingData
import fr.abennsir.poc.album.domain.data.Photo
import fr.abennsir.poc.album.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow


/**
 * uses case for Photos.
 */
class PhotoUsesCase(private val repository: PhotoRepository) {

    /**
     * the saved photo flow.
     */
    fun retrieveAllPhotoStream() = repository.getPhotoStreamAsResource()

    /**
     * synchronize photo with server.
     */
    fun synchronizePhotos() = repository.synchronizePhoto()

    /**
     * the saved photo as paged flow.
     */
    fun retrievePhotoStream(): Flow<PagingData<Photo>> = repository.getPagedPhotoStream()
}