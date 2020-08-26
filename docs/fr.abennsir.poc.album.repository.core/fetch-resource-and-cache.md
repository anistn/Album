[repository](../index.md) / [fr.abennsir.poc.album.repository.core](index.md) / [fetchResourceAndCache](./fetch-resource-and-cache.md)

# fetchResourceAndCache

`internal fun <A> fetchResourceAndCache(networkCall: suspend () -> `[`NetworkResponse`](../fr.abennsir.poc.album.repository.data/-network-response/index.md)`<A>, saveCallResult: suspend (A) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, dispatcher: CoroutineDispatcher = Dispatchers.IO): Flow<Resource<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>>`

Stream to monitor network resource fetch and saving.
This strategy is used for retry resource when we already observe data from database.

