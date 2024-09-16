package com.leosvjetlicic.calendarlibrary.ui.calendarday.singleday

import java.time.LocalDate

/**
 * Interface representing the state of a single calendar day.
 *
 * This interface defines the essential properties for describing a calendar day, including its
 * date, selection status, and whether it is part of the current month or is today.
 * Implementations of this interface should provide these properties to render and manage the
 * state of individual days in a calendar view.
 *
 * @property value The [LocalDate] representing the specific date of the calendar day.
 * @property isSelected A boolean indicating whether the day is selected by the user.
 * @property isCurrentMonth A boolean indicating whether the day is part of the current month displayed in the calendar.
 * @property isToday A boolean indicating whether the day is the current date.
 */
interface ICalendarDay {
    val value: LocalDate
    val isSelected: Boolean
    val isCurrentMonth: Boolean
    val isToday: Boolean
}
