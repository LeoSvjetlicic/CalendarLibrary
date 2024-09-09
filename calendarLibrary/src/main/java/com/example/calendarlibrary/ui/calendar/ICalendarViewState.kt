package com.example.calendarlibrary.ui.calendar

import com.example.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.example.calendarlibrary.ui.calendarheader.CalendarHeaderViewState
import com.example.calendarlibrary.ui.calendarweekdays.CalendarWeekDaysViewState


interface ICalendarViewState {
    val headerViewState: CalendarHeaderViewState
    val weekDaysViewState: CalendarWeekDaysViewState
    val daysViewState: CalendarDaysViewState
}