package mgh.morteza.core.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mgh.morteza.core.designsystem.R
import mgh.morteza.core.designsystem.theme.NotimojiTheme

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

@Composable
fun DetailAppbar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    actions: @Composable () -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = onBackClick) {
            Icon(
                painter = painterResource(R.drawable.ic_arrow_left_outlined),
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                contentDescription = stringResource(R.string.back)
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            actions()
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun DetailAppbarPreview() = NotimojiTheme {
    DetailAppbar(modifier = Modifier.width(350.dp), {}, {})
}


@Preview
@Composable
private fun NotimojiTopAppBarPreview() = NotimojiTheme {
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