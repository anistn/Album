package fr.abennsir.poc.album.repository


import android.content.Context
import androidx.paging.PagingConfig
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
        private const val DEFAULT_PAGE_SIZE = 200

        /**
         * Avoid setting [PagingConfig.maxSize] since page will be dropped and never restored.
         */
        private val DEFAULT_PAGE_CONFIG = PagingConfig(
            pageSize = DEFAULT_PAGE_SIZE,
            enablePlaceholders = false
        )
    }

    //FIXME type safe builder.
    fun create(
        context: Context,
        pageConfig: PagingConfig = DEFAULT_PAGE_CONFIG,
        cacheSize: Long = DEFAULT_CACHE_SIZE
    ): PhotoRepository {
        val local = LocalPhotoRepositoryImpl(PhotoDatabase.getInstance(context))
        val photoService = PhotoService.create(context, cacheSize)
        val remote = RemotePhotoRepositoryImpl(photoService)
        return PhotoRepositoryImpl(
            config = pageConfig,
            localPhotoRepository = local,
            remotePhotoRepository = remote
        )
    }

}