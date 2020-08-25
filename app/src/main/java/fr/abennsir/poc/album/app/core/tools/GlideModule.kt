package fr.abennsir.poc.album.app.core.tools

import android.content.Context
import android.webkit.WebSettings
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.io.InputStream


@GlideModule
class GlideModule : AppGlideModule() {


    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        super.registerComponents(context, glide, registry)


        GlobalScope.launch(Dispatchers.Default) {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.HEADERS
            val factory: OkHttpUrlLoader.Factory = OkHttpUrlLoader.Factory(
                OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .addInterceptor(UserAgentInterceptor(context.applicationContext))
                    .build()
            )
            glide.registry.replace(GlideUrl::class.java, InputStream::class.java, factory)
        }

    }

    class UserAgentInterceptor(private val context: Context) : Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest: Request = chain.request()
            val requestWithUserAgent: Request = originalRequest.newBuilder()
                .header("User-Agent", WebSettings.getDefaultUserAgent(context))
                .build()

            return chain.proceed(requestWithUserAgent)
        }
    }

}