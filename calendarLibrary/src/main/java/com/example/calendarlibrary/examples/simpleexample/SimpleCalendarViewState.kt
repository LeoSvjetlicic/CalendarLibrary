package com.example.calendarlibrary.examples.simpleexample

import com.example.calendarlibrary.ui.calendar.ICalendarViewState
import com.example.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.example.calendarlibrary.ui.calendarheader.CalendarHeaderViewState
import com.example.calendarlibrary.ui.calendarweekdays.CalendarWeekDaysViewState

data class SimpleCalendarViewState(
    override val headerViewState: CalendarHeaderViewState,
    override val weekDaysViewState: CalendarWeekDaysViewState,
    override val daysViewState: CalendarDaysViewState,
    val today: String
) : ICalendarViewState
