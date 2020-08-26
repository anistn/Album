[app](../../index.md) / [fr.abennsir.poc.album.app.gallery.simple.viewmodel](../index.md) / [PhotoViewModel](./index.md)

# PhotoViewModel

`@ExperimentalCoroutinesApi class PhotoViewModel : AndroidViewModel`

ViewModel for the Album screen and detail photo screen.
The ViewModel works with the [PhotoUsesCase](#) to get the data.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | ViewModel for the Album screen and detail photo screen. The ViewModel works with the [PhotoUsesCase](#) to get the data.`PhotoViewModel(usesCase: PhotoUsesCase, application: `[`Application`](https://developer.android.com/reference/android/app/Application.html)`)` |

### Functions

| Name | Summary |
|---|---|
| [getErrorStream](get-error-stream.md) | `fun getErrorStream(): LiveData<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [getPhotosStream](get-photos-stream.md) | `fun getPhotosStream(): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`UiModel`](../../fr.abennsir.poc.album.app.gallery.data/-ui-model/index.md)`>>` |
| [getScreenStateStream](get-screen-state-stream.md) | `fun getScreenStateStream(): LiveData<`[`ScreenState`](../../fr.abennsir.poc.album.app.gallery.data/-screen-state/index.md)`>` |
| [retry](retry.md) | `fun retry(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [synchronize](synchronize.md) | `fun synchronize(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
