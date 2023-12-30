package com.cece.journal.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cece.journal.data.dao.JournalDao
import com.cece.journal.data.entity.Journal

@Database(
    version = 1,
    entities = [
    Journal::class
])
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun journalDao(): JournalDao
}