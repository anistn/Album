package fr.abennsir.poc.album.app.gallery.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.abennsir.poc.album.app.gallery.paging.viewmodel.PagedPhotoViewModel
import fr.abennsir.poc.album.app.gallery.simple.viewmodel.PhotoViewModel
import fr.abennsir.poc.album.domain.interactor.PhotoUsesCase
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Factory for ViewModels
 */
@ExperimentalCoroutinesApi
class ViewModelFactory(private val usesCase: PhotoUsesCase, private val application: Application) :
    ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PhotoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return PhotoViewModel(usesCase, application) as T
        } else if (modelClass.isAssignableFrom(PagedPhotoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return PagedPhotoViewModel(usesCase, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}