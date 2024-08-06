package com.example.calendarlibrary.utils

import com.example.calendarlibrary.ui.calendar.CalendarViewState
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.format.TextStyle
import java.util.Locale

interface ICalendarHelper {
    val weekDays: List<DayOfWeek>
    fun generateCalendarViewState(
        year: Int = LocalDate.now().year,
        month: Month = LocalDate.now().month,
        weekDayStyle: TextStyle = TextStyle.NARROW,
        monthStyle: TextStyle = TextStyle.SHORT,
        locale: Locale = Locale.getDefault(),
        selectedDay: String = ""
    ): CalendarViewState

    fun getDaysOfWeekNames(
        style: TextStyle,
        locale: Locale,
    ): List<String>

    fun generateWeeks(
        year: Int = LocalDate.now().year,
        month: Month = LocalDate.now().month,
    ): List<List<LocalDate>>
}
