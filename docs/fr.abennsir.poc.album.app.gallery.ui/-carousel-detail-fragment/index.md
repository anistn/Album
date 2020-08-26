[app](../../index.md) / [fr.abennsir.poc.album.app.gallery.ui](../index.md) / [CarouselDetailFragment](./index.md)

# CarouselDetailFragment

`@ExperimentalCoroutinesApi class CarouselDetailFragment : Fragment`

A simple [Fragment](#) subclass ssed to show Pager for Photos.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | A simple [Fragment](#) subclass ssed to show Pager for Photos.`CarouselDetailFragment()` |

### Properties

| Name | Summary |
|---|---|
| [binding](binding.md) | `var binding: <ERROR CLASS>` |
| [navigationArgs](navigation-args.md) | `val navigationArgs: <ERROR CLASS>` |
| [pagedViewModel](paged-view-model.md) | `val pagedViewModel: `[`PagedPhotoViewModel`](../../fr.abennsir.poc.album.app.gallery.paging.viewmodel/-paged-photo-view-model/index.md) |
| [simpleViewModel](simple-view-model.md) | `val simpleViewModel: `[`PhotoViewModel`](../../fr.abennsir.poc.album.app.gallery.simple.viewmodel/-photo-view-model/index.md) |
| [viewHolder](view-holder.md) | `lateinit var viewHolder: `[`BaseCarouselViewHolder`](../../fr.abennsir.poc.album.app.gallery.viewholder/-base-carousel-view-holder/index.md)`<*>` |
| [viewModelFactory](view-model-factory.md) | `val viewModelFactory: `[`ViewModelFactory`](../../fr.abennsir.poc.album.app.gallery.viewmodel/-view-model-factory/index.md) |

### Functions

| Name | Summary |
|---|---|
| [createViewHolder](create-view-holder.md) | `fun createViewHolder(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: `[`LayoutInflater`](https://developer.android.com/reference/android/view/LayoutInflater.html)`, container: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`?, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`View`](https://developer.android.com/reference/android/view/View.html)`?` |
| [onViewCreated](on-view-created.md) | `fun onViewCreated(view: `[`View`](https://developer.android.com/reference/android/view/View.html)`, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [updateCurrentPage](update-current-page.md) | `fun updateCurrentPage(item: PhotoItem, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
