
# <u>Feed back summary</u>:

**Threading with flow**: 

Positive:

- Compared to Rxjava, couroutine context provide an easy way to cancel(dispose) all async operation.
- Conflate and collectLastest operator are great for  backpressure strategy

Negative:

- Compared to Rxjava multiple operator are missiong, spetially  throttling operator witch is needed by ui.

**RoomDb** 

Positive:

- Easy and quick to implement.

Negative: 

- Designed for simple object hierarchy. In real project it will need to create a lot of associative entity.
- Wired behaviour when empty query response.
- Wired behaviour on testing with Transaction and Roboelectric, prefer using android instrumentation.

**Pager2** 

Positive:

- Can reuse the base Adapter as Recycler.
- Easy implementation compared to PagerAdapter when using only views.

Negative: 

- Very poor performance on scrolling content(horizontal scroll). The provided workaround seems to be buggy.  

**Navigation** 

Positive:

- Present navigation as storyboard.

- NavArgs are great for passing data between fragment when action is known.

- The savedStateHandle provide a great simple way to communicate back to previous fragment, avoiding implementing boilerplate interface between fragment or adding navigation specific implementation to ViewModel.

  ```kotlin
  NavController.currentBackStackEntry?.savedStateHandle
  ```

- ViewModel can be scoped to a navigation graph witch made easy reducing memory consumption and functional scope grouping.

Negative: 

- When using nested navigation graph(witch is the base uses case for a real application with feature module),  NavArgs could not be checked at compile time, so missing data will rise runtime exception.
  So maintaining the global graph for a real application will be a tiny task.
- In a real application we need to change the theme often, so need to create a separate activity, there is no easy way to change theme without recreate the activity.
- Handling multiple Toolbar between Fragment is hard to implement.
- Du to the use of a single Activity, Enabling fullscreen mode depending on the host Fragment is hard to implement. 
  I tried with no success to add implementation of  Immersive mode on detail fragment.

**Turbine** 

Positive:

- It provide easy way for testing flow and avoid boilerplate code for collecting data.  

**Paging 3 library**

Positive:

- Really simplify loading data on demand.  
- Provide a flow to monitor error and loading state.
- Easy implementation compared to a classic paging with scroll listener or ViewHolder load to notify nextPage needed event.
- Easy handling for Footer and Header. (The Footer and header are not visible on the demo since back office is not paged and loading from local is fast)

Negative: 

