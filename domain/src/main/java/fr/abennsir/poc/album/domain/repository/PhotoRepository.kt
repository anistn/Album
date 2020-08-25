package fr.abennsir.poc.album.domain.repository

import androidx.paging.PagingData
import fr.abennsir.poc.album.domain.data.Photo
import fr.abennsir.poc.album.domain.data.Resource
import kotlinx.coroutines.flow.Flow

interface PhotoRepository {
	fun getPhotoStreamAsResource(): Flow<Resource<List<Photo>>>

	fun synchronizePhoto(): Flow<Resource<Unit>>

	fun getPagedPhotoStream(): Flow<PagingData<Photo>>
}