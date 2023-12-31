package com.cece.journal.data.repository

import androidx.lifecycle.LiveData
import com.cece.journal.data.dao.JournalDao
import com.cece.journal.data.entity.Journal
import javax.inject.Inject

/**
 * handle data access of journal entity
 * from both local and remote datasource
 */
interface JournalRepository {
    fun getAll(): LiveData<List<Journal>>
    fun getOne(id: Long): Journal?

    suspend fun create(journal: Journal): Journal?
    suspend fun update(journal: Journal): Journal?
    suspend fun delete(journal: Journal): Int
}

class JournalRepositoryImpl @Inject constructor (
    private val dao: JournalDao,
): JournalRepository {
    override fun getAll(): LiveData<List<Journal>> {
        return dao.getAll()
    }

    override fun getOne(id: Long): Journal? {
        return dao.getOne(id)
    }

    override suspend fun create(journal: Journal): Journal? {
        val id = dao.insert(journal)
        return if(id > 0) {
            dao.getOne(id);
        } else {
            null
        }
    }
    override suspend fun update(journal: Journal): Journal? {
        return if(dao.update(journal) > 0) {
            dao.getOne(journalId = journal.id)
        } else {
            null
        }
    }
    override suspend fun delete(journal: Journal): Int {
        return dao.delete(journal)
    }

}