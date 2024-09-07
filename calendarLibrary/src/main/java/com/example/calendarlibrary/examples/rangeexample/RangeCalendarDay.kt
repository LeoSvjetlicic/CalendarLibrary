package com.example.calendarlibrary.examples.rangeexample

import com.example.calendarlibrary.ui.calendarday.singleday.ICalendarDay
import java.time.LocalDate

data class RangeCalendarDay(
    override val value: LocalDate,
    override val isSelected: Boolean,
    override val isCurrentMonth: Boolean,
    override val isToday: Boolean,
    val isInRange: Boolean
) : ICalendarDay
