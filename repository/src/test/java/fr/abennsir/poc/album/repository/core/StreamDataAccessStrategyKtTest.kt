package fr.abennsir.poc.album.repository.core


import app.cash.turbine.test
import fr.abennsir.poc.album.domain.data.Resource
import fr.abennsir.poc.album.repository.core.tools.SuspendCallProducer
import fr.abennsir.poc.album.repository.core.tools.SuspendCallWatcher
import fr.abennsir.poc.album.repository.data.NetworkResponse
import fr.abennsir.poc.album.repository.data.PhotoEntity
import fr.abennsir.poc.album.repository.mockPhoto1Entity
import fr.abennsir.poc.album.repository.mockPhoto2Entity
import fr.abennsir.poc.album.repository.mockPhoto3Entity
import fr.abennsir.poc.album.repository.mockPhoto4Entity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldBeNull
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.IOException
import java.net.UnknownHostException
import java.util.concurrent.CancellationException
import kotlin.time.ExperimentalTime

@FlowPreview
@ExperimentalCoroutinesApi
@OptIn(ExperimentalTime::class)
class StreamDataAccessStrategyKtTest {

    //TODO: investigate why turbine assert not count into coverage.
    private val testDispatcher = TestCoroutineDispatcher()

    private val data1 = listOf(mockPhoto1Entity, mockPhoto2Entity)
    private val data2 =
        listOf(mockPhoto1Entity, mockPhoto2Entity, mockPhoto3Entity, mockPhoto4Entity)

    private lateinit var dataBaseFlow: ConflatedBroadcastChannel<List<PhotoEntity>>

    private lateinit var networkCall: SuspendCallProducer<NetworkResponse<String>>
    private lateinit var saveCall: SuspendCallWatcher<String, Unit>


    @Before
    fun setUp() {
        dataBaseFlow = ConflatedBroadcastChannel()
        networkCall = SuspendCallProducer { NetworkResponse.Fresh("") }
        saveCall = SuspendCallWatcher {
            //here we offer second list as update from database
            dataBaseFlow.offer(data2)
        }
    }

    @Test
    fun getStreamResourceByCacheRefreshStrategySuccess() = runBlockingTest {

        dataBaseFlow.offer(data1)
        getStreamResourceByCacheRefreshStrategy(
            databaseQuery = { dataBaseFlow.asFlow() },
            networkCall = networkCall::execute,
            saveCallResult = saveCall::execute,
            dispatcher = testDispatcher
        ).test {
            expectItem().shouldBeInstanceOf<Resource.Loading<List<PhotoEntity>>>().let {
                it.data.shouldBeNull()
            }
            expectItem().shouldBeInstanceOf<Resource.Loading<List<PhotoEntity>>>().data shouldBeEqualTo data1
            expectItem().shouldBeInstanceOf<Resource.Success<List<PhotoEntity>>>().data shouldBeEqualTo data2
            cancel()
        }
        //test network and db save called
        networkCall.invokeCount shouldBeEqualTo 1
        saveCall.invokeCount shouldBeEqualTo 1
    }

    @Test
    fun getStreamResourceByCacheRefreshStrategySuccessWithNoCache() = runBlockingTest {

        dataBaseFlow.offer(emptyList())
        getStreamResourceByCacheRefreshStrategy(
            databaseQuery = { dataBaseFlow.asFlow() },
            networkCall = networkCall::execute,
            saveCallResult = saveCall::execute,
            dispatcher = testDispatcher
        ).test {
            expectItem().shouldBeInstanceOf<Resource.Loading<List<PhotoEntity>>>().let {
                it.data.shouldBeNull()
            }
            expectItem().shouldBeInstanceOf<Resource.Loading<List<PhotoEntity>>>().data shouldBeEqualTo emptyList()
            expectItem().shouldBeInstanceOf<Resource.Success<List<PhotoEntity>>>().data shouldBeEqualTo data2
            cancel()
        }
        //test network and db save called
        networkCall.invokeCount shouldBeEqualTo 1
        saveCall.invokeCount shouldBeEqualTo 1
    }

    @Test
    fun getStreamWithApiResponseCacheShouldNotCallSaveDb() = runBlockingTest {

        dataBaseFlow.offer(emptyList())
        networkCall = SuspendCallProducer { NetworkResponse.Cached }

        getStreamResourceByCacheRefreshStrategy(
            databaseQuery = { dataBaseFlow.asFlow() },
            networkCall = networkCall::execute,
            saveCallResult = saveCall::execute,
            dispatcher = testDispatcher
        ).test {
            expectItem().shouldBeInstanceOf<Resource.Loading<List<PhotoEntity>>>().let {
                it.data.shouldBeNull()
            }
            expectItem().shouldBeInstanceOf<Resource.Loading<List<PhotoEntity>>>().data shouldBeEqualTo emptyList()
            expectItem().shouldBeInstanceOf<Resource.Success<List<PhotoEntity>>>().data shouldBeEqualTo emptyList()

            cancel()
        }
        //test network and db save called
        networkCall.invokeCount shouldBeEqualTo 1
        saveCall.invokeCount shouldBeEqualTo 0
    }

