[app](../../index.md) / [fr.abennsir.poc.album.app.gallery.simple.viewholder](../index.md) / [AlbumScreenViewHolder](./index.md)

# AlbumScreenViewHolder

`@ExperimentalCoroutinesApi class AlbumScreenViewHolder : `[`BaseAlbumScreenViewHolder`](../../fr.abennsir.poc.album.app.gallery.viewholder/-base-album-screen-view-holder/index.md)`<`[`PhotoDataAdapter`](../../fr.abennsir.poc.album.app.gallery.simple.adapter/-photo-data-adapter/index.md)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AlbumScreenViewHolder(binding: <ERROR CLASS>, lifecycleOwner: LifecycleOwner, viewModel: `[`PhotoViewModel`](../../fr.abennsir.poc.album.app.gallery.simple.viewmodel/-photo-view-model/index.md)`, navigationMode: `[`NavigationMode`](../../fr.abennsir.poc.album.app.gallery.data/-navigation-mode/index.md)` = NavigationMode.DEFAULT, photoClickAction: (PhotoItem, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = { _, _ -> Unit })` |

### Properties

| Name | Summary |
|---|---|
| [currentListProducer](current-list-producer.md) | `val currentListProducer: () -> `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`UiModel`](../../fr.abennsir.poc.album.app.gallery.data/-ui-model/index.md)`>` |
| [lifecycleOwner](lifecycle-owner.md) | `val lifecycleOwner: LifecycleOwner` |
| [navigationMode](navigation-mode.md) | `val navigationMode: `[`NavigationMode`](../../fr.abennsir.poc.album.app.gallery.data/-navigation-mode/index.md) |
| [photoClickAction](photo-click-action.md) | `val photoClickAction: (PhotoItem, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [retryAction](retry-action.md) | `val retryAction: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [synchronizeAction](synchronize-action.md) | `val synchronizeAction: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [viewModel](view-model.md) | `val viewModel: `[`PhotoViewModel`](../../fr.abennsir.poc.album.app.gallery.simple.viewmodel/-photo-view-model/index.md) |

### Functions

| Name | Summary |
|---|---|
| [observeData](observe-data.md) | add here your implementation to observe ViewModel`fun observeData(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
