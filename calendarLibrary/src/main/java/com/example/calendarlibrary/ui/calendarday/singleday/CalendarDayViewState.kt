package com.example.calendarlibrary.ui.calendarday.singleday

import java.time.LocalDate

interface ICalendarDay {
    val value: LocalDate
    val isSelected: Boolean
    val isCurrentMonth: Boolean
    val isToday: Boolean
}

data class CalendarDayViewState(
    override val value: LocalDate,
    override val isSelected: Boolean,
    override val isCurrentMonth: Boolean,
    override val isToday: Boolean
) : ICalendarDay
