[app](../../index.md) / [fr.abennsir.poc.album.app.gallery.viewholder](../index.md) / [ThumbnailRecyclerViewHolder](./index.md)

# ThumbnailRecyclerViewHolder

`class ThumbnailRecyclerViewHolder : ViewHolder`

View Holder for a [Photo](#) used on RecyclerView.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | View Holder for a [Photo](#) used on RecyclerView.`ThumbnailRecyclerViewHolder(view: `[`View`](https://developer.android.com/reference/android/view/View.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [imageView](image-view.md) | `val imageView: `[`ImageView`](https://developer.android.com/reference/android/widget/ImageView.html) |

### Functions

| Name | Summary |
|---|---|
| [bind](bind.md) | `fun bind(photo: PhotoItem, action: (photo: PhotoItem, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun create(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`): `[`ThumbnailRecyclerViewHolder`](./index.md) |
