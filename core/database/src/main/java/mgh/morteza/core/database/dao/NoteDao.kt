package mgh.morteza.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import mgh.morteza.core.database.entity.NoteEntity

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(notes: List<NoteEntity>): Array<Long>

    @Update
    suspend fun updateNote(note: NoteEntity)

    @Delete
    suspend fun deleteNote(note: NoteEntity)

    @Query("DELETE FROM note_table WHERE id = :id")
    suspend fun deleteNoteById(id: Int)

    @Query("SELECT * FROM note_table")
    fun getNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM note_table WHERE id = :id")
    fun getNoteById(id: Int): Flow<NoteEntity>

}