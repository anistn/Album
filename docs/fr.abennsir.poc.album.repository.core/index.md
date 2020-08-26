[repository](../index.md) / [fr.abennsir.poc.album.repository.core](./index.md)

## Package fr.abennsir.poc.album.repository.core

### Functions

| Name | Summary |
|---|---|
| [fetchResourceAndCache](fetch-resource-and-cache.md) | Stream to monitor network resource fetch and saving. This strategy is used for retry resource when we already observe data from database.`fun <A> fetchResourceAndCache(networkCall: suspend () -> `[`NetworkResponse`](../fr.abennsir.poc.album.repository.data/-network-response/index.md)`<A>, saveCallResult: suspend (A) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, dispatcher: CoroutineDispatcher = Dispatchers.IO): Flow<Resource<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>>` |
| [getStreamResourceByCacheRefreshStrategy](get-stream-resource-by-cache-refresh-strategy.md) | This function is based on Flow to perform a cache refresh operation. It will map the processed object [T](get-stream-resource-by-cache-refresh-strategy.md#T) to [Resource](#)`fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, A> getStreamResourceByCacheRefreshStrategy(databaseQuery: () -> Flow<T>, networkCall: suspend () -> `[`NetworkResponse`](../fr.abennsir.poc.album.repository.data/-network-response/index.md)`<A>, saveCallResult: suspend (A) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, dispatcher: CoroutineDispatcher = Dispatchers.IO): Flow<Resource<T>>` |
