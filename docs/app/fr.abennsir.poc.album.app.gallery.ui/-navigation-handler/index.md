[app](../../index.md) / [fr.abennsir.poc.album.app.gallery.ui](../index.md) / [NavigationHandler](./index.md)

# NavigationHandler

`abstract class NavigationHandler : `[`SelectItemNavigationRequestHandler`](../-select-item-navigation-request-handler/index.md)`, `[`SelectedItemNavigationResultHandler`](../-selected-item-navigation-result-handler/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NavigationHandler(navController: NavController)` |

### Properties

| Name | Summary |
|---|---|
| [navController](nav-controller.md) | `val navController: NavController` |

### Functions

| Name | Summary |
|---|---|
| [createDirection](create-direction.md) | `abstract fun createDirection(item: PhotoItem, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): NavDirections` |
| [navigateToDetail](navigate-to-detail.md) | `open fun navigateToDetail(item: PhotoItem, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [IdentifierNavigationHandler](../-identifier-navigation-handler/index.md) | Navigation handler using item id.`class IdentifierNavigationHandler : `[`NavigationHandler`](./index.md)`, `[`SelectedItemNavigationResultHandler`](../-selected-item-navigation-result-handler/index.md) |
| [PositionalNavigationHandler](../-positional-navigation-handler/index.md) | [NavigationHandler](./index.md) using position`class PositionalNavigationHandler : `[`NavigationHandler`](./index.md) |
