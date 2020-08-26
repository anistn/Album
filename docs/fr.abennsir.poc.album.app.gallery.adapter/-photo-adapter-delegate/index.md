[app](../../index.md) / [fr.abennsir.poc.album.app.gallery.adapter](../index.md) / [PhotoAdapterDelegate](./index.md)

# PhotoAdapterDelegate

`class PhotoAdapterDelegate : `[`IBaseAdapter`](../-i-base-adapter/index.md)`<`[`UiModel`](../../fr.abennsir.poc.album.app.gallery.data/-ui-model/index.md)`, ViewHolder>`

Delegate class to be used with List/Paging Adapter

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Delegate class to be used with List/Paging Adapter`PhotoAdapterDelegate(clickAction: (PhotoItem, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [clickAction](click-action.md) | `val clickAction: (PhotoItem, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getItemForPosition](get-item-for-position.md) | `lateinit var getItemForPosition: (`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`UiModel`](../../fr.abennsir.poc.album.app.gallery.data/-ui-model/index.md)`?` |

### Functions

| Name | Summary |
|---|---|
| [getItemViewType](get-item-view-type.md) | `fun getItemViewType(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(holder: ViewHolder, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): ViewHolder` |

### Companion Object Properties

| Name | Summary |
|---|---|
| [UI_MODEL_COMPARATOR](-u-i_-m-o-d-e-l_-c-o-m-p-a-r-a-t-o-r.md) | `val UI_MODEL_COMPARATOR: ItemCallback<`[`UiModel`](../../fr.abennsir.poc.album.app.gallery.data/-ui-model/index.md)`>` |
