package com.leosvjetlicic.calendarlibrary.utils

import com.leosvjetlicic.calendarlibrary.examples.defaultrangeexample.DefaultRangeCalendarDayViewState
import com.leosvjetlicic.calendarlibrary.examples.rangeexample.RangeCalendarViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.CalendarHeaderViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarweekdays.CalendarWeekDaysViewState
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.format.TextStyle
import java.util.Locale

/**
 * Class that enables you use a range of selected days in a calendar.
 * @param weekDays changing enables you to select what week day range to display.
 */
class DefaultRangeCalendarHelper(
    override val weekDays: List<DayOfWeek>
) : BaseCalendarHelper(weekDays) {
    /**
     * Generates a RangeCalendarViewState representing the calendar for a given year and month.
     *
     * For parameter details @see [BaseCalendarHelper.generateCalendarViewState]
     *
     * Enables you to select a range of days.
     */
    override fun generateCalendarViewState(
        year: Int,
        month: Month,
        weekDayStyle: TextStyle,
        monthStyle: TextStyle,
        locale: Locale,
        selected: Selected?
    ): RangeCalendarViewState {
        val currentDay = LocalDate.now()
        val weeks = generateWeeks(year, month)
        val tempSelected = if (selected != null) {
            (selected as Selected.DayRange)
        } else {
            Selected.DayRange(null, null)
        }
        return RangeCalendarViewState(
            headerViewState = CalendarHeaderViewState(
                currentDate = month.getDisplayName(monthStyle, locale) + " $year"
            ),
            weekDaysViewState = CalendarWeekDaysViewState(getDaysOfWeekNames(weekDayStyle, locale)),
            daysViewState = CalendarDaysViewState(
                days = weeks.map { days ->
                    days.map { day ->
                        DefaultRangeCalendarDayViewState(
                            value = day,
                            isSelected = day == tempSelected.startDay || day == tempSelected.endDay,
                            isToday = day == currentDay,
                            isCurrentMonth = day.monthValue == month.value && day.year == year,
                            isFirstDayInRange = tempSelected.startDay == day,
                            isInRange = if (tempSelected.startDay != null && tempSelected.endDay != null) {
                                tempSelected.startDay!! <= day && tempSelected.endDay!! >= day
                            } else {
                                false
                            }
                        )
                    }
                }
            ),
            selectedRange = tempSelected
        )
    }
}
