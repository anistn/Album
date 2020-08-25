package fr.abennsir.poc.album.app.core.mapper

import android.content.Context
import com.google.gson.JsonIOException
import com.google.gson.JsonParseException
import fr.abennsir.poc.album.R
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


fun Throwable.getPresentationMessage(context: Context): CharSequence {
    return when (this) {
        is SocketTimeoutException, is UnknownHostException -> context.getString(
            R.string.network_access_error
        )
        is IOException, is JsonParseException, is HttpException, is JsonIOException -> context.getString(
            R.string.unexpected_error
        )
        else -> context.getString(
            R.string.unknown_error
        )
    }
}