package com.example.calendarlibrary.ui.calendarday.singleday

interface ICalendarDay {
    val value: Int
    val isSelected: Boolean
    val currentMonth: Boolean
    val isToday: Boolean
}

data class CalendarDayViewState(
    override val value: Int,
    override val isSelected: Boolean,
    override val currentMonth: Boolean,
    override val isToday: Boolean
) : ICalendarDay
