package fr.abennsir.poc.album.repository.remote.mediator


import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import fr.abennsir.poc.album.repository.data.NetworkResponse
import fr.abennsir.poc.album.repository.data.PhotoEntity
import fr.abennsir.poc.album.repository.local.LocalPhotoRepository
import fr.abennsir.poc.album.repository.remote.RemotePhotoRepository
import kotlinx.coroutines.CancellationException

/**
 * Remote mediator witch handle remote network load and local saving strategies.
 * Since Api is not paged we will only load on Refresh from API.
 */
@OptIn(ExperimentalPagingApi::class)
internal class PhotoRemoteMediator(
    private val remotePhotoRepository: RemotePhotoRepository,
    private val localPhotoRepository: LocalPhotoRepository
) : RemoteMediator<Int, PhotoEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PhotoEntity>
    ): MediatorResult {
        //Since api is not paged, we will handle only  remote Refresh load.
        //this will be called when we first create PageDataSource or when call to refresh data source.
        //otherwise we will return end of pagination.
        if (loadType != LoadType.REFRESH) {
            return MediatorResult.Success(
                endOfPaginationReached = true
            )
        }

        return try {
            when (val response = remotePhotoRepository.getAlbum()) {
                is NetworkResponse.Fresh -> {
                    localPhotoRepository.saveAllPhoto(response.data, true)
                    MediatorResult.Success(endOfPaginationReached = true)
                }
                NetworkResponse.Cached ->  // since the response is cached we will avoid updating database with the same data.
                    MediatorResult.Success(endOfPaginationReached = true)
                //TODO: improve strategy of network service cache,  with cache evict if the local save fail.
                is NetworkResponse.Error -> MediatorResult.Error(response.exception)
            }
        } catch (error: CancellationException) {
            throw error
        } catch (error: Throwable) {
            MediatorResult.Error(error)
        }
    }
}