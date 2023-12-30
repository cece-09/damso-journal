package com.cece.journal.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cece.journal.data.entity.Journal
import com.cece.journal.data.repository.JournalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val journalRepository: JournalRepository
): ViewModel() {
    private val formatter = SimpleDateFormat("yyyy년 MM월 dd일", Locale.KOREA)

    /* read only fields */
    val today: String = formatter.format(Date())
    val journals = journalRepository.getAll()

    /* input fields */
    private val _content = MutableLiveData("")
    val content: LiveData<String> get() = _content

    suspend fun save() {
        if(content.value!!.isEmpty()) return
        journalRepository.create(Journal(content = content.value))
    }

    fun updateContent(value: String) {
        _content.value = value
    }
}