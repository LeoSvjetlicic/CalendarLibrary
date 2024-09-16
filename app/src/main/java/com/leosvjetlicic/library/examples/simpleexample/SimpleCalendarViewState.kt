package com.leosvjetlicic.library.examples.simpleexample

import com.leosvjetlicic.calendarlibrary.ui.calendar.ICalendarViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.CalendarHeaderViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarweekdays.CalendarWeekDaysViewState

/**
 * Represents the view state for a simple calendar.
 *
 * @param headerViewState The view state for the calendar header.
 * @param weekDaysViewState The view state for the week days.
 * @param daysViewState The view state for the calendar days.
 * @param today The current date in a formatted string.
 */
data class SimpleCalendarViewState(
    override val headerViewState: CalendarHeaderViewState,
    override val weekDaysViewState: CalendarWeekDaysViewState,
    override val daysViewState: CalendarDaysViewState,
    val today: String
) : ICalendarViewState
