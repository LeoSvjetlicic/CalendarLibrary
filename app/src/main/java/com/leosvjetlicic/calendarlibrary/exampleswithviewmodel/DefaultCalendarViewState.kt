package com.leosvjetlicic.calendarlibrary.exampleswithviewmodel

import com.leosvjetlicic.calendarlibrary.ui.calendar.ICalendarViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.CalendarHeaderViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarweekdays.CalendarWeekDaysViewState

/**
 * Data class representing the default implementation of the calendar view state.
 *
 * This class provides a concrete implementation of the [ICalendarViewState] interface, holding
 * the state information required to render a complete calendar view, including the header, week days,
 * and individual days.
 *
 * @param headerViewState The state of the calendar header, including details such as the current month,
 *                        year, and any additional header-related information.
 * @param weekDaysViewState The state of the week days, which includes the names or labels of the days
 *                          that appear in the header row of the calendar.
 * @param daysViewState The state of the individual days in the calendar, including details such as
 *                      whether a day is selected, today's date, and other day-specific information.
 */
data class DefaultCalendarViewState(
    override val headerViewState: CalendarHeaderViewState,
    override val weekDaysViewState: CalendarWeekDaysViewState,
    override val daysViewState: CalendarDaysViewState
) : ICalendarViewState
