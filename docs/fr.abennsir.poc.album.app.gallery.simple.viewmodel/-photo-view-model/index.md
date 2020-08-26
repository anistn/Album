[app](../../index.md) / [fr.abennsir.poc.album.app.gallery.simple.viewmodel](../index.md) / [PhotoViewModel](./index.md)

# PhotoViewModel

`@ExperimentalCoroutinesApi class PhotoViewModel : AndroidViewModel`

ViewModel for the Album screen and detail photo screen.
The ViewModel works with the [PhotoUsesCase](#) to get the data.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | ViewModel for the Album screen and detail photo screen. The ViewModel works with the [PhotoUsesCase](#) to get the data.`PhotoViewModel(usesCase: PhotoUsesCase, application: `[`Application`](https://developer.android.com/reference/android/app/Application.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [errorLiveDate](error-live-date.md) | `val errorLiveDate: `[`SingleLiveEvent`](../../fr.abennsir.poc.album.app.core.ui/-single-live-event/index.md)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [photoLiveData](photo-live-data.md) | `val photoLiveData: MutableLiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`UiModel`](../../fr.abennsir.poc.album.app.gallery.data/-ui-model/index.md)`>>` |
| [screenState](screen-state.md) | `val screenState: MutableLiveData<`[`ScreenState`](../../fr.abennsir.poc.album.app.gallery.data/-screen-state/index.md)`>` |
| [usesCase](uses-case.md) | `val usesCase: PhotoUsesCase` |

### Functions

| Name | Summary |
|---|---|
| [getErrorStream](get-error-stream.md) | `fun getErrorStream(): LiveData<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [getPhotosStream](get-photos-stream.md) | `fun getPhotosStream(): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`UiModel`](../../fr.abennsir.poc.album.app.gallery.data/-ui-model/index.md)`>>` |
| [getScreenStateStream](get-screen-state-stream.md) | `fun getScreenStateStream(): LiveData<`[`ScreenState`](../../fr.abennsir.poc.album.app.gallery.data/-screen-state/index.md)`>` |
| [loadPhotos](load-photos.md) | `fun loadPhotos(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [mapResource](map-resource.md) | `fun mapResource(data: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Photo>): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`UiModel`](../../fr.abennsir.poc.album.app.gallery.data/-ui-model/index.md)`>` |
| [retry](retry.md) | `fun retry(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [synchronize](synchronize.md) | `fun synchronize(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
