package com.leosvjetlicic.calendarlibrary.ui.calendarday

import com.leosvjetlicic.calendarlibrary.ui.calendarday.singleday.ICalendarDay

/**
 * Data class representing the state of the days in a calendar.
 *
 * This class holds the information needed to display the days in the calendar view, organized in a
 * grid-like structure where each row represents a week and each item represents a day.
 *
 * @param days A list of lists where each inner list represents a week in the calendar. Each item in
 *             these inner lists is an implementation of [ICalendarHelper.kt], representing individual days.
 *             This structure allows for displaying days in a week-by-week format, facilitating the
 *             rendering of a complete month or other time periods in a calendar view.
 */
data class CalendarDaysViewState(
    val days: List<List<ICalendarDay>>
)
