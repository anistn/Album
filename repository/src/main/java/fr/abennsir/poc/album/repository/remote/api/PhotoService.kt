package fr.abennsir.poc.album.repository.remote.api


import android.content.Context
import fr.abennsir.poc.album.repository.data.PhotoEntity
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


/**
 * Github API communication setup via Retrofit.
 */
internal interface PhotoService {

    @GET("/img/shared/technical-test.json")
    suspend fun getPhotoAlbum(): Response<List<PhotoEntity>>

    companion object {
        private const val BASE_URL = "https://static.leboncoin.fr"
        private const val DEFAULT_CACHE_SIZE = 5L * 1024 * 1024 // 5 MB

        fun create(context: Context, cacheSize: Long = DEFAULT_CACHE_SIZE): PhotoService {
            val logger = HttpLoggingInterceptor()
            logger.level = Level.BASIC

            val cache = Cache(context.cacheDir, cacheSize)
            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .cache(cache)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PhotoService::class.java)
        }
    }
}