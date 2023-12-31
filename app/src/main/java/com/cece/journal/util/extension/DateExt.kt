package com.cece.journal.util.extension

import java.text.SimpleDateFormat
import java.util.*

fun Date.toViewString(): String {
    val formatter = SimpleDateFormat("yyyy년 MM월 dd일 E", Locale.KOREA)
    return formatter.format(this)
}