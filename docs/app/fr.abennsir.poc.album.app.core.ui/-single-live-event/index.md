[app](../../index.md) / [fr.abennsir.poc.album.app.core.ui](../index.md) / [SingleLiveEvent](./index.md)

# SingleLiveEvent

`class SingleLiveEvent<T> : MutableLiveData<T>`

A lifecycle-aware observable that sends only new updates after subscription, used for events like
navigation and Snackbar messages.

This avoids a common problem with events: on configuration change (like rotation) an update
can be emitted if the observer is active. This LiveData only calls the observable if there's an
explicit call to setValue() or call().

Note that only one observer is going to be notified of changes.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | A lifecycle-aware observable that sends only new updates after subscription, used for events like navigation and Snackbar messages.`SingleLiveEvent()` |

### Functions

| Name | Summary |
|---|---|
| [observe](observe.md) | `fun observe(owner: LifecycleOwner, observer: Observer<in T>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setValue](set-value.md) | `fun setValue(t: T?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
