package fr.abennsir.poc.album.repository


import android.content.Context
import fr.abennsir.poc.album.domain.repository.PhotoRepository
import fr.abennsir.poc.album.repository.local.LocalPhotoRepositoryImpl
import fr.abennsir.poc.album.repository.local.database.PhotoDatabase
import fr.abennsir.poc.album.repository.remote.RemotePhotoRepositoryImpl
import fr.abennsir.poc.album.repository.remote.api.PhotoService

/**
 * Factory class to create the PhotoRepository
 */
class PhotoRepositoryFactory {
    companion object {
        private const val DEFAULT_CACHE_SIZE = 5L * 1024 * 1024 // 5 MB
    }

    //FIXME type safe builder.
    fun create(
        context: Context,
        cacheSize: Long = DEFAULT_CACHE_SIZE
    ): PhotoRepository {
        val local = LocalPhotoRepositoryImpl(PhotoDatabase.getInstance(context))
        val photoService = PhotoService.create(context, cacheSize)
        val remote = RemotePhotoRepositoryImpl(photoService)
        return PhotoRepositoryImpl(
            localPhotoRepository = local, remotePhotoRepository = remote
        )
    }

}