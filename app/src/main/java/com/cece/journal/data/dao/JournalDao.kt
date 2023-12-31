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
    fun getOne(journalId: Long): Journal?

    @Query("SELECT * FROM journal WHERE date LIKE :date")
    fun getAllByDate(date: Date): LiveData<List<Journal>>

    /**
     * insert a single record.
     * returns primary key if successful,
     * and -1 if not.
     */
    @Insert
    suspend fun insert(journal: Journal): Long

    /**
     * delete a single record.
     * returns 1 if successful, else 0.
     */
    @Delete
    suspend fun delete(journal: Journal): Int

    /**
     * update a single record.
     * returns -1 if successful, else 0.
     */
    @Update
    suspend fun update(journal: Journal): Int
}