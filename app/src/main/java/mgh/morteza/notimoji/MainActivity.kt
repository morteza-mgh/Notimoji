package mgh.morteza.notimoji

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import mgh.morteza.core.designsystem.theme.NotimojiTheme
import mgh.morteza.notimoji.ui.NotimojiApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotimojiTheme {
                NotimojiApp()
            }
        }
    }
}