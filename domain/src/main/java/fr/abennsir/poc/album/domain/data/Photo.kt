package fr.abennsir.poc.album.domain.data

/**
 * Data class to present user photo
 */
data class Photo(val albumId: Long = 0, val id: Long = 0, val title: String = "",
                 val url: String = "", val thumbnailUrl: String = "")