package fr.abennsir.poc.album.repository.local.database

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import app.cash.turbine.test
import fr.abennsir.poc.album.repository.data.PhotoEntity
import fr.abennsir.poc.album.repository.mockPhoto1Entity
import fr.abennsir.poc.album.repository.mockPhoto2Entity
import fr.abennsir.poc.album.repository.mockPhoto3Entity
import fr.abennsir.poc.album.repository.mockPhoto4Entity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.shouldBeEmpty
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import kotlin.time.ExperimentalTime


@ExperimentalCoroutinesApi
@ExperimentalTime
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O])
class PhotoDaoTest {

    private val data = listOf(mockPhoto1Entity, mockPhoto2Entity)
    private val dataUpdated =
        listOf(mockPhoto1Entity, mockPhoto2Entity, mockPhoto3Entity, mockPhoto4Entity)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var database: PhotoDatabase
    private lateinit var photosDao: PhotoDao


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
    }

    @Test
    fun emptyPhotoListWhenDataBaseEmpty() = runBlockingTest {
        database.photosDao().getPhoto().test {
            expectItem().shouldBeEmpty()
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun testSave() = runBlockingTest {
        database.photosDao().insertAll(data)
        database.photosDao().getPhoto().test {
            expectItem() shouldBeEqualTo data
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun testSaveWithReplaceFlowUpdate() = runBlockingTest {
        launch {
            delay(5)
            photosDao.insertAll(data)
            photosDao.insertAll(dataUpdated)
        }
        launch {
            photosDao.getPhoto().test {
                expectItem().shouldBeEmpty()
                expectItem() shouldBeEqualTo data
                expectItem() shouldBeEqualTo dataUpdated
                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @Test
    fun testClearWithFlowUpdate() = runBlockingTest {
        launch {
            delay(5)
            photosDao.insertAll(data)
            photosDao.clearAllPhotos()
        }
        launch {
            photosDao.getPhoto().test {
                expectItem().shouldBeEmpty()
                expectItem() shouldBeEqualTo data
                expectItem().shouldBeEmpty()
                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @Test
    fun testPagedData() = runBlockingTest {
        val photoFlow = Pager(PagingConfig(pageSize = 2)) {
            photosDao.getPagedPhoto()
        }.flow

        launch {
            delay(5)
            photosDao.insertAll(data)
            photosDao.clearAllPhotos()
            photosDao.insertAll(dataUpdated)
        }
        launch {
            photoFlow.test {
                expectItem().shouldBeInstanceOf<PagingData<PhotoEntity>>()
            }
        }
    }

    @After
    fun tearDown() {
        database.close()
    }
}