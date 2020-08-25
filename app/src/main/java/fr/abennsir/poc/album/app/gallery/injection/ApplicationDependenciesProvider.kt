package fr.abennsir.poc.album.app.gallery.injection

import android.content.Context
import fr.abennsir.poc.album.domain.repository.PhotoRepository
import fr.abennsir.poc.album.repository.PhotoRepositoryFactory

interface ApplicationDependenciesProvider {

    fun provideSharedRepository(): PhotoRepository
}


class DefaultDependenciesProvider(private val applicationContext: Context) :
    ApplicationDependenciesProvider {
    private val repository: PhotoRepository by lazy {
        PhotoRepositoryFactory().create(applicationContext)
    }

    override fun provideSharedRepository(): PhotoRepository = repository
}