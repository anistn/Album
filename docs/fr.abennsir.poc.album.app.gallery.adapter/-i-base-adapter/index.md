[app](../../index.md) / [fr.abennsir.poc.album.app.gallery.adapter](../index.md) / [IBaseAdapter](./index.md)

# IBaseAdapter

`interface IBaseAdapter<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, VH : ViewHolder>`

Interface for base adapter.
This is needed since we use the same "Adapter" with different Inherited class base.

### Properties

| Name | Summary |
|---|---|
| [getItemForPosition](get-item-for-position.md) | `abstract var getItemForPosition: (`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> T?` |

### Functions

| Name | Summary |
|---|---|
| [getItemViewType](get-item-view-type.md) | `abstract fun getItemViewType(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [onBindViewHolder](on-bind-view-holder.md) | `abstract fun onBindViewHolder(holder: VH, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateViewHolder](on-create-view-holder.md) | `abstract fun onCreateViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): VH` |

### Inheritors

| Name | Summary |
|---|---|
| [PhotoAdapterDelegate](../-photo-adapter-delegate/index.md) | Delegate class to be used with List/Paging Adapter`class PhotoAdapterDelegate : `[`IBaseAdapter`](./index.md)`<`[`UiModel`](../../fr.abennsir.poc.album.app.gallery.data/-ui-model/index.md)`, ViewHolder>` |
| [PhotoDataAdapter](../../fr.abennsir.poc.album.app.gallery.simple.adapter/-photo-data-adapter/index.md) | Adapter for the list of photo.`class PhotoDataAdapter : ListAdapter<`[`UiModel`](../../fr.abennsir.poc.album.app.gallery.data/-ui-model/index.md)`, ViewHolder>, `[`IBaseAdapter`](./index.md)`<`[`UiModel`](../../fr.abennsir.poc.album.app.gallery.data/-ui-model/index.md)`, ViewHolder>` |
| [PhotoGalleryAdapterDelegate](../-photo-gallery-adapter-delegate/index.md) | Base implementation for Adapter of Carousel.`class PhotoGalleryAdapterDelegate : `[`IBaseAdapter`](./index.md)`<PhotoItem, `[`PhotoGalleryRecyclerViewHolder`](../../fr.abennsir.poc.album.app.gallery.viewholder/-photo-gallery-recycler-view-holder/index.md)`>` |
| [PhotoGalleryDataAdapter](../../fr.abennsir.poc.album.app.gallery.simple.adapter/-photo-gallery-data-adapter/index.md) | Adapter for the gallery of photo, will be used with view pager`class PhotoGalleryDataAdapter : ListAdapter<PhotoItem, `[`PhotoGalleryRecyclerViewHolder`](../../fr.abennsir.poc.album.app.gallery.viewholder/-photo-gallery-recycler-view-holder/index.md)`>, `[`IBaseAdapter`](./index.md)`<PhotoItem, `[`PhotoGalleryRecyclerViewHolder`](../../fr.abennsir.poc.album.app.gallery.viewholder/-photo-gallery-recycler-view-holder/index.md)`>` |
| [PhotoGalleryPagingDataAdapter](../../fr.abennsir.poc.album.app.gallery.paging.adapter/-photo-gallery-paging-data-adapter/index.md) | Adapter for the gallery of photo, will be used with view pager`class PhotoGalleryPagingDataAdapter : PagingDataAdapter<PhotoItem, `[`PhotoGalleryRecyclerViewHolder`](../../fr.abennsir.poc.album.app.gallery.viewholder/-photo-gallery-recycler-view-holder/index.md)`>, `[`IBaseAdapter`](./index.md)`<PhotoItem, `[`PhotoGalleryRecyclerViewHolder`](../../fr.abennsir.poc.album.app.gallery.viewholder/-photo-gallery-recycler-view-holder/index.md)`>` |
| [PhotoPagingDataAdapter](../../fr.abennsir.poc.album.app.gallery.paging.adapter/-photo-paging-data-adapter/index.md) | Adapter for the list of photo.`class PhotoPagingDataAdapter : PagingDataAdapter<`[`UiModel`](../../fr.abennsir.poc.album.app.gallery.data/-ui-model/index.md)`, ViewHolder>, `[`IBaseAdapter`](./index.md)`<`[`UiModel`](../../fr.abennsir.poc.album.app.gallery.data/-ui-model/index.md)`, ViewHolder>` |
