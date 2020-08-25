package fr.abennsir.poc.album.app.gallery.data

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class Config(
    val mode: NavigationMode = NavigationMode.DEFAULT,
    val enablePaging: Boolean = false
) : Parcelable

enum class NavigationMode {
    DEFAULT, SECTIONED
}