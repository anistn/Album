[domain](../../index.md) / [fr.abennsir.poc.album.domain.interactor](../index.md) / [PhotoUsesCase](./index.md)

# PhotoUsesCase

`class PhotoUsesCase`

uses case for Photos.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | uses case for Photos.`PhotoUsesCase(repository: `[`PhotoRepository`](../../fr.abennsir.poc.album.domain.repository/-photo-repository/index.md)`)` |

### Functions

| Name | Summary |
|---|---|
| [retrieveAllPhotoStream](retrieve-all-photo-stream.md) | the saved photo flow.`fun retrieveAllPhotoStream(): Flow<`[`Resource`](../../fr.abennsir.poc.album.domain.data/-resource/index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Photo`](../../fr.abennsir.poc.album.domain.data/-photo/index.md)`>>>` |
| [retrievePhotoStream](retrieve-photo-stream.md) | the saved photo as paged flow.`fun retrievePhotoStream(): Flow<PagingData<`[`Photo`](../../fr.abennsir.poc.album.domain.data/-photo/index.md)`>>` |
| [synchronizePhotos](synchronize-photos.md) | synchronize photo with server.`fun synchronizePhotos(): Flow<`[`Resource`](../../fr.abennsir.poc.album.domain.data/-resource/index.md)`<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>>` |
