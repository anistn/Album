package fr.abennsir.poc.album.repository.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.abennsir.poc.album.repository.data.PhotoEntity

@Database(
    entities = [PhotoEntity::class],
    version = 2,
    exportSchema = false
)
internal abstract class PhotoDatabase : RoomDatabase() {

    abstract fun photosDao(): PhotoDao

    companion object {

        @Volatile
        private var INSTANCE: PhotoDatabase? = null
        private const val DATABASE_NAME = "Album.db"

        fun getInstance(context: Context): PhotoDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                PhotoDatabase::class.java, DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
    }
}