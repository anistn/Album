[repository](../../index.md) / [fr.abennsir.poc.album.repository](../index.md) / [PhotoRepositoryImpl](./index.md)

# PhotoRepositoryImpl

`internal class PhotoRepositoryImpl : PhotoRepository`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PhotoRepositoryImpl(config: PagingConfig, localPhotoRepository: `[`LocalPhotoRepository`](../../fr.abennsir.poc.album.repository.local/-local-photo-repository/index.md)`, remotePhotoRepository: `[`RemotePhotoRepository`](../../fr.abennsir.poc.album.repository.remote/-remote-photo-repository/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [config](config.md) | `val config: PagingConfig` |
| [localPhotoRepository](local-photo-repository.md) | `val localPhotoRepository: `[`LocalPhotoRepository`](../../fr.abennsir.poc.album.repository.local/-local-photo-repository/index.md) |
| [remotePhotoRepository](remote-photo-repository.md) | `val remotePhotoRepository: `[`RemotePhotoRepository`](../../fr.abennsir.poc.album.repository.remote/-remote-photo-repository/index.md) |

### Functions

| Name | Summary |
|---|---|
| [getPagedPhotoStream](get-paged-photo-stream.md) | `fun getPagedPhotoStream(): Flow<PagingData<Photo>>` |
| [getPhotoStreamAsResource](get-photo-stream-as-resource.md) | `fun getPhotoStreamAsResource(): Flow<Resource<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Photo>>>` |
| [synchronizePhoto](synchronize-photo.md) | `fun synchronizePhoto(): Flow<Resource<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>>` |
