package mgh.morteza.notimoji.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import mgh.morteza.feature.main.MainNavigationRoute
import mgh.morteza.feature.main.mainScreen

@Composable
fun NotimojiNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = MainNavigationRoute) {
        mainScreen(
            navigateToNoteDetails = { /* TODO */}
        )
    }
}