[app](../../index.md) / [fr.abennsir.poc.album.app.gallery.simple.adapter](../index.md) / [PhotoGalleryDataAdapter](./index.md)

# PhotoGalleryDataAdapter

`class PhotoGalleryDataAdapter : ListAdapter<PhotoItem, `[`PhotoGalleryRecyclerViewHolder`](../../fr.abennsir.poc.album.app.gallery.viewholder/-photo-gallery-recycler-view-holder/index.md)`>, `[`IBaseAdapter`](../../fr.abennsir.poc.album.app.gallery.adapter/-i-base-adapter/index.md)`<PhotoItem, `[`PhotoGalleryRecyclerViewHolder`](../../fr.abennsir.poc.album.app.gallery.viewholder/-photo-gallery-recycler-view-holder/index.md)`>`

Adapter for the gallery of photo, will be used with view pager

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Adapter for the gallery of photo, will be used with view pager`PhotoGalleryDataAdapter(delegate: `[`PhotoGalleryAdapterDelegate`](../../fr.abennsir.poc.album.app.gallery.adapter/-photo-gallery-adapter-delegate/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [delegate](delegate.md) | `val delegate: `[`PhotoGalleryAdapterDelegate`](../../fr.abennsir.poc.album.app.gallery.adapter/-photo-gallery-adapter-delegate/index.md) |

### Functions

| Name | Summary |
|---|---|
| [getItemViewType](get-item-view-type.md) | `fun getItemViewType(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
