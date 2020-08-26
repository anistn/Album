[repository](../../index.md) / [fr.abennsir.poc.album.repository.local](../index.md) / [LocalPhotoRepository](./index.md)

# LocalPhotoRepository

`internal interface LocalPhotoRepository`

### Functions

| Name | Summary |
|---|---|
| [createPagedPhoto](create-paged-photo.md) | return a paged source of Photo.`abstract fun createPagedPhoto(): PagingSource<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, `[`PhotoEntity`](../../fr.abennsir.poc.album.repository.data/-photo-entity/index.md)`>` |
| [getPhotos](get-photos.md) | return Flow of all saved photos`abstract fun getPhotos(): Flow<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PhotoEntity`](../../fr.abennsir.poc.album.repository.data/-photo-entity/index.md)`>>` |
| [saveAllPhoto](save-all-photo.md) | save on local storage the passed [photoEntities](save-all-photo.md#fr.abennsir.poc.album.repository.local.LocalPhotoRepository$saveAllPhoto(kotlin.collections.List((fr.abennsir.poc.album.repository.data.PhotoEntity)), kotlin.Boolean)/photoEntities). If the [needToCleanOld](save-all-photo.md#fr.abennsir.poc.album.repository.local.LocalPhotoRepository$saveAllPhoto(kotlin.collections.List((fr.abennsir.poc.album.repository.data.PhotoEntity)), kotlin.Boolean)/needToCleanOld) is true the repository must clear all saved photos otherwise just append.`abstract suspend fun saveAllPhoto(photoEntities: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PhotoEntity`](../../fr.abennsir.poc.album.repository.data/-photo-entity/index.md)`>, needToCleanOld: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [LocalPhotoRepositoryImpl](../-local-photo-repository-impl/index.md) | `class LocalPhotoRepositoryImpl : `[`LocalPhotoRepository`](./index.md) |
