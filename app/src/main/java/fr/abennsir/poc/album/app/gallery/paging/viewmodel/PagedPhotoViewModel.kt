package fr.abennsir.poc.album.app.gallery.paging.viewmodel


import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.insertSeparators
import androidx.paging.map
import fr.abennsir.poc.album.R
import fr.abennsir.poc.album.app.gallery.data.UiModel
import fr.abennsir.poc.album.app.gallery.data.toUiData
import fr.abennsir.poc.album.domain.interactor.PhotoUsesCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

/**
 * ViewModel for the Album screen and detail photo screen.
 * The ViewModel works with the [PhotoUsesCase] to get the data.
 */
@ExperimentalCoroutinesApi
class PagedPhotoViewModel(usesCase: PhotoUsesCase, application: Application) :
    AndroidViewModel(application) {

    private val flow = usesCase.retrievePhotoStream()
        .map { pagingData ->
            pagingData.map { it.toUiData() }
        }
        .flowOn(Dispatchers.Default)
        .cachedIn(viewModelScope)


    private val sectionedPagedData = flow.map {
        // add here header with album title
        it.insertSeparators<UiModel.PhotoItem, UiModel> { before, after ->
            if (after == null) {
                // we're at the end of the list
                return@insertSeparators null
            }
            // check between 2 items
            if (before == null || before.albumId != after.albumId) {
                val title = (getApplication() as Context).getString(
                    R.string.album_title,
                    after.albumId
                )
                UiModel.AlbumItem(title = title, id = after.albumId)
            } else {
                null
            }
        }
    }
        .flowOn(Dispatchers.Default)
        .cachedIn(viewModelScope)

    fun getPhotosSectionedByAlbum(): Flow<PagingData<UiModel>> = sectionedPagedData

    fun observePhotosStream(): Flow<PagingData<UiModel.PhotoItem>> = flow


}