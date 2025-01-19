package mgh.morteza.core.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
    ],
    exportSchema = false
)
abstract class NotimojiDataBase: RoomDatabase() {

    // todo provide dao
}