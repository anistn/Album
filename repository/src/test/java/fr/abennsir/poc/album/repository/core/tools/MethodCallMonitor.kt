package fr.abennsir.poc.album.repository.core.tools

class SuspendCallProducer<out R>(private val block: suspend () -> R) : Produce<R> {
    var invokeCount = 0
    override suspend fun execute(): R {
        invokeCount++
        return block()
    }
}

class SuspendCallWatcher<T, R>(private val block: suspend (T) -> R) : Call<T, R> {
    var invokeCount = 0
    override suspend fun execute(t: T): R {
        invokeCount++
        return block(t)
    }
}

interface Call<in T, out R> {
    suspend fun execute(t: T): R
}

interface Produce<out R> {
    suspend fun execute(): R
}