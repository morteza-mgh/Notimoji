package mgh.morteza.notimoji.ui

import androidx.compose.runtime.Composable
import mgh.morteza.notimoji.navigation.NotimojiNavHost

@Composable
fun NotimojiApp(appState: NotimojiAppState = rememberNotimojiAppState()) {
    NotimojiNavHost(navController = appState.navController)
}