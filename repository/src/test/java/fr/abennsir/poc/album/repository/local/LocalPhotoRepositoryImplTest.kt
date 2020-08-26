package fr.abennsir.poc.album.repository.local

import android.os.Build
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import app.cash.turbine.test
import fr.abennsir.poc.album.repository.local.database.PhotoDao
import fr.abennsir.poc.album.repository.local.database.PhotoDatabase
import fr.abennsir.poc.album.repository.mockPhoto1Entity
import fr.abennsir.poc.album.repository.mockPhoto2Entity
import fr.abennsir.poc.album.repository.mockPhoto3Entity
import fr.abennsir.poc.album.repository.mockPhoto4Entity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.AnyException
import org.amshove.kluent.coInvoking
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldNotThrow
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import kotlin.time.ExperimentalTime

@ExperimentalCoroutinesApi
@ExperimentalTime
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O])
class LocalPhotoRepositoryImplTest {

    private val data = listOf(mockPhoto1Entity, mockPhoto2Entity)
    private val dataUpdated =
        listOf(mockPhoto1Entity, mockPhoto2Entity, mockPhoto3Entity, mockPhoto4Entity)

    //    @get:Rule
//    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var database: PhotoDatabase
    private lateinit var photosDao: PhotoDao
    private lateinit var localRepository: LocalPhotoRepositoryImpl

    @Before
    fun setUp() {
        // using an in-memory database because the information stored here disappears after test
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            PhotoDatabase::class.java
        )
            // allowing main thread queries, just for testing
            .allowMainThreadQueries()
            .build()
        photosDao = database.photosDao()
        localRepository = LocalPhotoRepositoryImpl(database)
    }

    @Test
    fun saveAllPhoto() {
        runBlocking {
            coInvoking { localRepository.saveAllPhoto(data) } shouldNotThrow AnyException
        }
    }


    @Test
    fun saveAllPhotoWithClearShouldNotThrow() {

        runBlocking {
            localRepository.saveAllPhoto(data)
            coInvoking {
                localRepository.saveAllPhoto(
                    dataUpdated,
                    true
                )
            } shouldNotThrow AnyException


            localRepository.getPhotos().test {
                expectItem() shouldBeEqualTo dataUpdated
                cancelAndIgnoreRemainingEvents()
            }
        }
    }
}