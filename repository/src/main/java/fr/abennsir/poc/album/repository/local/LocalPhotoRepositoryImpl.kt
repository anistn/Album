package fr.abennsir.poc.album.repository.local


import androidx.room.withTransaction
import fr.abennsir.poc.album.repository.data.PhotoEntity
import fr.abennsir.poc.album.repository.local.database.PhotoDatabase
import kotlinx.coroutines.flow.Flow

internal class LocalPhotoRepositoryImpl(private val photoDatabase: PhotoDatabase) :
    LocalPhotoRepository {

    private val photoDao by lazy { photoDatabase.photosDao() }

    override suspend fun saveAllPhoto(photoEntities: List<PhotoEntity>, needToCleanOld: Boolean) {
        photoDatabase.withTransaction {
            // clear all tables in the database
            if (needToCleanOld) {
                photoDao.clearAllPhotos()
            }
            photoDao.insertAll(photoEntities)
        }
    }

    override fun getPhotos(): Flow<List<PhotoEntity>> = photoDao.getPhoto()


}