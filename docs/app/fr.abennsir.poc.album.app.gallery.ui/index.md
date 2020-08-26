[app](../index.md) / [fr.abennsir.poc.album.app.gallery.ui](./index.md)

## Package fr.abennsir.poc.album.app.gallery.ui

### Types

| Name | Summary |
|---|---|
| [AlbumFragment](-album-fragment/index.md) | A simple [Fragment](#) subclass used to show All photos on a Grid. It use position or item id if sectioned to navigate to Detail .`class AlbumFragment : Fragment` |
| [CarouselDetailFragment](-carousel-detail-fragment/index.md) | A simple [Fragment](#) subclass ssed to show Pager for Photos.`class CarouselDetailFragment : Fragment` |
| [IdentifierNavigationHandler](-identifier-navigation-handler/index.md) | Navigation handler using item id.`class IdentifierNavigationHandler : `[`NavigationHandler`](-navigation-handler/index.md)`, `[`SelectedItemNavigationResultHandler`](-selected-item-navigation-result-handler/index.md) |
| [NavigationHandler](-navigation-handler/index.md) | `abstract class NavigationHandler : `[`SelectItemNavigationRequestHandler`](-select-item-navigation-request-handler/index.md)`, `[`SelectedItemNavigationResultHandler`](-selected-item-navigation-result-handler/index.md) |
| [PhotoItemViewTypeSpanSizeLookup](-photo-item-view-type-span-size-lookup/index.md) | `class PhotoItemViewTypeSpanSizeLookup : SpanSizeLookup` |
| [PositionalNavigationHandler](-positional-navigation-handler/index.md) | [NavigationHandler](-navigation-handler/index.md) using position`class PositionalNavigationHandler : `[`NavigationHandler`](-navigation-handler/index.md) |
| [SelectedItemNavigationResultHandler](-selected-item-navigation-result-handler/index.md) | `interface SelectedItemNavigationResultHandler` |
| [SelectItemNavigationRequestHandler](-select-item-navigation-request-handler/index.md) | `interface SelectItemNavigationRequestHandler` |

### Properties

| Name | Summary |
|---|---|
| [SELECTED_PHOTO_ID_KEY](-s-e-l-e-c-t-e-d_-p-h-o-t-o_-i-d_-k-e-y.md) | `const val SELECTED_PHOTO_ID_KEY: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [SELECTED_POSITION_KEY](-s-e-l-e-c-t-e-d_-p-o-s-i-t-i-o-n_-k-e-y.md) | Base interface to create navigation parameter for [fr.abennsir.poc.album.app.gallery.data.NavigationMode](../fr.abennsir.poc.album.app.gallery.data/-navigation-mode/index.md)`const val SELECTED_POSITION_KEY: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
