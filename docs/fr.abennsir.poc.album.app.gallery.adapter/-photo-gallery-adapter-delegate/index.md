[app](../../index.md) / [fr.abennsir.poc.album.app.gallery.adapter](../index.md) / [PhotoGalleryAdapterDelegate](./index.md)

# PhotoGalleryAdapterDelegate

`class PhotoGalleryAdapterDelegate : `[`IBaseAdapter`](../-i-base-adapter/index.md)`<PhotoItem, `[`PhotoGalleryRecyclerViewHolder`](../../fr.abennsir.poc.album.app.gallery.viewholder/-photo-gallery-recycler-view-holder/index.md)`>`

Base implementation for Adapter of Carousel.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Base implementation for Adapter of Carousel.`PhotoGalleryAdapterDelegate()` |

### Properties

| Name | Summary |
|---|---|
| [getItemForPosition](get-item-for-position.md) | `lateinit var getItemForPosition: (`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> PhotoItem?` |

### Functions

| Name | Summary |
|---|---|
| [getItemViewType](get-item-view-type.md) | `fun getItemViewType(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(holder: `[`PhotoGalleryRecyclerViewHolder`](../../fr.abennsir.poc.album.app.gallery.viewholder/-photo-gallery-recycler-view-holder/index.md)`, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`PhotoGalleryRecyclerViewHolder`](../../fr.abennsir.poc.album.app.gallery.viewholder/-photo-gallery-recycler-view-holder/index.md) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [PHOTO_COMPARATOR](-p-h-o-t-o_-c-o-m-p-a-r-a-t-o-r.md) | `val PHOTO_COMPARATOR: ItemCallback<PhotoItem>` |
