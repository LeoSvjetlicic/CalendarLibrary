package com.leosvjetlicic.library.examples.rangeexample

import com.leosvjetlicic.calendarlibrary.ui.calendar.ICalendarViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.CalendarHeaderViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarweekdays.CalendarWeekDaysViewState
import com.leosvjetlicic.calendarlibrary.utils.Selected

/**
 * Represents the view state for a range calendar.
 *
 * @param headerViewState The view state for the calendar header.
 * @param weekDaysViewState The view state for the week days.
 * @param daysViewState The view state for the calendar days.
 * @param selectedRange The currently selected day range.
 */
data class RangeCalendarViewState(
    override val headerViewState: CalendarHeaderViewState,
    override val weekDaysViewState: CalendarWeekDaysViewState,
    override val daysViewState: CalendarDaysViewState,
    val selectedRange: Selected.DayRange
) : ICalendarViewState
