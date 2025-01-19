package mgh.morteza.core.database.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mgh.morteza.core.database.NotimojiDataBase
import mgh.morteza.core.database.dao.NoteDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    @Singleton
    fun noteDao(db: NotimojiDataBase): NoteDao = db.noteDao()

}