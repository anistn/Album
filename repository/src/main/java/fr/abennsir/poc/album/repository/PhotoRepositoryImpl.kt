package fr.abennsir.poc.album.repository

import fr.abennsir.poc.album.domain.data.Photo
import fr.abennsir.poc.album.domain.data.Resource
import fr.abennsir.poc.album.domain.repository.PhotoRepository
import fr.abennsir.poc.album.repository.core.fetchResourceAndCache
import fr.abennsir.poc.album.repository.core.getStreamResourceByCacheRefreshStrategy
import fr.abennsir.poc.album.repository.data.toPhoto
import fr.abennsir.poc.album.repository.local.LocalPhotoRepository
import fr.abennsir.poc.album.repository.remote.RemotePhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class PhotoRepositoryImpl(
    private val localPhotoRepository: LocalPhotoRepository,
    private val remotePhotoRepository: RemotePhotoRepository
) : PhotoRepository {

    override fun getPhotoStreamAsResource(): Flow<Resource<List<Photo>>> =
        getStreamResourceByCacheRefreshStrategy(
            databaseQuery = {
                localPhotoRepository.getPhotos().map { list -> list.map { it.toPhoto() } }
            },
            networkCall = { remotePhotoRepository.getAlbum() },
            saveCallResult = { photoEntities ->
                localPhotoRepository.saveAllPhoto(photoEntities)

            }
        )

    override fun synchronizePhoto(): Flow<Resource<Unit>> = fetchResourceAndCache(
        networkCall = { remotePhotoRepository.getAlbum() },
        saveCallResult = { photoEntities ->
            localPhotoRepository.saveAllPhoto(photoEntities)
        }
    )
}