package mgh.morteza.feature.add

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(): ViewModel() {

    private val _uiState = MutableAddNoteUiState()
    val uiState : AddNoteUiState = _uiState

    fun onchangeTitle(title: String) {
        // todo
    }

    fun onchangeBody(body: String) {
        // todo
    }

}

@Stable
interface AddNoteUiState {
    val title: String
    val body: String
    val emojiTags: List<String>
}

private class MutableAddNoteUiState: AddNoteUiState {
    override var title: String by mutableStateOf("")
    override var body: String by mutableStateOf("")
    override var emojiTags: List<String> by mutableStateOf(listOf())
}