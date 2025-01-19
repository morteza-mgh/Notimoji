package mgh.morteza.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import mgh.morteza.core.database.dao.NoteDao

@Database(
    version = 1,
    entities = [
        NoteDao::class
    ],
    exportSchema = false
)
abstract class NotimojiDataBase: RoomDatabase() {

    abstract fun noteDao(): NoteDao

}