package com.cece.journal.data.database

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class Converters {
    private val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA)

    @TypeConverter
    fun fromDate(date: Date): String {
        return formatter.format(date)
    }

    @TypeConverter
    fun toDate(string: String): Date? {
        return formatter.parse(string)
    }
}