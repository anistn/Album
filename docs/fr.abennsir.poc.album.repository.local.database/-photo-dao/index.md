[repository](../../index.md) / [fr.abennsir.poc.album.repository.local.database](../index.md) / [PhotoDao](./index.md)

# PhotoDao

`internal interface PhotoDao`

### Functions

| Name | Summary |
|---|---|
| [clearAllPhotos](clear-all-photos.md) | `abstract suspend fun clearAllPhotos(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getPagedPhoto](get-paged-photo.md) | We are using PagingSource to load on demand the saved photos. Otherwise all photo will be in memory as [getPhoto](get-photo.md)`abstract fun getPagedPhoto(): PagingSource<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, `[`PhotoEntity`](../../fr.abennsir.poc.album.repository.data/-photo-entity/index.md)`>` |
| [getPhoto](get-photo.md) | We are using PagingSource to load on demand the saved photos. Otherwise all photo will be in memory`abstract fun getPhoto(): Flow<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PhotoEntity`](../../fr.abennsir.poc.album.repository.data/-photo-entity/index.md)`>>` |
| [insertAll](insert-all.md) | `abstract suspend fun insertAll(photoEntities: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PhotoEntity`](../../fr.abennsir.poc.album.repository.data/-photo-entity/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
