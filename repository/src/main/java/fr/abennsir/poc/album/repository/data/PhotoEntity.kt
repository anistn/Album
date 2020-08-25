package fr.abennsir.poc.album.repository.data

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import fr.abennsir.poc.album.domain.data.Photo

/**
 * since it's a sample object we are using the same entity for local and remote repository data.
 */

@Entity(tableName = "photos", primaryKeys = ["albumId", "id"])
internal data class PhotoEntity(
    @SerializedName("albumId") val albumId: Long = 0,
    @SerializedName("id") val id: Long = 0,
    @SerializedName("title") val title: String = "",
    @SerializedName("url") val url: String = "",
    @SerializedName("thumbnailUrl") val thumbnailUrl: String = ""
)

internal fun PhotoEntity.toPhoto(): Photo =
    Photo(albumId = albumId, id = id, title = title, url = url, thumbnailUrl = thumbnailUrl)


internal sealed class NetworkResponse<out T> {
    // Successful results are stored in data
    internal data class Fresh<out T>(val data: T) : NetworkResponse<T>()

    // By using Nothing as T, all NetworkError instances are a subtypes of all NetworkResults<T>
    internal data class Error(val exception: Throwable) : NetworkResponse<Nothing>()
    internal object Cached : NetworkResponse<Nothing>()
}