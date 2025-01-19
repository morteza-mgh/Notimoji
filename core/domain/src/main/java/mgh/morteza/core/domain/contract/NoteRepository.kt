package mgh.morteza.core.domain.contract

import kotlinx.coroutines.flow.Flow
import mgh.morteza.core.model.Note

interface NoteRepository {

    suspend fun insertNotes(notes: List<Note>): Array<Long>

    suspend fun updateNote(note: Note)

    suspend fun deleteNote(note: Note)

    suspend fun deleteNoteById(id: Int)

    fun getNotes(): Flow<List<Note>>

    fun getNoteById(id: Int): Flow<Note>

}