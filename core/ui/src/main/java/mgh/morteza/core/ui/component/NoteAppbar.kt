package mgh.morteza.core.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mgh.morteza.core.designsystem.component.DetailAppbar
import mgh.morteza.core.designsystem.component.NotimojiTextButton
import mgh.morteza.core.designsystem.theme.NotimojiTheme
import mgh.morteza.core.ui.R

@Composable
fun NoteAppbar(
    modifier: Modifier = Modifier,
    onDoneClick: () -> Unit,
    onUndoClick: () -> Unit,
    onRedoClick: () -> Unit,
    onMoreClick: () -> Unit,
) {
    DetailAppbar(
        modifier = modifier,
        onBackClick = {},
        actions = {
            IconButton(onClick = onUndoClick) {
                Icon(
                    painter = painterResource(R.drawable.ic_undo),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    contentDescription = stringResource(R.string.undo)
                )
            }

            IconButton(onClick = onRedoClick) {
                Icon(
                    painter = painterResource(R.drawable.ic_redo),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    contentDescription = stringResource(R.string.redo)
                )
            }

            IconButton(onClick = onMoreClick) {
                Icon(
                    painter = painterResource(R.drawable.ic_more_outlined),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    contentDescription = stringResource(R.string.more)
                )
            }

            NotimojiTextButton(onClick = onDoneClick) {
                Text(text = stringResource(R.string.done))
            }
        })
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun NoteAppbarPreview() = NotimojiTheme {
    NoteAppbar(
        modifier = Modifier
            .width(400.dp)
            .padding(horizontal = 14.dp, vertical = 20.dp),
        onDoneClick = {},
        onMoreClick = {},
        onRedoClick = {},
        onUndoClick = {})
}