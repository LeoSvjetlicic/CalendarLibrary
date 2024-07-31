package com.example.calendarlibrary.ui.calendarday

data class CalendarDayViewState(
    val value: Int,
    val isSelected: Boolean,
    val currentMonth: Boolean,
    val isToday: Boolean
)
