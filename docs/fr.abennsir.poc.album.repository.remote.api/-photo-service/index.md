[repository](../../index.md) / [fr.abennsir.poc.album.repository.remote.api](../index.md) / [PhotoService](./index.md)

# PhotoService

`internal interface PhotoService`

Github API communication setup via Retrofit.

### Functions

| Name | Summary |
|---|---|
| [getPhotoAlbum](get-photo-album.md) | `abstract suspend fun getPhotoAlbum(): Response<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PhotoEntity`](../../fr.abennsir.poc.album.repository.data/-photo-entity/index.md)`>>` |

### Companion Object Properties

| Name | Summary |
|---|---|
| [BASE_URL](-b-a-s-e_-u-r-l.md) | `const val BASE_URL: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [DEFAULT_CACHE_SIZE](-d-e-f-a-u-l-t_-c-a-c-h-e_-s-i-z-e.md) | `const val DEFAULT_CACHE_SIZE: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun create(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, cacheSize: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = DEFAULT_CACHE_SIZE): `[`PhotoService`](./index.md) |
