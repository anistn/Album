[app](../../index.md) / [fr.abennsir.poc.album.app.gallery.viewholder](../index.md) / [AbstractScrollHandlerViewHolder](./index.md)

# AbstractScrollHandlerViewHolder

`abstract class AbstractScrollHandlerViewHolder<out T : Adapter<*>>`

ViewHolder with capability to manage scroll to position using position or id.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | ViewHolder with capability to manage scroll to position using position or id.`AbstractScrollHandlerViewHolder(navigationMode: `[`NavigationMode`](../../fr.abennsir.poc.album.app.gallery.data/-navigation-mode/index.md)` = NavigationMode.DEFAULT, recyclerAdapter: T)` |

### Properties

| Name | Summary |
|---|---|
| [recyclerAdapter](recycler-adapter.md) | `val recyclerAdapter: T` |

### Functions

| Name | Summary |
|---|---|
| [executeEffectiveScroll](execute-effective-scroll.md) | execute the scroll to the Scrollable ViewGroup`abstract fun executeEffectiveScroll(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [executePendingScroll](execute-pending-scroll.md) | `fun executePendingScroll(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [findTargetPosition](find-target-position.md) | find the position for a given id.`abstract fun findTargetPosition(id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`?` |
| [updateSelectedItemId](update-selected-item-id.md) | `fun updateSelectedItemId(id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [updateTargetPosition](update-target-position.md) | `fun updateTargetPosition(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [BaseAlbumScreenViewHolder](../-base-album-screen-view-holder/index.md) | `abstract class BaseAlbumScreenViewHolder<out T : Adapter<*>> : `[`AbstractScrollHandlerViewHolder`](./index.md)`<T>` |
| [BaseCarouselViewHolder](../-base-carousel-view-holder/index.md) | `abstract class BaseCarouselViewHolder<out T : Adapter<*>> : `[`AbstractScrollHandlerViewHolder`](./index.md)`<T>` |
