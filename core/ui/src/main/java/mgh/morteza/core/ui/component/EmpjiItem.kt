package mgh.morteza.core.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mgh.morteza.core.designsystem.theme.ColorYellow

@Composable
fun EmojiItem(modifier: Modifier = Modifier, emojiChar: String) {
    Box(
        modifier = modifier
            .size(28.dp)
            .clip(CircleShape)
            .aspectRatio(1f)
            .background(ColorYellow.copy(alpha = 0.3f)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = emojiChar, fontSize = 14.sp)
    }
}