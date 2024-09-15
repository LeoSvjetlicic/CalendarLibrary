package com.example.calendarlibrary.examples.rangeexample

import com.example.calendarlibrary.ui.calendar.ICalendarViewState
import com.example.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.example.calendarlibrary.ui.calendarheader.CalendarHeaderViewState
import com.example.calendarlibrary.ui.calendarweekdays.CalendarWeekDaysViewState
import com.example.calendarlibrary.utils.Selected

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
