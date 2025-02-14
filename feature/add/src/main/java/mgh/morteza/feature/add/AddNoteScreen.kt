package mgh.morteza.feature.add

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import mgh.morteza.core.designsystem.HORIZONTAL_PADDING
import mgh.morteza.core.designsystem.theme.NotimojiTheme
import mgh.morteza.core.ui.component.NoteAppbar

@Composable
fun AddNoteScreen(viewModel: AddNoteViewModel = hiltViewModel()) {
    AddNoteScreen(
        uiState = viewModel.uiState,
        onchangeTitle = viewModel::onchangeTitle,
        onChangeBody = viewModel::onchangeBody
    )
}

@Composable
private fun AddNoteScreen(
    uiState: AddNoteUiState,
    onchangeTitle: (String) -> Unit,
    onChangeBody: (String) -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            NoteAppbar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom =  16.dp, start = 4.dp, end = 10.dp),
                onDoneClick = {},
                onUndoClick = {},
                onRedoClick = {},
                onMoreClick = {}
            )
        },
    ) { innerPadding ->
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = HORIZONTAL_PADDING)
                .verticalScroll(rememberScrollState())
        ) {
            val (
                titleTextField,
                titleHint,
                bodyTextField,
                bodyHint,
            ) = createRefs()


            BasicTextField(
                modifier = Modifier.constrainAs(titleTextField) {
                    top.linkTo(parent.top, 8.dp)
                    width = Dimension.matchParent
                },
                textStyle = TextStyle.Default.copy(fontWeight = FontWeight.Bold),
                value = uiState.title,
                onValueChange = onchangeTitle
            )

            if (uiState.title.isEmpty()) {
                Text(
                    modifier = Modifier.constrainAs(titleHint) {
                        centerVerticallyTo(titleTextField)
                        start.linkTo(parent.start)
                    },
                    text = "Title...",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            BasicTextField(
                modifier = Modifier.constrainAs(bodyTextField) {
                    top.linkTo(titleTextField.bottom, 12.dp)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                    width = Dimension.matchParent
                },
                value = uiState.body,
                onValueChange = onChangeBody
            )

            if (uiState.body.isEmpty()) {
                Text(
                    modifier = Modifier.constrainAs(bodyHint) {
                        top.linkTo(bodyTextField.top)
                        bottom.linkTo(bodyTextField.baseline)
                        start.linkTo(parent.start)
                    },
                    text = "Enter your text here...",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Preview
@Composable
private fun AddNoteScreenPreview() = NotimojiTheme {
    AddNoteScreen(
        uiState = object : AddNoteUiState {
            override val title: String
                get() = ""
            override val body: String
                get() = ""
            override val emojiTags: List<String>
                get() = listOf()
        }, {}, {}
    )
}