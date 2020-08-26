[repository](../../index.md) / [fr.abennsir.poc.album.repository.local.database](../index.md) / [PhotoDatabase](./index.md)

# PhotoDatabase

`internal abstract class PhotoDatabase : RoomDatabase`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PhotoDatabase()` |

### Functions

| Name | Summary |
|---|---|
| [photosDao](photos-dao.md) | `abstract fun photosDao(): `[`PhotoDao`](../-photo-dao/index.md) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [DATABASE_NAME](-d-a-t-a-b-a-s-e_-n-a-m-e.md) | `const val DATABASE_NAME: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [INSTANCE](-i-n-s-t-a-n-c-e.md) | `var INSTANCE: `[`PhotoDatabase`](./index.md)`?` |

### Companion Object Functions

| Name | Summary |
|---|---|
| [buildDatabase](build-database.md) | `fun buildDatabase(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`PhotoDatabase`](./index.md) |
| [getInstance](get-instance.md) | `fun getInstance(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`PhotoDatabase`](./index.md) |
