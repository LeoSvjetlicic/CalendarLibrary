package com.leosvjetlicic.calendarlibrary.examples.rangeexample

import com.leosvjetlicic.calendarlibrary.ui.calendarday.singleday.ICalendarDay
import java.time.LocalDate

/**
 * Represents a day in a range calendar.
 *
 * @param value The date of the day.
 * @param isSelected Whether the day is selected.
 * @param isCurrentMonth Whether the day is in the current month.
 * @param isToday Whether the day is today.
 * @param isInRange Whether the day is within a selected range.
 */
data class RangeCalendarDay(
    override val value: LocalDate,
    override val isSelected: Boolean,
    override val isCurrentMonth: Boolean,
    override val isToday: Boolean,
    val isInRange: Boolean
) : ICalendarDay
