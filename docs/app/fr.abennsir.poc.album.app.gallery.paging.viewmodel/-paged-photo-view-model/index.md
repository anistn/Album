[app](../../index.md) / [fr.abennsir.poc.album.app.gallery.paging.viewmodel](../index.md) / [PagedPhotoViewModel](./index.md)

# PagedPhotoViewModel

`@ExperimentalCoroutinesApi class PagedPhotoViewModel : AndroidViewModel`

ViewModel for the Album screen and detail photo screen.
The ViewModel works with the [PhotoUsesCase](#) to get the data.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | ViewModel for the Album screen and detail photo screen. The ViewModel works with the [PhotoUsesCase](#) to get the data.`PagedPhotoViewModel(usesCase: PhotoUsesCase, application: `[`Application`](https://developer.android.com/reference/android/app/Application.html)`)` |

### Functions

| Name | Summary |
|---|---|
| [getPhotosSectionedByAlbum](get-photos-sectioned-by-album.md) | `fun getPhotosSectionedByAlbum(): Flow<PagingData<`[`UiModel`](../../fr.abennsir.poc.album.app.gallery.data/-ui-model/index.md)`>>` |
| [observePhotosStream](observe-photos-stream.md) | `fun observePhotosStream(): Flow<PagingData<PhotoItem>>` |
