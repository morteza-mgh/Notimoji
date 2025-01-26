package mgh.morteza.core.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mgh.morteza.core.designsystem.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotimojiTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    actions: @Composable RowScope.() -> Unit = {},
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        },
        actions = actions
    )
}

@Preview
@Composable
private fun NotimojiTopAppBarPreview() {
    NotimojiTopAppBar(
        title = "My Notes",
        actions = {
            Image(
                painter = painterResource(R.drawable.ic_avatar),
                modifier = Modifier
                    .padding(end = 12.dp)
                    .clip(CircleShape)
                    .size(40.dp),
                contentDescription = null
            )
        })
}