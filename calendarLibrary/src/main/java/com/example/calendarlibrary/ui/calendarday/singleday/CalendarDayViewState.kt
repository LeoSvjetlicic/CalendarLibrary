package com.example.calendarlibrary.ui.calendarday.singleday

import java.time.LocalDate

/**
 * Data class representing the state of a single calendar day.
 *
 * This class provides a concrete implementation of the [ICalendarDay] interface, encapsulating
 * all the necessary information to describe a calendar day, including its date, selection status,
 * and whether it is part of the current month or is today.
 *
 * @see ICalendarDay for parameter details
 * */
data class CalendarDayViewState(
    override val value: LocalDate,
    override val isSelected: Boolean,
    override val isCurrentMonth: Boolean,
    override val isToday: Boolean
) : ICalendarDay
