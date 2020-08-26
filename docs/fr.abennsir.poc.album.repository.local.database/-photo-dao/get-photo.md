[repository](../../index.md) / [fr.abennsir.poc.album.repository.local.database](../index.md) / [PhotoDao](index.md) / [getPhoto](./get-photo.md)

# getPhoto

`abstract fun getPhoto(): Flow<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PhotoEntity`](../../fr.abennsir.poc.album.repository.data/-photo-entity/index.md)`>>`

We are using PagingSource to load on demand the saved photos.
Otherwise all photo will be in memory

