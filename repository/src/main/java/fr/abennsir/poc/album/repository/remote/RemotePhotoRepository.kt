package fr.abennsir.poc.album.repository.remote

import fr.abennsir.poc.album.repository.data.NetworkResponse
import fr.abennsir.poc.album.repository.data.PhotoEntity


internal interface RemotePhotoRepository {

    suspend fun getAlbum(): NetworkResponse<List<PhotoEntity>>

}