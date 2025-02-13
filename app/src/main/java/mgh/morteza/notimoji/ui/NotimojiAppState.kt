package mgh.morteza.notimoji.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberNotimojiAppState(navController: NavHostController = rememberNavController()): NotimojiAppState =
    remember(navController) {
        NotimojiAppState(navController)
    }

class NotimojiAppState(
    val navController: NavHostController
) {

    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    // impl more app state here

}