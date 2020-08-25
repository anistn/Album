package fr.abennsir.poc.album.repository.local.database


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.abennsir.poc.album.repository.data.PhotoEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(photoEntities: List<PhotoEntity>)

    /**
     * We are using PagingSource to load on demand the saved photos.
     * Otherwise all photo will be in memory
     */
    @Query("SELECT * FROM photos ORDER BY albumId, id")
    fun getPhoto(): Flow<List<PhotoEntity>>

    @Query("DELETE FROM photos")
    suspend fun clearAllPhotos()

}