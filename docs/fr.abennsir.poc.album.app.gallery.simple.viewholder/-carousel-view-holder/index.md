[app](../../index.md) / [fr.abennsir.poc.album.app.gallery.simple.viewholder](../index.md) / [CarouselViewHolder](./index.md)

# CarouselViewHolder

`@ExperimentalCoroutinesApi class CarouselViewHolder : `[`BaseCarouselViewHolder`](../../fr.abennsir.poc.album.app.gallery.viewholder/-base-carousel-view-holder/index.md)`<`[`PhotoGalleryDataAdapter`](../../fr.abennsir.poc.album.app.gallery.simple.adapter/-photo-gallery-data-adapter/index.md)`>`

class to show photo carousel. It's used to show Gallery from [ListAdapter](#)
It manage show /scroll to target.
It's scoped to the Fragment/Activity holder.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | class to show photo carousel. It's used to show Gallery from [ListAdapter](#) It manage show /scroll to target. It's scoped to the Fragment/Activity holder.`CarouselViewHolder(lifecycleOwner: LifecycleOwner, viewModel: `[`PhotoViewModel`](../../fr.abennsir.poc.album.app.gallery.simple.viewmodel/-photo-view-model/index.md)`, galleryPager: ViewPager2, navigationMode: `[`NavigationMode`](../../fr.abennsir.poc.album.app.gallery.data/-navigation-mode/index.md)` = NavigationMode.DEFAULT, onPageChanged: (PhotoItem, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = { _, _ -> Unit })` |

### Properties

| Name | Summary |
|---|---|
| [currentListProducer](current-list-producer.md) | `val currentListProducer: () -> `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<PhotoItem>` |
| [lifecycleOwner](lifecycle-owner.md) | `val lifecycleOwner: LifecycleOwner` |
| [viewModel](view-model.md) | `val viewModel: `[`PhotoViewModel`](../../fr.abennsir.poc.album.app.gallery.simple.viewmodel/-photo-view-model/index.md) |

### Functions

| Name | Summary |
|---|---|
| [observeData](observe-data.md) | `fun observeData(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
