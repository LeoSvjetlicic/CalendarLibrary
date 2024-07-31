package com.example.calendarlibrary.ui.calendar

import com.example.calendarlibrary.ui.calendarday.CalendarDayViewState

data class CalendarViewState(
    val month: String,
    val year: Int,
    val daysOfWeek: List<String>,
    val dates: List<List<CalendarDayViewState>>
)
