[app](../../index.md) / [fr.abennsir.poc.album.app.gallery.simple.viewholder](../index.md) / [CarouselViewHolder](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`CarouselViewHolder(lifecycleOwner: LifecycleOwner, viewModel: `[`PhotoViewModel`](../../fr.abennsir.poc.album.app.gallery.simple.viewmodel/-photo-view-model/index.md)`, galleryPager: ViewPager2, navigationMode: `[`NavigationMode`](../../fr.abennsir.poc.album.app.gallery.data/-navigation-mode/index.md)` = NavigationMode.DEFAULT, onPageChanged: (PhotoItem, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = { _, _ -> Unit })`

class to show photo carousel. It's used to show Gallery from [ListAdapter](#)
It manage show /scroll to target.
It's scoped to the Fragment/Activity holder.

