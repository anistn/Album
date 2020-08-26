[app](../../index.md) / [fr.abennsir.poc.album.app.gallery.ui](../index.md) / [AlbumFragment](./index.md)

# AlbumFragment

`@ExperimentalCoroutinesApi class AlbumFragment : Fragment`

A simple [Fragment](#) subclass used to show All photos on a Grid.
It use position or item id if sectioned to navigate to Detail .

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | A simple [Fragment](#) subclass used to show All photos on a Grid. It use position or item id if sectioned to navigate to Detail .`AlbumFragment()` |

### Properties

| Name | Summary |
|---|---|
| [binding](binding.md) | `var binding: <ERROR CLASS>` |
| [itemNavigationHandler](item-navigation-handler.md) | `lateinit var itemNavigationHandler: `[`NavigationHandler`](../-navigation-handler/index.md) |
| [navigationArgs](navigation-args.md) | `val navigationArgs: <ERROR CLASS>` |
| [pagedViewModel](paged-view-model.md) | `val pagedViewModel: `[`PagedPhotoViewModel`](../../fr.abennsir.poc.album.app.gallery.paging.viewmodel/-paged-photo-view-model/index.md) |
| [simpleViewModel](simple-view-model.md) | `val simpleViewModel: `[`PhotoViewModel`](../../fr.abennsir.poc.album.app.gallery.simple.viewmodel/-photo-view-model/index.md) |
| [viewHolder](view-holder.md) | `lateinit var viewHolder: `[`BaseAlbumScreenViewHolder`](../../fr.abennsir.poc.album.app.gallery.viewholder/-base-album-screen-view-holder/index.md)`<*>` |
| [viewModelFactory](view-model-factory.md) | `val viewModelFactory: `[`ViewModelFactory`](../../fr.abennsir.poc.album.app.gallery.viewmodel/-view-model-factory/index.md) |

### Functions

| Name | Summary |
|---|---|
| [createSelectedItemNavigation](create-selected-item-navigation.md) | `fun createSelectedItemNavigation(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [createViewHolder](create-view-holder.md) | `fun createViewHolder(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [handleItemClickEvent](handle-item-click-event.md) | `fun handleItemClickEvent(item: PhotoItem, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: `[`LayoutInflater`](https://developer.android.com/reference/android/view/LayoutInflater.html)`, container: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`?, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`View`](https://developer.android.com/reference/android/view/View.html)`?` |
| [onViewCreated](on-view-created.md) | `fun onViewCreated(view: `[`View`](https://developer.android.com/reference/android/view/View.html)`, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
