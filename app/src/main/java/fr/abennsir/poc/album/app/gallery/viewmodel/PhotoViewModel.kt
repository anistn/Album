package fr.abennsir.poc.album.app.gallery.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import fr.abennsir.poc.album.R
import fr.abennsir.poc.album.app.core.mapper.getPresentationMessage
import fr.abennsir.poc.album.app.core.ui.SingleLiveEvent
import fr.abennsir.poc.album.app.gallery.data.ScreenState
import fr.abennsir.poc.album.app.gallery.data.UiModel
import fr.abennsir.poc.album.app.gallery.data.toUiData
import fr.abennsir.poc.album.domain.data.Photo
import fr.abennsir.poc.album.domain.data.Resource
import fr.abennsir.poc.album.domain.interactor.PhotoUsesCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.launch

/**
 * ViewModel for the Album screen and detail photo screen.
 * The ViewModel works with the [PhotoUsesCase] to get the data.
 */
@ExperimentalCoroutinesApi
class PhotoViewModel(private val usesCase: PhotoUsesCase, application: Application) :
    AndroidViewModel(application) {

    private val errorLiveDate = SingleLiveEvent<String>()
    private val screenState = MutableLiveData<ScreenState>()
    private val photoLiveData = MutableLiveData<List<UiModel>>()


    init {
        viewModelScope.launch {
            usesCase.retrieveAllPhotoStream()
                .conflate()
                .collectLatest {
                    when (it) {
                        is Resource.Success -> {
                            photoLiveData.value = mapResource(it.data)
                            screenState.value =
                                if (it.data.isEmpty()) ScreenState.EMPTY else ScreenState.IDLE
                        }
                        is Resource.Loading -> {
                            it.data?.let { result ->
                                photoLiveData.value = mapResource(result)
                            }
                            screenState.value =
                                if (photoLiveData.value.isNullOrEmpty()) ScreenState.LOADING else ScreenState.REFRESH
                        }
                        is Resource.Error -> {
                            errorLiveDate.value = it.throwable.getPresentationMessage(
                                application
                            )
                                .toString()
                            screenState.value =
                                if (photoLiveData.value.isNullOrEmpty()) ScreenState.EMPTY_ERROR else ScreenState.IDLE
                        }
                    }
                }
        }
    }

    fun getPhotosStream(): LiveData<List<UiModel>> = photoLiveData
    fun getErrorStream(): LiveData<String> = errorLiveDate
    fun getScreenStateStream(): LiveData<ScreenState> = screenState

    fun synchronize() {
        loadPhotos()
    }

    fun retry() {
        loadPhotos()
    }

    private fun loadPhotos() {
        viewModelScope.launch {
            usesCase.synchronizePhotos()
                .conflate()
                .collectLatest { resource ->
                    when (resource) {
                        is Resource.Loading -> screenState.value =
                            if (photoLiveData.value.isNullOrEmpty()) ScreenState.LOADING else ScreenState.REFRESH
                        is Resource.Success -> {
                            if (!photoLiveData.value.isNullOrEmpty()) {
                                screenState.value = ScreenState.IDLE
                            }
                        }

                        is Resource.Error -> {
                            screenState.value =
                                if (photoLiveData.value.isNullOrEmpty()) ScreenState.EMPTY_ERROR else ScreenState.IDLE
                            errorLiveDate.value = resource.throwable.getPresentationMessage(
                                getApplication()
                            )
                                .toString()
                        }

                    }
                }
        }
    }

    private fun mapResource(data: List<Photo>): List<UiModel> {
        val map = data.groupBy { item -> item.albumId }
        return map.flatMap { (group, list) ->
            val title = (getApplication() as Context).getString(R.string.album_title, group)
            mutableListOf<UiModel>(UiModel.AlbumItem(title, group)).apply {
                //create mapper here.
                addAll(list.map {
                    it.toUiData()
                })
            }
        }
    }

}