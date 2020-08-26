[repository](../../index.md) / [fr.abennsir.poc.album.repository.local.database](../index.md) / [PhotoDao](index.md) / [getPagedPhoto](./get-paged-photo.md)

# getPagedPhoto

`abstract fun getPagedPhoto(): PagingSource<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, `[`PhotoEntity`](../../fr.abennsir.poc.album.repository.data/-photo-entity/index.md)`>`

We are using PagingSource to load on demand the saved photos.
Otherwise all photo will be in memory as [getPhoto](get-photo.md)

