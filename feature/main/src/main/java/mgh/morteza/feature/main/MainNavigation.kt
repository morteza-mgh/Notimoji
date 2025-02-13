package mgh.morteza.feature.main

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object MainNavigationRoute

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    navigate(MainNavigationRoute, navOptions)
}

fun NavGraphBuilder.mainScreen(
    navigateToNoteDetails: (id: String) -> Unit
) {
    composable<MainNavigationRoute> {
        MainScreen(navigateToNoteDetails = navigateToNoteDetails)
    }
}