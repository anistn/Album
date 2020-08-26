[repository](../../index.md) / [fr.abennsir.poc.album.repository](../index.md) / [PhotoRepositoryFactory](./index.md)

# PhotoRepositoryFactory

`class PhotoRepositoryFactory`

Factory class to create the PhotoRepository

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Factory class to create the PhotoRepository`PhotoRepositoryFactory()` |

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun create(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, pageConfig: PagingConfig = DEFAULT_PAGE_CONFIG, cacheSize: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = DEFAULT_CACHE_SIZE): PhotoRepository` |

### Companion Object Properties

| Name | Summary |
|---|---|
| [DEFAULT_CACHE_SIZE](-d-e-f-a-u-l-t_-c-a-c-h-e_-s-i-z-e.md) | `const val DEFAULT_CACHE_SIZE: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [DEFAULT_PAGE_CONFIG](-d-e-f-a-u-l-t_-p-a-g-e_-c-o-n-f-i-g.md) | Avoid setting [PagingConfig.maxSize](#) since page will be dropped and never restored.`val DEFAULT_PAGE_CONFIG: PagingConfig` |
| [DEFAULT_PAGE_SIZE](-d-e-f-a-u-l-t_-p-a-g-e_-s-i-z-e.md) | `const val DEFAULT_PAGE_SIZE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
