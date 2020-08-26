[repository](../../index.md) / [fr.abennsir.poc.album.repository.data](../index.md) / [PhotoEntity](./index.md)

# PhotoEntity

`internal data class PhotoEntity`

since it's a sample object we are using the same entity for local and remote repository data.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | since it's a sample object we are using the same entity for local and remote repository data.`PhotoEntity(albumId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 0, id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 0, title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "", url: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "", thumbnailUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "")` |

### Properties

| Name | Summary |
|---|---|
| [albumId](album-id.md) | `val albumId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [id](id.md) | `val id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [thumbnailUrl](thumbnail-url.md) | `val thumbnailUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [title](title.md) | `val title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [url](url.md) | `val url: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [toPhoto](../to-photo.md) | `fun `[`PhotoEntity`](./index.md)`.toPhoto(): Photo` |
