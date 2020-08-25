package fr.abennsir.poc.album.repository.remote


import fr.abennsir.poc.album.repository.data.NetworkResponse
import fr.abennsir.poc.album.repository.data.PhotoEntity
import fr.abennsir.poc.album.repository.remote.api.PhotoService

internal class RemotePhotoRepositoryImpl(private val photoService: PhotoService) :
    RemotePhotoRepository {
    override suspend fun getAlbum(): NetworkResponse<List<PhotoEntity>> =
        getApiResponse(call = { photoService.getPhotoAlbum() })
}