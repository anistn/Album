[app](../../index.md) / [fr.abennsir.poc.album.app.gallery.viewholder](../index.md) / [BaseCarouselViewHolder](./index.md)

# BaseCarouselViewHolder

`abstract class BaseCarouselViewHolder<out T : Adapter<*>> : `[`AbstractScrollHandlerViewHolder`](../-abstract-scroll-handler-view-holder/index.md)`<T>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BaseCarouselViewHolder(galleryPager: ViewPager2, onPageChanged: (PhotoItem, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = { _, _ -> Unit }, recyclerAdapter: T, navigationMode: `[`NavigationMode`](../../fr.abennsir.poc.album.app.gallery.data/-navigation-mode/index.md)` = NavigationMode.DEFAULT)` |

### Properties

| Name | Summary |
|---|---|
| [currentListProducer](current-list-producer.md) | `abstract val currentListProducer: () -> `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<PhotoItem>` |

### Functions

| Name | Summary |
|---|---|
| [executeEffectiveScroll](execute-effective-scroll.md) | execute the scroll to the Scrollable ViewGroup`open fun executeEffectiveScroll(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [findTargetPosition](find-target-position.md) | find the position for a given id.`open fun findTargetPosition(id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`?` |
| [initialize](initialize.md) | `fun initialize(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [initViewPager](init-view-pager.md) | `fun initViewPager(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [observeData](observe-data.md) | `abstract fun observeData(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [CarouselViewHolder](../../fr.abennsir.poc.album.app.gallery.simple.viewholder/-carousel-view-holder/index.md) | class to show photo carousel. It's used to show Gallery from [ListAdapter](#) It manage show /scroll to target. It's scoped to the Fragment/Activity holder.`class CarouselViewHolder : `[`BaseCarouselViewHolder`](./index.md)`<`[`PhotoGalleryDataAdapter`](../../fr.abennsir.poc.album.app.gallery.simple.adapter/-photo-gallery-data-adapter/index.md)`>` |
| [PagedCarouselViewHolder](../../fr.abennsir.poc.album.app.gallery.paging.viewholder/-paged-carousel-view-holder/index.md) | class to show photo carousel. It's used to show Carousel from [PagingDataAdapter](#) It manage show /scroll to target. It's scoped to the Fragment/Activity holder.`class PagedCarouselViewHolder : `[`BaseCarouselViewHolder`](./index.md)`<`[`PhotoGalleryPagingDataAdapter`](../../fr.abennsir.poc.album.app.gallery.paging.adapter/-photo-gallery-paging-data-adapter/index.md)`>` |
