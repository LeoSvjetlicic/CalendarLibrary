package com.example.calendarlibrary.data

data class CalendarDayViewState(
    val value: Int,
    val isSelected: Boolean,
    val currentMonth: Boolean,
    val isToday: Boolean
)