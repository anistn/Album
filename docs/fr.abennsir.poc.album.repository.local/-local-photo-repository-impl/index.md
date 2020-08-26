[repository](../../index.md) / [fr.abennsir.poc.album.repository.local](../index.md) / [LocalPhotoRepositoryImpl](./index.md)

# LocalPhotoRepositoryImpl

`internal class LocalPhotoRepositoryImpl : `[`LocalPhotoRepository`](../-local-photo-repository/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `LocalPhotoRepositoryImpl(photoDatabase: `[`PhotoDatabase`](../../fr.abennsir.poc.album.repository.local.database/-photo-database/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [photoDao](photo-dao.md) | `val photoDao: `[`PhotoDao`](../../fr.abennsir.poc.album.repository.local.database/-photo-dao/index.md) |
| [photoDatabase](photo-database.md) | `val photoDatabase: `[`PhotoDatabase`](../../fr.abennsir.poc.album.repository.local.database/-photo-database/index.md) |

### Functions

| Name | Summary |
|---|---|
| [createPagedPhoto](create-paged-photo.md) | return a paged source of Photo.`fun createPagedPhoto(): PagingSource<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, `[`PhotoEntity`](../../fr.abennsir.poc.album.repository.data/-photo-entity/index.md)`>` |
| [getPhotos](get-photos.md) | return Flow of all saved photos`fun getPhotos(): Flow<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PhotoEntity`](../../fr.abennsir.poc.album.repository.data/-photo-entity/index.md)`>>` |
| [saveAllPhoto](save-all-photo.md) | save on local storage the passed [photoEntities](../-local-photo-repository/save-all-photo.md#fr.abennsir.poc.album.repository.local.LocalPhotoRepository$saveAllPhoto(kotlin.collections.List((fr.abennsir.poc.album.repository.data.PhotoEntity)), kotlin.Boolean)/photoEntities). If the [needToCleanOld](../-local-photo-repository/save-all-photo.md#fr.abennsir.poc.album.repository.local.LocalPhotoRepository$saveAllPhoto(kotlin.collections.List((fr.abennsir.poc.album.repository.data.PhotoEntity)), kotlin.Boolean)/needToCleanOld) is true the repository must clear all saved photos otherwise just append.`suspend fun saveAllPhoto(photoEntities: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PhotoEntity`](../../fr.abennsir.poc.album.repository.data/-photo-entity/index.md)`>, needToCleanOld: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
