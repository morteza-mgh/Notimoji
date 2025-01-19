package mgh.morteza.core.model

data class Note(
    val id: Int = 0,
    val title: String,
    val body: String,
    val lastEditTimeStamp: Long,
)