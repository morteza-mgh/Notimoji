package mgh.morteza.feature.main

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import javax.inject.Inject

class MainViewModel @Inject constructor() {

    private val _uiState = MutableLoginUiState()
    val uiState: MainUiState = _uiState

}

@Stable
interface MainUiState {
    val notes: List<NoteUi>
    val searchInput: String
}

private class MutableLoginUiState: MainUiState {
    override var notes: List<NoteUi> by mutableStateOf(listOf())
    override var searchInput: String by mutableStateOf("")
}

data class NoteUi(
    val id: Int = 0,
    val title: String,
    val body: String,
    val lastEditDate: String,
    val emojiTags: List<String>,
)