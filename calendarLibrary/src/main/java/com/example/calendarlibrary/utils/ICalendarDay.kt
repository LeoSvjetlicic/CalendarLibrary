package com.example.calendarlibrary.utils

import com.example.calendarlibrary.ui.calendar.ICalendarViewState
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.format.TextStyle
import java.util.Locale

sealed class SelectedDays {
    data class SingleDay(val day: LocalDate?) : SelectedDays()
    data class DayRange(val startDay: LocalDate?, val endDay: LocalDate?) : SelectedDays()
}

interface ICalendarHelper {
    val weekDays: List<DayOfWeek>

    fun getDaysOfWeekNames(
        style: TextStyle,
        locale: Locale,
    ): List<String>

    fun generateWeeks(
        year: Int = LocalDate.now().year,
        month: Month = LocalDate.now().month,
    ): List<List<LocalDate>>

    fun generateCalendarViewState(
        year: Int = LocalDate.now().year,
        month: Month = LocalDate.now().month,
        weekDayStyle: TextStyle = TextStyle.NARROW,
        monthStyle: TextStyle = TextStyle.SHORT,
        locale: Locale = Locale.getDefault(),
        selectedDays: SelectedDays = SelectedDays.SingleDay(null)
    ): ICalendarViewState
}
