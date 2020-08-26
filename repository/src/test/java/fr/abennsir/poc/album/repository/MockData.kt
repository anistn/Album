package fr.abennsir.poc.album.repository

import fr.abennsir.poc.album.domain.data.Photo
import fr.abennsir.poc.album.repository.data.PhotoEntity


val mockPhoto1 = Photo(
    albumId = 1,
    id = 1,
    title = "accusamus beatae ad facilis cum similique qui sunt",
    url = "https://via.placeholder.com/600/92c952",
    thumbnailUrl = "https://via.placeholder.com/150/92c952"
)

val mockPhoto2 = Photo(
    albumId = 1,
    id = 2,
    title = "reprehenderit est deserunt velit ipsam",
    url = "https://via.placeholder.com/600/771796",
    thumbnailUrl = "https://via.placeholder.com/150/771796"
)

val mockPhoto3 = Photo(
    albumId = 1, id = 3, title = "officia porro iure quia iusto qui ipsa ut modi",
    url = "https://via.placeholder.com/600/24f355",
    thumbnailUrl = "https://via.placeholder.com/150/24f355"
)

val mockPhoto4 = Photo(
    albumId = 2,
    id = 4,
    title = "culpa odio esse rerum omnis laboriosam voluptate repudiandae",
    url = "https://via.placeholder.com/600/d32776",
    thumbnailUrl = "https://via.placeholder.com/150/d32776"
)

internal val mockPhoto1Entity = PhotoEntity(
    albumId = 1,
    id = 1,
    title = "accusamus beatae ad facilis cum similique qui sunt",
    url = "https://via.placeholder.com/600/92c952",
    thumbnailUrl = "https://via.placeholder.com/150/92c952"
)


internal val mockPhoto2Entity = PhotoEntity(
    albumId = 1,
    id = 2,
    title = "reprehenderit est deserunt velit ipsam",
    url = "https://via.placeholder.com/600/771796",
    thumbnailUrl = "https://via.placeholder.com/150/771796"
)

internal val mockPhoto3Entity = PhotoEntity(
    albumId = 1, id = 3, title = "officia porro iure quia iusto qui ipsa ut modi",
    url = "https://via.placeholder.com/600/24f355",
    thumbnailUrl = "https://via.placeholder.com/150/24f355"
)

internal val mockPhoto4Entity = PhotoEntity(
    albumId = 2,
    id = 4,
    title = "culpa odio esse rerum omnis laboriosam voluptate repudiandae",
    url = "https://via.placeholder.com/600/d32776",
    thumbnailUrl = "https://via.placeholder.com/150/d32776"
)