- The flow to monitor state is really complicated. [CombinedLoadStates](https://developer.android.com/reference/kotlin/androidx/paging/CombinedLoadStates) provide multiple event, and is triggered often witch can lead to intermediate screen shown by error.

- The provided loadStateFlow is triggered depending on Remote action (Mediator,Local Database) source. When applying some data transformation like  [PagingData.insertseparators](https://developer.android.com/reference/kotlin/androidx/paging/package-summary#insertseparators) , or large room query with transformation, we get an out of synchronization between screen state and the shown data on the list. 

- [PagingDataAdapter](https://developer.android.com/reference/kotlin/androidx/paging/PagingDataAdapter) has poor performance on [getItem](https://developer.android.com/reference/kotlin/androidx/paging/PagingDataAdapter#getitem). This lead to application frozen frames, scroll is not smooth when using section with GridLayoutManager. See implementation of  `PhotoItemViewTypeSpanSizeLookup` , scroll is smooth when avoid calling getItem. The paging seems to work correctly when user scroll down but on up scrolling, the differ cannot access efficiency the loaded data. 

- Access loaded data is slightly more complicated that ListAdapter. We need to [PagingDataAdapter.snapshot ](https://developer.android.com/reference/kotlin/androidx/paging/PagingDataAdapter#snapshot). Unlike usual adapter where data is available in memory, the snapshot is recalculated on each method call causing cpu consumption, it may bloc the UiThread when large pages are loaded. 

  > On the demo project, the implementation of scroll to item based on ID is less efficient compared to the [ListAdapter](https://developer.android.com/reference/androidx/recyclerview/widget/ListAdapter).  

- Since Data is wrapped into [PagingData](https://developer.android.com/reference/kotlin/androidx/paging/PagingData) object, we loose the flexibility to transform the data from repository to ui data based on page content, only item by item mapping can be easy achieved.

  This constraint will make harder the reuse of the same paging data between multiple application screens.
   Separate repository later and presentation layer is hard to maintain.

- The implementation of paging is hard to test, all objects are wrapped witch make unit testing impossible.  


[app](./index.md)

### Packages

| Name | Summary |
|---|---|
| [fr.abennsir.poc.album.app](fr.abennsir.poc.album.app/index.md) |  |
| [fr.abennsir.poc.album.app.core.mapper](fr.abennsir.poc.album.app.core.mapper/index.md) |  |
| [fr.abennsir.poc.album.app.core.tools](fr.abennsir.poc.album.app.core.tools/index.md) |  |
| [fr.abennsir.poc.album.app.core.ui](fr.abennsir.poc.album.app.core.ui/index.md) |  |
| [fr.abennsir.poc.album.app.core.utils](fr.abennsir.poc.album.app.core.utils/index.md) |  |
| [fr.abennsir.poc.album.app.gallery.adapter](fr.abennsir.poc.album.app.gallery.adapter/index.md) |  |
| [fr.abennsir.poc.album.app.gallery.data](fr.abennsir.poc.album.app.gallery.data/index.md) |  |
| [fr.abennsir.poc.album.app.gallery.paging.adapter](fr.abennsir.poc.album.app.gallery.paging.adapter/index.md) |  |
| [fr.abennsir.poc.album.app.gallery.paging.viewholder](fr.abennsir.poc.album.app.gallery.paging.viewholder/index.md) |  |
| [fr.abennsir.poc.album.app.gallery.paging.viewmodel](fr.abennsir.poc.album.app.gallery.paging.viewmodel/index.md) |  |
| [fr.abennsir.poc.album.app.gallery.simple.adapter](fr.abennsir.poc.album.app.gallery.simple.adapter/index.md) |  |
| [fr.abennsir.poc.album.app.gallery.simple.viewholder](fr.abennsir.poc.album.app.gallery.simple.viewholder/index.md) |  |
| [fr.abennsir.poc.album.app.gallery.simple.viewmodel](fr.abennsir.poc.album.app.gallery.simple.viewmodel/index.md) |  |
| [fr.abennsir.poc.album.app.gallery.ui](fr.abennsir.poc.album.app.gallery.ui/index.md) |  |
| [fr.abennsir.poc.album.app.gallery.viewholder](fr.abennsir.poc.album.app.gallery.viewholder/index.md) |  |
| [fr.abennsir.poc.album.app.gallery.viewmodel](fr.abennsir.poc.album.app.gallery.viewmodel/index.md) |  |
| [fr.abennsir.poc.album.app.home](fr.abennsir.poc.album.app.home/index.md) |  |
| [fr.abennsir.poc.album.app.injection](fr.abennsir.poc.album.app.injection/index.md) |  |
| [fr.abennsir.poc.album.app.ui.widget](fr.abennsir.poc.album.app.ui.widget/index.md) |  |

[domain](./index.md)

### Packages

| Name | Summary |
|---|---|
| [fr.abennsir.poc.album.domain.data](fr.abennsir.poc.album.domain.data/index.md) |  |
| [fr.abennsir.poc.album.domain.interactor](fr.abennsir.poc.album.domain.interactor/index.md) |  |
| [fr.abennsir.poc.album.domain.repository](fr.abennsir.poc.album.domain.repository/index.md) |  |


[repository](./index.md)

### Packages

| Name | Summary |
|---|---|
| [fr.abennsir.poc.album.repository](fr.abennsir.poc.album.repository/index.md) |  |
| [fr.abennsir.poc.album.repository.core](fr.abennsir.poc.album.repository.core/index.md) |  |
| [fr.abennsir.poc.album.repository.data](fr.abennsir.poc.album.repository.data/index.md) |  |
| [fr.abennsir.poc.album.repository.local](fr.abennsir.poc.album.repository.local/index.md) |  |
| [fr.abennsir.poc.album.repository.local.database](fr.abennsir.poc.album.repository.local.database/index.md) |  |
| [fr.abennsir.poc.album.repository.remote](fr.abennsir.poc.album.repository.remote/index.md) |  |
| [fr.abennsir.poc.album.repository.remote.api](fr.abennsir.poc.album.repository.remote.api/index.md) |  |
| [fr.abennsir.poc.album.repository.remote.mediator](fr.abennsir.poc.album.repository.remote.mediator/index.md) |  |


### Index

[All Types](alltypes/index.md)