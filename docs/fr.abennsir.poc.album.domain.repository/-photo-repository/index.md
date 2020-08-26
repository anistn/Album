[domain](../../index.md) / [fr.abennsir.poc.album.domain.repository](../index.md) / [PhotoRepository](./index.md)

# PhotoRepository

`interface PhotoRepository`

### Functions

| Name | Summary |
|---|---|
| [getPagedPhotoStream](get-paged-photo-stream.md) | `abstract fun getPagedPhotoStream(): Flow<PagingData<`[`Photo`](../../fr.abennsir.poc.album.domain.data/-photo/index.md)`>>` |
| [getPhotoStreamAsResource](get-photo-stream-as-resource.md) | `abstract fun getPhotoStreamAsResource(): Flow<`[`Resource`](../../fr.abennsir.poc.album.domain.data/-resource/index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Photo`](../../fr.abennsir.poc.album.domain.data/-photo/index.md)`>>>` |
| [synchronizePhoto](synchronize-photo.md) | `abstract fun synchronizePhoto(): Flow<`[`Resource`](../../fr.abennsir.poc.album.domain.data/-resource/index.md)`<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>>` |
