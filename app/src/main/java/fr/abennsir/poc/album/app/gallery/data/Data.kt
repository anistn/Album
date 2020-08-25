package fr.abennsir.poc.album.app.gallery.data

import android.os.Parcelable
import androidx.annotation.Keep
import fr.abennsir.poc.album.domain.data.Photo
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

sealed class UiModel {
    @Parcelize
    data class PhotoItem(
        val id: Long = 0, val albumId: Long = 0, val title: String = "",
        val url: String = "", val thumbnailUrl: String = ""
    ) : UiModel(),
        Parcelable


    data class AlbumItem(val title: String, val id: Long) : UiModel()
}

fun Photo.toUiData() = UiModel.PhotoItem(
    id = id, albumId = albumId, thumbnailUrl = thumbnailUrl,
    title = title, url = url
)


enum class ScreenState {
    EMPTY, LOADING, REFRESH, IDLE, EMPTY_ERROR
}