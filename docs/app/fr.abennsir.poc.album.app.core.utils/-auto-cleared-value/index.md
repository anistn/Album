[app](../../index.md) / [fr.abennsir.poc.album.app.core.utils](../index.md) / [AutoClearedValue](./index.md)

# AutoClearedValue

`class AutoClearedValue<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ReadWriteProperty`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-write-property/index.html)`<Fragment, T>`

A lazy property that gets cleaned up when the fragment's view is destroyed.

Accessing this variable while the fragment's view is destroyed will throw NPE.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | A lazy property that gets cleaned up when the fragment's view is destroyed.`AutoClearedValue(fragment: Fragment)` |

### Properties

| Name | Summary |
|---|---|
| [fragment](fragment.md) | `val fragment: Fragment` |

### Functions

| Name | Summary |
|---|---|
| [getValue](get-value.md) | `fun getValue(thisRef: Fragment, property: `[`KProperty`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-property/index.html)`<*>): T` |
| [setValue](set-value.md) | `fun setValue(thisRef: Fragment, property: `[`KProperty`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-property/index.html)`<*>, value: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
