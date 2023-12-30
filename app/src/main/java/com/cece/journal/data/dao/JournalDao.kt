package com.cece.journal.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.cece.journal.data.entity.Journal
import java.util.*

@Dao
interface JournalDao {
    @Query("SELECT * FROM journal")
    fun getAll(): LiveData<List<Journal>>

    @Query("SELECT * FROM journal WHERE id LIKE :journalId LIMIT 1")
    fun getOne(journalId: Int): Journal?

    @Query("SELECT * FROM journal WHERE date LIKE :date")
    fun getAllByDate(date: Date): LiveData<List<Journal>>

    @Insert
    suspend fun insertOne(journal: Journal)

    @Delete
    suspend fun delete(journal: Journal)

    @Update
    suspend fun update(journal: Journal)
}