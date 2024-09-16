package com.leosvjetlicic.calendarlibrary.ui.calendar

import com.leosvjetlicic.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.CalendarHeaderViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarweekdays.CalendarWeekDaysViewState

/**
 * Interface representing the state of a calendar view.
 *
 * This interface provides the essential state components needed to render a calendar view.
 * Implementations of this interface should provide the details required to display
 * the header, the week days, and the days of the calendar.
 *
 * @property headerViewState Represents the state of the calendar header, including any relevant
 *                           information to be displayed in the header, such as the current month and year.
 * @property weekDaysViewState Represents the state of the week days, including the names or labels
 *                              of the days that appear in the calendar's header row.
 * @property daysViewState Represents the state of the individual days in the calendar, including
 *                          details about each day, such as whether it is selected, today, etc.
 */
interface ICalendarViewState {
    val headerViewState: CalendarHeaderViewState
    val weekDaysViewState: CalendarWeekDaysViewState
    val daysViewState: CalendarDaysViewState
}
