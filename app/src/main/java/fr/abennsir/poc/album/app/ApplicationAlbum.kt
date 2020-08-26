package fr.abennsir.poc.album.app

import android.app.Application
import android.os.StrictMode
import androidx.appcompat.app.AppCompatDelegate
import fr.abennsir.poc.album.app.gallery.injection.ApplicationDependenciesResolver
import fr.abennsir.poc.album.app.gallery.injection.DefaultDependenciesProvider

class ApplicationAlbum : Application() {
    companion object {
        private const val ACTIVATE_STRICT_MODE = false
    }

    init {
        //this is needed to enable vector drawable for API <21.
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

    }

    override fun onCreate() {
        super.onCreate()
        ApplicationDependenciesResolver.setDependenciesProvider(
            DefaultDependenciesProvider(applicationContext)
        )
        if (ACTIVATE_STRICT_MODE) {
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectAll()
                    // .detectNetwork() or .detectAll() for all detectable problems
                    .penaltyLog()
                    .build()
            )
            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    //avoid death when using Glide, some time socket leaked.
                    //   .penaltyDeath()
                    .build()
            )
        }
    }
}