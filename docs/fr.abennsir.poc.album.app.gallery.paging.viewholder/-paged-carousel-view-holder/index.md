[app](../../index.md) / [fr.abennsir.poc.album.app.gallery.paging.viewholder](../index.md) / [PagedCarouselViewHolder](./index.md)

# PagedCarouselViewHolder

`@ExperimentalCoroutinesApi class PagedCarouselViewHolder : `[`BaseCarouselViewHolder`](../../fr.abennsir.poc.album.app.gallery.viewholder/-base-carousel-view-holder/index.md)`<`[`PhotoGalleryPagingDataAdapter`](../../fr.abennsir.poc.album.app.gallery.paging.adapter/-photo-gallery-paging-data-adapter/index.md)`>`

class to show photo carousel. It's used to show Carousel from [PagingDataAdapter](#)
It manage show /scroll to target.
It's scoped to the Fragment/Activity holder.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | class to show photo carousel. It's used to show Carousel from [PagingDataAdapter](#) It manage show /scroll to target. It's scoped to the Fragment/Activity holder.`PagedCarouselViewHolder(galleryPager: ViewPager2, navigationMode: `[`NavigationMode`](../../fr.abennsir.poc.album.app.gallery.data/-navigation-mode/index.md)` = NavigationMode.DEFAULT, lifecycleOwner: LifecycleOwner, viewModel: `[`PagedPhotoViewModel`](../../fr.abennsir.poc.album.app.gallery.paging.viewmodel/-paged-photo-view-model/index.md)`, onPageChanged: (PhotoItem, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = { _, _ -> Unit })` |

### Properties

| Name | Summary |
|---|---|
| [currentListProducer](current-list-producer.md) | `val currentListProducer: () -> `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<PhotoItem>` |
| [lifecycleOwner](lifecycle-owner.md) | `val lifecycleOwner: LifecycleOwner` |
| [viewModel](view-model.md) | `val viewModel: `[`PagedPhotoViewModel`](../../fr.abennsir.poc.album.app.gallery.paging.viewmodel/-paged-photo-view-model/index.md) |

### Functions

| Name | Summary |
|---|---|
| [observeData](observe-data.md) | `fun observeData(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
