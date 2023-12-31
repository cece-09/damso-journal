package com.cece.journal

import android.app.Application
import androidx.room.Room
import com.cece.journal.data.dao.JournalDao
import com.cece.journal.data.database.AppDatabase
import com.cece.journal.data.repository.JournalRepository
import com.cece.journal.data.repository.JournalRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java, "app-db"
        ).build()
    }
    @Singleton
    @Provides
    fun provideJournalDao(database: AppDatabase): JournalDao {
        return database.journalDao()
    }
    @Provides
    fun provideJournalRepository(dao: JournalDao): JournalRepository {
        return JournalRepositoryImpl(dao)
    }
}