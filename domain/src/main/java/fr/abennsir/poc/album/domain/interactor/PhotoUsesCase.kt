package fr.abennsir.poc.album.domain.interactor

import fr.abennsir.poc.album.domain.repository.PhotoRepository


/**
 * uses case for Photos.
 */
class PhotoUsesCase(private val repository: PhotoRepository) {

    fun retrieveAllPhotoStream() = repository.getPhotoStreamAsResource()

    /**
     * synchronize photo with server.
     */
    fun synchronizePhotos() = repository.synchronizePhoto()

}