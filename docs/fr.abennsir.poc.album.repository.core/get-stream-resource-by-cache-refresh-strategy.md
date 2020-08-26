[repository](../index.md) / [fr.abennsir.poc.album.repository.core](index.md) / [getStreamResourceByCacheRefreshStrategy](./get-stream-resource-by-cache-refresh-strategy.md)

# getStreamResourceByCacheRefreshStrategy

`internal fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, A> getStreamResourceByCacheRefreshStrategy(databaseQuery: () -> Flow<T>, networkCall: suspend () -> `[`NetworkResponse`](../fr.abennsir.poc.album.repository.data/-network-response/index.md)`<A>, saveCallResult: suspend (A) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, dispatcher: CoroutineDispatcher = Dispatchers.IO): Flow<Resource<T>>`

This function is based on Flow to perform a cache refresh operation.
It will map the processed object [T](get-stream-resource-by-cache-refresh-strategy.md#T) to [Resource](#)

