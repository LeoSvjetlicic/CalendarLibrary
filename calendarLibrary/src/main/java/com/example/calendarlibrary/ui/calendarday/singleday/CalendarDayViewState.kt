package com.example.calendarlibrary.ui.calendarday.singleday

interface ICalendarDay {
    val value: Int
    val isSelected: Boolean
    val isCurrentMonth: Boolean
    val isToday: Boolean
}

data class CalendarDayViewState(
    override val value: Int,
    override val isSelected: Boolean,
    override val isCurrentMonth: Boolean,
    override val isToday: Boolean
) : ICalendarDay
