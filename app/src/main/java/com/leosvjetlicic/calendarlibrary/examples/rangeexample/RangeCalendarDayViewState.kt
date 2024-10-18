package com.leosvjetlicic.calendarlibrary.examples.rangeexample

import com.leosvjetlicic.calendarlibrary.ui.calendarday.singleday.ICalendarDay
import java.time.LocalDate

/**
 * Represents a day in a range calendar.
 *
 * @param value The date of the day.
 * @param isSelected Is the day selected.
 * @param isCurrentMonth Is the day in the current month.
 * @param isToday Is the day today.
 * @param isInRange Is the day within a selected range.
 */
data class RangeCalendarDayViewState(
    override val value: LocalDate,
    override val isSelected: Boolean,
    override val isCurrentMonth: Boolean,
    override val isToday: Boolean,
    val isInRange: Boolean
) : ICalendarDay
