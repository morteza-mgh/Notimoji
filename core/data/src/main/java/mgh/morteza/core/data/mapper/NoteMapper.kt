package mgh.morteza.core.data.mapper

import mgh.morteza.core.database.entity.NoteEntity
import mgh.morteza.core.model.Note

fun NoteEntity.asNote() = Note(
    id = id,
    title = title,
    body = body,
    lastEditTimeStamp = lastEditTimeStamp
)

fun Note.asNoteEntity() = NoteEntity(
    id = id,
    title = title,
    body = body,
    lastEditTimeStamp = lastEditTimeStamp
)