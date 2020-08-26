[app](../index.md) / [fr.abennsir.poc.album.app.core.utils](./index.md)

## Package fr.abennsir.poc.album.app.core.utils

### Types

| Name | Summary |
|---|---|
| [AutoClearedValue](-auto-cleared-value/index.md) | A lazy property that gets cleaned up when the fragment's view is destroyed.`class AutoClearedValue<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : `[`ReadWriteProperty`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-write-property/index.html)`<Fragment, T>` |

### Extensions for External Classes

| Name | Summary |
|---|---|
| [androidx.fragment.app.Fragment](androidx.fragment.app.-fragment/index.md) |  |

### Functions

| Name | Summary |
|---|---|
| [getAndRemoveFromBackStackEntry](get-and-remove-from-back-stack-entry.md) | Helper method to read once from the previous fragment.`fun <T> getAndRemoveFromBackStackEntry(navController: NavController, key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, defaultValue: T? = null): T?` |
