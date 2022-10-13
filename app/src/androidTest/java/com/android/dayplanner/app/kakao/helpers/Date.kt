package com.android.dayplanner.app.kakao.helpers

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun getCurrentDate(): String {
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    return current.format(formatter)
}

