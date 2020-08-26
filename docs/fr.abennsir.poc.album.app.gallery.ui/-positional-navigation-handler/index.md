[app](../../index.md) / [fr.abennsir.poc.album.app.gallery.ui](../index.md) / [PositionalNavigationHandler](./index.md)

# PositionalNavigationHandler

`class PositionalNavigationHandler : `[`NavigationHandler`](../-navigation-handler/index.md)

[NavigationHandler](../-navigation-handler/index.md) using position

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | [NavigationHandler](../-navigation-handler/index.md) using position`PositionalNavigationHandler(config: `[`Config`](../../fr.abennsir.poc.album.app.gallery.data/-config/index.md)`, scrollHandlerViewHolder: `[`AbstractScrollHandlerViewHolder`](../../fr.abennsir.poc.album.app.gallery.viewholder/-abstract-scroll-handler-view-holder/index.md)`<*>, navController: NavController)` |

### Properties

| Name | Summary |
|---|---|
| [config](config.md) | `val config: `[`Config`](../../fr.abennsir.poc.album.app.gallery.data/-config/index.md) |
| [scrollHandlerViewHolder](scroll-handler-view-holder.md) | `val scrollHandlerViewHolder: `[`AbstractScrollHandlerViewHolder`](../../fr.abennsir.poc.album.app.gallery.viewholder/-abstract-scroll-handler-view-holder/index.md)`<*>` |

### Functions

| Name | Summary |
|---|---|
| [createDirection](create-direction.md) | `fun createDirection(item: PhotoItem, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): NavDirections` |
| [handleNavigateToItem](handle-navigate-to-item.md) | `fun handleNavigateToItem(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
