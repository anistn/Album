[domain](../index.md) / [fr.abennsir.poc.album.domain.data](./index.md)

## Package fr.abennsir.poc.album.domain.data

### Types

| Name | Summary |
|---|---|
| [Photo](-photo/index.md) | Data class to present user photo`data class Photo` |
| [Resource](-resource/index.md) | Base class to present a single domain response. All uses case function using [Resource](-resource/index.md) Response will catch exception. Calling application can handle error from  [Error](-resource/-error/index.md) class. When data is cached the status will be loading after success.`sealed class Resource<out T>` |
