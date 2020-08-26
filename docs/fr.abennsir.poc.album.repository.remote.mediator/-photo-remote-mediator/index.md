[repository](../../index.md) / [fr.abennsir.poc.album.repository.remote.mediator](../index.md) / [PhotoRemoteMediator](./index.md)

# PhotoRemoteMediator

`internal class PhotoRemoteMediator : RemoteMediator<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, `[`PhotoEntity`](../../fr.abennsir.poc.album.repository.data/-photo-entity/index.md)`>`

Remote mediator witch handle remote network load and local saving strategies.
Since Api is not paged we will only load on Refresh from API.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Remote mediator witch handle remote network load and local saving strategies. Since Api is not paged we will only load on Refresh from API.`PhotoRemoteMediator(remotePhotoRepository: `[`RemotePhotoRepository`](../../fr.abennsir.poc.album.repository.remote/-remote-photo-repository/index.md)`, localPhotoRepository: `[`LocalPhotoRepository`](../../fr.abennsir.poc.album.repository.local/-local-photo-repository/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [localPhotoRepository](local-photo-repository.md) | `val localPhotoRepository: `[`LocalPhotoRepository`](../../fr.abennsir.poc.album.repository.local/-local-photo-repository/index.md) |
| [remotePhotoRepository](remote-photo-repository.md) | `val remotePhotoRepository: `[`RemotePhotoRepository`](../../fr.abennsir.poc.album.repository.remote/-remote-photo-repository/index.md) |

### Functions

| Name | Summary |
|---|---|
| [load](load.md) | `suspend fun load(loadType: LoadType, state: PagingState<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, `[`PhotoEntity`](../../fr.abennsir.poc.album.repository.data/-photo-entity/index.md)`>): MediatorResult` |
