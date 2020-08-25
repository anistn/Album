package fr.abennsir.poc.album.domain.data

/**
 *  Base class to present a single domain response.
 *  All uses case function using [Resource] Response will catch exception.
 *  Calling application can handle error from  [Error] class.
 *  When data is cached the status will be loading after success.
 */
/* this class help to manage single source of truth.
 @see https://github.com/android/architecture-components-samples/blob/master/GithubBrowserSample/app/src/main/java/com/android/example/github/vo/Resource.kt
 */


sealed class Resource<out T> {
	data class Success<out T>(val data: T) : Resource<T>()
	data class Loading<out T>(val data: T?) : Resource<T>()
	data class Error<out T>(val throwable: Throwable) : Resource<T>()
}