[repository](../index.md) / [fr.abennsir.poc.album.repository.remote](./index.md)

## Package fr.abennsir.poc.album.repository.remote

### Types

| Name | Summary |
|---|---|
| [RemotePhotoRepository](-remote-photo-repository/index.md) | `interface RemotePhotoRepository` |
| [RemotePhotoRepositoryImpl](-remote-photo-repository-impl/index.md) | `class RemotePhotoRepositoryImpl : `[`RemotePhotoRepository`](-remote-photo-repository/index.md) |

### Functions

| Name | Summary |
|---|---|
| [getApiResponse](get-api-response.md) | `suspend fun <T> getApiResponse(call: suspend () -> Response<T>): `[`NetworkResponse`](../fr.abennsir.poc.album.repository.data/-network-response/index.md)`<T>`<br>`suspend fun <T, R> getApiResponse(call: suspend () -> Response<T>, mapper: (T) -> R): `[`NetworkResponse`](../fr.abennsir.poc.album.repository.data/-network-response/index.md)`<R>` |
