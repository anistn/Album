[repository](../../index.md) / [fr.abennsir.poc.album.repository.remote](../index.md) / [RemotePhotoRepositoryImpl](./index.md)

# RemotePhotoRepositoryImpl

`internal class RemotePhotoRepositoryImpl : `[`RemotePhotoRepository`](../-remote-photo-repository/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RemotePhotoRepositoryImpl(photoService: `[`PhotoService`](../../fr.abennsir.poc.album.repository.remote.api/-photo-service/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [photoService](photo-service.md) | `val photoService: `[`PhotoService`](../../fr.abennsir.poc.album.repository.remote.api/-photo-service/index.md) |

### Functions

| Name | Summary |
|---|---|
| [getAlbum](get-album.md) | `suspend fun getAlbum(): `[`NetworkResponse`](../../fr.abennsir.poc.album.repository.data/-network-response/index.md)`<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PhotoEntity`](../../fr.abennsir.poc.album.repository.data/-photo-entity/index.md)`>>` |
