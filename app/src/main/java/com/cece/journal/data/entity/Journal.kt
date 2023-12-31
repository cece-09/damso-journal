package com.cece.journal.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Journal(
    @ColumnInfo(name = "content")
    val content: String?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    @ColumnInfo(name = "date")
    var date: Date = Date()
}