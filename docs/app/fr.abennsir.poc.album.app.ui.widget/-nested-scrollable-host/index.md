[app](../../index.md) / [fr.abennsir.poc.album.app.ui.widget](../index.md) / [NestedScrollableHost](./index.md)

# NestedScrollableHost

`open class NestedScrollableHost : `[`FrameLayout`](https://developer.android.com/reference/android/widget/FrameLayout.html)

Layout to wrap a scrollable component inside a ViewPager2. Provided as a solution to the problem
where pages of ViewPager2 have nested scrollable elements that scroll in the same direction as
ViewPager2. The scrollable element needs to be the immediate and only child of this host layout.

This solution has limitations when using multiple levels of nested scrollable elements
(e.g. a horizontal RecyclerView in a vertical RecyclerView in a horizontal ViewPager2).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NestedScrollableHost(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`)`<br>`NestedScrollableHost(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, attrs: `[`AttributeSet`](https://developer.android.com/reference/android/util/AttributeSet.html)`?)` |

### Functions

| Name | Summary |
|---|---|
| [onInterceptTouchEvent](on-intercept-touch-event.md) | `open fun onInterceptTouchEvent(e: `[`MotionEvent`](https://developer.android.com/reference/android/view/MotionEvent.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [SafeNestedScrollableHost](../-safe-nested-scrollable-host/index.md) | This view Group is just used to avoid api limitation when using [com.github.chrisbanes.photoview.PhotoView](#) For more information please refer to @see [PhotoView#issues-with-viewgroups](#) (https://github.com/chrisbanes/PhotoView#issues-with-viewgroups)`class SafeNestedScrollableHost : `[`NestedScrollableHost`](./index.md) |
