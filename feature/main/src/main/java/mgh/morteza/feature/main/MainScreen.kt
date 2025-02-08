package mgh.morteza.feature.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import mgh.morteza.core.designsystem.HORIZONTAL_PADDING
import mgh.morteza.core.designsystem.component.NotimojiTextField
import mgh.morteza.core.designsystem.component.NotimojiTopAppBar
import mgh.morteza.core.designsystem.theme.NotimojiTheme
import mgh.morteza.core.ui.component.EmojiItem

@Composable
fun MainScreen(uiState: MainUiState, onNewSearchInput: (String) -> Unit) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            NotimojiTopAppBar(
                modifier = Modifier
                    .fillMaxWidth(),
                title = stringResource(id = R.string.my_notes),
            )
        },
    ) { innerPadding ->
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = HORIZONTAL_PADDING)
        ) {
            val (
                searchTextField,
                filterRow,
                noteList
            ) = createRefs()

            NotimojiTextField(
                modifier = Modifier.constrainAs(searchTextField) {
                    top.linkTo(parent.top)
                    width = Dimension.matchParent
                },
                value = uiState.searchInput,
                onValueChange = onNewSearchInput,
                leadingIcon = {
                    Icon(
                        modifier = Modifier.padding(start = 16.dp),
                        painter = painterResource(R.drawable.ic_search),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        contentDescription = stringResource(R.string.search_notes)
                    )
                },
                label = {
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = stringResource(R.string.search_notes),
                        fontSize = 12.sp
                    )
                })

            SortRow(
                modifier = Modifier.constrainAs(filterRow) {
                    top.linkTo(searchTextField.bottom, 20.dp)
                    width = Dimension.matchParent
                },
                filterLabelId = R.string.sorted_by_date
            )

            NoteList(
                modifier = Modifier.constrainAs(noteList) {
                    top.linkTo(filterRow.bottom)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                },
                notes = uiState.notes
            )
        }
    }
}

@Composable
fun SortRow(modifier: Modifier = Modifier, filterLabelId: Int) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.clickable { /* TODO*/ },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(R.drawable.ic_sort),
                contentDescription = stringResource(filterLabelId),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = stringResource(filterLabelId),
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(R.drawable.ic_tiles),
            contentDescription = stringResource(filterLabelId),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun NoteList(modifier: Modifier = Modifier, notes: List<NoteUi>) {
    LazyVerticalStaggeredGrid(
        modifier = modifier,
        columns = StaggeredGridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalItemSpacing = 16.dp,
        contentPadding = PaddingValues(vertical = 16.dp),
    ) {
        items(notes) { note ->
            NoteItem(
                title = note.title,
                body = note.body,
                dateModified = note.lastEditDate,
                emojiTags = note.emojiTags
            )
        }
    }
}

@Composable
fun NoteItem(
    modifier: Modifier = Modifier,
    title: String,
    body: String,
    dateModified: String,
    emojiTags: List<String>
) {
    Column(
        modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(vertical = 11.dp, horizontal = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Medium
            )
            Icon(
                painter = painterResource(R.drawable.ic_more),
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                contentDescription = stringResource(R.string.more)
            )

        }
        Spacer(Modifier.height(10.dp))
        Text(
            text = body,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            minLines = 3,
            maxLines = 6
        )

        Spacer(Modifier.height(10.dp))

        Text(
            text = dateModified,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 12.sp
        )

        if (emojiTags.isNotEmpty()) {
            Spacer(Modifier.height(10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                emojiTags.forEach {
                    EmojiItem(emojiChar = it)
                    Spacer(Modifier.width(4.dp))
                }
            }
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() = NotimojiTheme {
    MainScreen(uiState = object : MainUiState {
        override val notes: List<NoteUi>
            get() = listOf(
                NoteUi(
                    title = "Title",
                    body = LoremIpsum(5).values.first(),
                    lastEditDate = "Sun, 23 Nov 2025",
                    emojiTags = listOf("😄", "❤️", "🧠"),

                    ),
                NoteUi(
                    title = "Title 2",
                    body = LoremIpsum(16).values.last(),
                    lastEditDate = "Sun, 23 Nov 2025",
                    emojiTags = listOf("😄", "🎁", "⭐"),
                ),
                NoteUi(
                    title = "Title 3",
                    body = LoremIpsum(11).values.first(),
                    lastEditDate = "Sun, 21 Feb 2025",
                    emojiTags = listOf("😄", "🤑", "🧠"),
                ),
                NoteUi(
                    title = "Title 4",
                    body = LoremIpsum(16).values.first(),
                    lastEditDate = "Sun, 22 Nov 2024",
                    emojiTags = listOf("🐱", "❤️", "🧠"),
                ),
            )
        override val searchInput: String
            get() = ""
    }, {})
}

@Preview
@Composable
private fun NoteItemPreview() {
    NoteItem(
        Modifier.width(200.dp),
        title = "Title",
        body = LoremIpsum(17).values.first(),
        dateModified = "Sun, 23Nov 2025",
        emojiTags = listOf("😄", "❤️", "🧠")
    )
}