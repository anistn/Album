[app](../../index.md) / [fr.abennsir.poc.album.app.gallery.viewmodel](../index.md) / [ViewModelFactory](./index.md)

# ViewModelFactory

`@ExperimentalCoroutinesApi class ViewModelFactory : Factory`

Factory for ViewModels

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Factory for ViewModels`ViewModelFactory(usesCase: PhotoUsesCase, application: `[`Application`](https://developer.android.com/reference/android/app/Application.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [application](application.md) | `val application: `[`Application`](https://developer.android.com/reference/android/app/Application.html) |
| [usesCase](uses-case.md) | `val usesCase: PhotoUsesCase` |

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun <T : ViewModel> create(modelClass: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>): T` |
