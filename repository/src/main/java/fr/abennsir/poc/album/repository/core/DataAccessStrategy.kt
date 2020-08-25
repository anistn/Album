package fr.abennsir.poc.album.repository.core

import fr.abennsir.poc.album.domain.data.Resource
import fr.abennsir.poc.album.repository.data.NetworkResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

/**
 * This function is based on Flow to perform a cache refresh operation.
 * It will map the processed object [T] to [Resource]
 */

internal fun <T : Any, A> getStreamResourceByCacheRefreshStrategy(
    databaseQuery: () -> Flow<T>,
    networkCall: suspend () -> NetworkResponse<A>,
    saveCallResult: suspend (A) -> Unit,
    dispatcher: CoroutineDispatcher = Dispatchers.IO
): Flow<Resource<T>> =
    flow {
        emit(Resource.Loading(null) as Resource<T>)
        val source = databaseQuery.invoke()
        source.firstOrNull()?.let { item ->
            emit(Resource.Loading(item))
        }
        when (val response = networkCall.invoke()) {
            is NetworkResponse.Fresh -> saveCallResult(response.data)
            is NetworkResponse.Cached -> Unit
            is NetworkResponse.Error -> {
                emit(Resource.Error(response.exception))
            }
        }

        //after we still monitor the data base.
        emitAll(source.map { Resource.Success(it) })

    }.flowOn(dispatcher)

/**
 * Stream to monitor network resource fetch and saving.
 * This strategy is used for retry resource when we already observe data from database.
 */
internal fun <A> fetchResourceAndCache(
    networkCall: suspend () -> NetworkResponse<A>,
    saveCallResult: suspend (A) -> Unit,
    dispatcher: CoroutineDispatcher = Dispatchers.IO
): Flow<Resource<Unit>> =
    flow {
        emit(Resource.Loading(Unit))
        when (val response = networkCall.invoke()) {
            is NetworkResponse.Cached ->
                emit(Resource.Success(Unit))
            is NetworkResponse.Fresh -> {
                saveCallResult(response.data)
                emit(Resource.Success(Unit))
            }
            is NetworkResponse.Error -> {
                emit(Resource.Error(response.exception))
            }
        }
    }.flowOn(dispatcher)