[repository](../index.md) / [fr.abennsir.poc.album.repository.remote](index.md) / [getApiResponse](./get-api-response.md)

# getApiResponse

`internal suspend fun <T> getApiResponse(call: suspend () -> Response<T>): `[`NetworkResponse`](../fr.abennsir.poc.album.repository.data/-network-response/index.md)`<T>`
`internal suspend fun <T, R> getApiResponse(call: suspend () -> Response<T>, mapper: (T) -> R): `[`NetworkResponse`](../fr.abennsir.poc.album.repository.data/-network-response/index.md)`<R>`