package com.cece.journal.data.repository

import androidx.lifecycle.LiveData
import com.cece.journal.data.dao.JournalDao
import com.cece.journal.data.entity.Journal
import javax.inject.Inject

// TODO: Interface

class JournalRepository @Inject constructor (
    private val dao: JournalDao,
) {
    fun getAll(): LiveData<List<Journal>> {
        return dao.getAll()
    }

    suspend fun create(journal: Journal) {
        dao.insertOne(journal);
    }
}