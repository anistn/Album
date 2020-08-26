[domain](../../index.md) / [fr.abennsir.poc.album.domain.data](../index.md) / [Resource](./index.md)

# Resource

`sealed class Resource<out T>`

Base class to present a single domain response.
All uses case function using [Resource](./index.md) Response will catch exception.
Calling application can handle error from  [Error](-error/index.md) class.
When data is cached the status will be loading after success.

### Types

| Name | Summary |
|---|---|
| [Error](-error/index.md) | `data class Error<out T> : `[`Resource`](./index.md)`<T>` |
| [Loading](-loading/index.md) | `data class Loading<out T> : `[`Resource`](./index.md)`<T>` |
| [Success](-success/index.md) | `data class Success<out T> : `[`Resource`](./index.md)`<T>` |
