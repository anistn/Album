[app](../../index.md) / [fr.abennsir.poc.album.app.gallery.viewholder](../index.md) / [BaseAlbumScreenViewHolder](./index.md)

# BaseAlbumScreenViewHolder

`abstract class BaseAlbumScreenViewHolder<out T : Adapter<*>> : `[`AbstractScrollHandlerViewHolder`](../-abstract-scroll-handler-view-holder/index.md)`<T>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BaseAlbumScreenViewHolder(binding: <ERROR CLASS>, navigationMode: `[`NavigationMode`](../../fr.abennsir.poc.album.app.gallery.data/-navigation-mode/index.md)` = NavigationMode.DEFAULT, recyclerAdapter: T)` |

### Properties

| Name | Summary |
|---|---|
| [binding](binding.md) | `val binding: <ERROR CLASS>` |
| [currentListProducer](current-list-producer.md) | `abstract val currentListProducer: () -> `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`UiModel`](../../fr.abennsir.poc.album.app.gallery.data/-ui-model/index.md)`>` |
| [navigationMode](navigation-mode.md) | `val navigationMode: `[`NavigationMode`](../../fr.abennsir.poc.album.app.gallery.data/-navigation-mode/index.md) |
| [retryAction](retry-action.md) | `abstract val retryAction: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [synchronizeAction](synchronize-action.md) | `abstract val synchronizeAction: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Functions

| Name | Summary |
|---|---|
| [executeEffectiveScroll](execute-effective-scroll.md) | execute the scroll to the Scrollable ViewGroup`open fun executeEffectiveScroll(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [findTargetPosition](find-target-position.md) | find the position for a given id.`open fun findTargetPosition(id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`?` |
| [initialize](initialize.md) | `fun initialize(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [initRecycler](init-recycler.md) | `fun initRecycler(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [observeData](observe-data.md) | add here your implementation to observe ViewModel`abstract fun observeData(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showError](show-error.md) | `fun showError(errorMessage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [updateEmptyScreen](update-empty-screen.md) | `fun updateEmptyScreen(imageResource: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, textRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [updateScreenForState](update-screen-for-state.md) | `fun updateScreenForState(screenState: `[`ScreenState`](../../fr.abennsir.poc.album.app.gallery.data/-screen-state/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [updateUiForStateChange](update-ui-for-state-change.md) | `fun updateUiForStateChange(showProgress: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, showEmptyRetry: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, showList: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [AlbumPagedScreenViewHolder](../../fr.abennsir.poc.album.app.gallery.paging.viewholder/-album-paged-screen-view-holder/index.md) | class to show photo gridlayout. It's used to show album from [PagingDataAdapter](#) It manage show /scroll to target. It's scoped to the Fragment/Activity holder.`class AlbumPagedScreenViewHolder : `[`BaseAlbumScreenViewHolder`](./index.md)`<`[`PhotoPagingDataAdapter`](../../fr.abennsir.poc.album.app.gallery.paging.adapter/-photo-paging-data-adapter/index.md)`>` |
| [AlbumScreenViewHolder](../../fr.abennsir.poc.album.app.gallery.simple.viewholder/-album-screen-view-holder/index.md) | `class AlbumScreenViewHolder : `[`BaseAlbumScreenViewHolder`](./index.md)`<`[`PhotoDataAdapter`](../../fr.abennsir.poc.album.app.gallery.simple.adapter/-photo-data-adapter/index.md)`>` |