    @Test
    fun getStreamWithApiResponseErrorShouldReturnError() = runBlockingTest {

        dataBaseFlow.offer(data1)
        networkCall = SuspendCallProducer { NetworkResponse.Error(UnknownHostException()) }

        getStreamResourceByCacheRefreshStrategy(
            databaseQuery = { dataBaseFlow.asFlow() },
            networkCall = networkCall::execute,
            saveCallResult = saveCall::execute,
            dispatcher = testDispatcher
        ).test {
            expectItem().shouldBeInstanceOf<Resource.Loading<List<PhotoEntity>>>().let {
                it.data.shouldBeNull()
            }
            expectItem().shouldBeInstanceOf<Resource.Loading<List<PhotoEntity>>>().data shouldBeEqualTo data1
            expectItem().shouldBeInstanceOf<Resource.Error<List<PhotoEntity>>>().throwable shouldBeInstanceOf UnknownHostException::class
            expectItem().shouldBeInstanceOf<Resource.Success<List<PhotoEntity>>>().data shouldBeEqualTo data1
            cancel()
        }
        //test network and db save called
        networkCall.invokeCount shouldBeEqualTo 1
        saveCall.invokeCount shouldBeEqualTo 0
    }


    @Test
    fun dbFlowShouldNotBlocCancellation() = runBlockingTest {

        launch {
            getStreamResourceByCacheRefreshStrategy(
                databaseQuery = {
                    dataBaseFlow.asFlow()
                },
                networkCall = networkCall::execute,
                saveCallResult = saveCall::execute,
                dispatcher = testDispatcher
            ).test {
                expectItem().shouldBeInstanceOf<Resource.Loading<List<PhotoEntity>>>().let {
                    it.data.shouldBeNull()
                }
                expectError() shouldBeInstanceOf (IOException::class)
            }
        }

        launch {
            dataBaseFlow.close(IOException())
        }

        //test network and db save called
        networkCall.invokeCount shouldBeEqualTo 0
        saveCall.invokeCount shouldBeEqualTo 0
    }


    @Test
    fun networkCallShouldNotBlocCancellation() = runBlockingTest {

        dataBaseFlow.offer(data1)
        networkCall = SuspendCallProducer { throw CancellationException() }

        getStreamResourceByCacheRefreshStrategy(
            databaseQuery = {
                dataBaseFlow.asFlow()
            },
            networkCall = networkCall::execute,
            saveCallResult = saveCall::execute,
            dispatcher = testDispatcher
        ).test {
            expectItem().shouldBeInstanceOf<Resource.Loading<List<PhotoEntity>>>().let {
                it.data.shouldBeNull()
            }
            expectItem().shouldBeInstanceOf<Resource.Loading<List<PhotoEntity>>>().data shouldBeEqualTo data1
        }

        //test network and db save called
        networkCall.invokeCount shouldBeEqualTo 1
        saveCall.invokeCount shouldBeEqualTo 0

    }

    @Test
    fun saveCallShouldNotBlocCancellation() = runBlockingTest {

        dataBaseFlow.offer(data1)
        saveCall = SuspendCallWatcher {
            //here we offer second list as update from database
            throw CancellationException()
        }

        getStreamResourceByCacheRefreshStrategy(
            databaseQuery = {
                dataBaseFlow.asFlow()
            },
            networkCall = networkCall::execute,
            saveCallResult = saveCall::execute,
            dispatcher = testDispatcher
        ).test {
            expectItem().shouldBeInstanceOf<Resource.Loading<List<PhotoEntity>>>().let {
                it.data.shouldBeNull()
            }
            expectItem().shouldBeInstanceOf<Resource.Loading<List<PhotoEntity>>>().data shouldBeEqualTo data1
        }

        //test network and db save called
        networkCall.invokeCount shouldBeEqualTo 1
        saveCall.invokeCount shouldBeEqualTo 1

    }


    @Test
    fun saveCallErrorShouldThrowIfError() = runBlockingTest {

        dataBaseFlow.offer(data1)
        saveCall = SuspendCallWatcher {
            //here we offer second list as update from database
            throw IOException()
        }

        getStreamResourceByCacheRefreshStrategy(
            databaseQuery = {
                dataBaseFlow.asFlow()
            },
            networkCall = networkCall::execute,
            saveCallResult = saveCall::execute,
            dispatcher = testDispatcher
        ).test {
            expectItem().shouldBeInstanceOf<Resource.Loading<List<PhotoEntity>>>().let {
                it.data.shouldBeNull()
            }
            expectItem().shouldBeInstanceOf<Resource.Loading<List<PhotoEntity>>>().data shouldBeEqualTo data1
            expectError() shouldBeInstanceOf IOException::class
        }

        //test network and db save called
        networkCall.invokeCount shouldBeEqualTo 1
        saveCall.invokeCount shouldBeEqualTo 1

    }

    @After
    fun tearDown() {
        testDispatcher.cleanupTestCoroutines()
    }
}