package fr.abennsir.poc.album.app.gallery.injection


import fr.abennsir.poc.album.domain.repository.PhotoRepository

object ApplicationDependenciesResolver {

    private lateinit var dependenciesProvider: ApplicationDependenciesProvider

    fun setDependenciesProvider(dependenciesProvider: ApplicationDependenciesProvider) {
        synchronized(ApplicationDependenciesResolver::class) {
            ApplicationDependenciesResolver.dependenciesProvider = dependenciesProvider
        }
    }

    fun resolveSharedRepository(): PhotoRepository = dependenciesProvider.provideSharedRepository()
}