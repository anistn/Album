[app](../index.md) / [fr.abennsir.poc.album.app.gallery.adapter](./index.md)

## Package fr.abennsir.poc.album.app.gallery.adapter

### Types

| Name | Summary |
|---|---|
| [IBaseAdapter](-i-base-adapter/index.md) | Interface for base adapter. This is needed since we use the same "Adapter" with different Inherited class base.`interface IBaseAdapter<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, VH : ViewHolder>` |
| [PhotoAdapterDelegate](-photo-adapter-delegate/index.md) | Delegate class to be used with List/Paging Adapter`class PhotoAdapterDelegate : `[`IBaseAdapter`](-i-base-adapter/index.md)`<`[`UiModel`](../fr.abennsir.poc.album.app.gallery.data/-ui-model/index.md)`, ViewHolder>` |
| [PhotoGalleryAdapterDelegate](-photo-gallery-adapter-delegate/index.md) | Base implementation for Adapter of Carousel.`class PhotoGalleryAdapterDelegate : `[`IBaseAdapter`](-i-base-adapter/index.md)`<PhotoItem, `[`PhotoGalleryRecyclerViewHolder`](../fr.abennsir.poc.album.app.gallery.viewholder/-photo-gallery-recycler-view-holder/index.md)`>` |
