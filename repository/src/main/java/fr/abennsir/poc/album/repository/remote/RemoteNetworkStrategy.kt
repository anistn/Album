package fr.abennsir.poc.album.repository.remote

import fr.abennsir.poc.album.repository.data.NetworkResponse
import kotlinx.coroutines.CancellationException
import retrofit2.Response

internal suspend fun <T> getApiResponse(call: suspend () -> Response<T>): NetworkResponse<T> =
    getApiResponse(call = call, mapper = { it })

internal suspend fun <T, R> getApiResponse(
    call: suspend () -> Response<T>,
    mapper: (T) -> R
): NetworkResponse<R> {
    return try {
        val apiResponse = call()
        val isFromCache = apiResponse.isSuccessful && apiResponse.raw().cacheResponse() != null
        return if (isFromCache) {
            NetworkResponse.Cached
        } else {
            val netWorkData = apiResponse.body()
            if (netWorkData != null) {
                NetworkResponse.Fresh(mapper(netWorkData))
            } else {
                NetworkResponse.Error(IllegalStateException("Response success with empty body"))
            }
        }
        //We need to rethrow CancellationException or suspend cancellation will be broken.
    } catch (error: CancellationException) {
        throw error
    } catch (error: Throwable) {
        NetworkResponse.Error(error)
    }
}