package com.example.calendarlibrary.utils

import java.time.LocalDate

sealed class SelectedDays {
    data class SingleDay(val day: LocalDate?) : SelectedDays()
    data class DayRange(val startDay: LocalDate?, val endDay: LocalDate?) : SelectedDays()
}
