package fr.abennsir.poc.album.repository.local

import androidx.paging.PagingSource
import fr.abennsir.poc.album.repository.data.PhotoEntity
import kotlinx.coroutines.flow.Flow

internal interface LocalPhotoRepository {

    /**
     * save on local storage the passed [photoEntities].
     * If the [needToCleanOld] is true the repository must clear all saved photos otherwise just append.
     */
    suspend fun saveAllPhoto(photoEntities: List<PhotoEntity>, needToCleanOld: Boolean = false)

    /**
     * return Flow of all saved photos
     */
    fun getPhotos(): Flow<List<PhotoEntity>>

    /**
     * return a paged source of Photo.
     */
    fun createPagedPhoto(): PagingSource<Int, PhotoEntity>
}

