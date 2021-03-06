[app](../../index.md) / [fr.abennsir.poc.album.app.gallery.paging.viewholder](../index.md) / [AlbumPagedScreenViewHolder](./index.md)

# AlbumPagedScreenViewHolder

`@ExperimentalCoroutinesApi class AlbumPagedScreenViewHolder : `[`BaseAlbumScreenViewHolder`](../../fr.abennsir.poc.album.app.gallery.viewholder/-base-album-screen-view-holder/index.md)`<`[`PhotoPagingDataAdapter`](../../fr.abennsir.poc.album.app.gallery.paging.adapter/-photo-paging-data-adapter/index.md)`>`

class to show photo gridlayout. It's used to show album from [PagingDataAdapter](#)
It manage show /scroll to target.
It's scoped to the Fragment/Activity holder.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | class to show photo gridlayout. It's used to show album from [PagingDataAdapter](#) It manage show /scroll to target. It's scoped to the Fragment/Activity holder.`AlbumPagedScreenViewHolder(binding: <ERROR CLASS>, lifecycleOwner: LifecycleOwner, viewModel: `[`PagedPhotoViewModel`](../../fr.abennsir.poc.album.app.gallery.paging.viewmodel/-paged-photo-view-model/index.md)`, navigationMode: `[`NavigationMode`](../../fr.abennsir.poc.album.app.gallery.data/-navigation-mode/index.md)` = NavigationMode.DEFAULT, photoClickAction: (PhotoItem, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = { _, _ -> Unit })` |

### Properties

| Name | Summary |
|---|---|
| [binding](binding.md) | `val binding: <ERROR CLASS>` |
| [currentListProducer](current-list-producer.md) | `val currentListProducer: () -> `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`UiModel`](../../fr.abennsir.poc.album.app.gallery.data/-ui-model/index.md)`>` |
| [lifecycleOwner](lifecycle-owner.md) | `val lifecycleOwner: LifecycleOwner` |
| [navigationMode](navigation-mode.md) | `val navigationMode: `[`NavigationMode`](../../fr.abennsir.poc.album.app.gallery.data/-navigation-mode/index.md) |
| [photoClickAction](photo-click-action.md) | `val photoClickAction: (PhotoItem, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [retryAction](retry-action.md) | `val retryAction: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [synchronizeAction](synchronize-action.md) | `val synchronizeAction: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [viewModel](view-model.md) | `val viewModel: `[`PagedPhotoViewModel`](../../fr.abennsir.poc.album.app.gallery.paging.viewmodel/-paged-photo-view-model/index.md) |

### Functions

| Name | Summary |
|---|---|
| [computeScreenStateForLoadState](compute-screen-state-for-load-state.md) | `fun computeScreenStateForLoadState(loadState: LoadState): `[`ScreenState`](../../fr.abennsir.poc.album.app.gallery.data/-screen-state/index.md) |
| [observeData](observe-data.md) | add here your implementation to observe ViewModel`fun observeData(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
