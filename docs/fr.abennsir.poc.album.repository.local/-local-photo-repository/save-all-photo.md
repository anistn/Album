[repository](../../index.md) / [fr.abennsir.poc.album.repository.local](../index.md) / [LocalPhotoRepository](index.md) / [saveAllPhoto](./save-all-photo.md)

# saveAllPhoto

`abstract suspend fun saveAllPhoto(photoEntities: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PhotoEntity`](../../fr.abennsir.poc.album.repository.data/-photo-entity/index.md)`>, needToCleanOld: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

save on local storage the passed [photoEntities](save-all-photo.md#fr.abennsir.poc.album.repository.local.LocalPhotoRepository$saveAllPhoto(kotlin.collections.List((fr.abennsir.poc.album.repository.data.PhotoEntity)), kotlin.Boolean)/photoEntities).
If the [needToCleanOld](save-all-photo.md#fr.abennsir.poc.album.repository.local.LocalPhotoRepository$saveAllPhoto(kotlin.collections.List((fr.abennsir.poc.album.repository.data.PhotoEntity)), kotlin.Boolean)/needToCleanOld) is true the repository must clear all saved photos otherwise just append.

