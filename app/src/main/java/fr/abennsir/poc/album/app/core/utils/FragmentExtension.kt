package fr.abennsir.poc.album.app.core.utils

import androidx.navigation.NavController

/**
 * Helper method to read once from the previous fragment.
 */
fun <T> getAndRemoveFromBackStackEntry(
    navController: NavController, key: String,
    defaultValue: T? = null
): T? {
    val savedStateStream = navController.currentBackStackEntry?.savedStateHandle
    return if (savedStateStream?.contains(key) == true) {
        val value = savedStateStream.get<T>(key)
        savedStateStream.remove<T>(key)
        value
    } else {
        defaultValue
    }
}