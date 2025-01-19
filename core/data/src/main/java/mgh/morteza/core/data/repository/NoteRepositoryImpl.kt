package mgh.morteza.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import mgh.morteza.core.data.mapper.asNote
import mgh.morteza.core.data.mapper.asNoteEntity
import mgh.morteza.core.database.dao.NoteDao
import mgh.morteza.core.database.entity.NoteEntity
import mgh.morteza.core.domain.contract.NoteRepository
import mgh.morteza.core.model.Note
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val noteDao: NoteDao) : NoteRepository {

    override suspend fun insertNotes(notes: List<Note>): Array<Long> {
        return noteDao.insertNotes(notes.map(Note::asNoteEntity))
    }

    override suspend fun updateNote(note: Note) {
        noteDao.updateNote(note.asNoteEntity())
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note.asNoteEntity())
    }

    override suspend fun deleteNoteById(id: Int) {
        noteDao.deleteNoteById(id)
    }

    override fun getNotes(): Flow<List<Note>> {
        return noteDao.getNotes().map { it.map(NoteEntity::asNote) }
    }

    override fun getNoteById(id: Int): Flow<Note> {
        return noteDao.getNoteById(id).map(NoteEntity::asNote)
    }

}