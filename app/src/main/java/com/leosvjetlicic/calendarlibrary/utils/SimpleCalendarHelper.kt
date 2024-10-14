package com.leosvjetlicic.calendarlibrary.utils

import com.leosvjetlicic.calendarlibrary.examples.simpleexample.SimpleCalendarViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarday.singleday.CalendarDayViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.CalendarHeaderViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarweekdays.CalendarWeekDaysViewState
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

/**
 * A concrete calendar helper class that provides a simple implementation for generating calendar data.
 * @param weekDays changing enables you to select what week day range to display.
 */
class SimpleCalendarHelper(
    override val weekDays: List<DayOfWeek>
) : BaseCalendarHelper(weekDays) {
    /**
     * Generates a view state representing the calendar for a given year and month.
     *
     * For parameter details @see [BaseCalendarHelper.generateCalendarViewState]
     *
     * @return A SimpleCalendarViewState object containing all necessary data to display the calendar.
     */
    override fun generateCalendarViewState(
        year: Int,
        month: Month,
        weekDayStyle: TextStyle,
        monthStyle: TextStyle,
        locale: Locale,
        selected: Selected?
    ): SimpleCalendarViewState {
        val currentDay = LocalDate.now()
        val weeks = generateWeeks(year, month)
        return SimpleCalendarViewState(
            headerViewState = CalendarHeaderViewState(
                currentDate = month.getDisplayName(monthStyle, locale) + " $year"
            ),
            weekDaysViewState = CalendarWeekDaysViewState(getDaysOfWeekNames(weekDayStyle, locale)),
            daysViewState = CalendarDaysViewState(
                days = weeks.map { days ->
                    days.map { day ->
                        CalendarDayViewState(
                            value = day,
                            isSelected = selected is Selected.SingleDay && selected.day != null &&
                                    selected.day == day,
                            isToday = day == currentDay,
                            isCurrentMonth = day.month == month && day.year == year
                        )
                    }
                }
            ),
            today = currentDay.format(DateTimeFormatter.ofPattern("d MMMM yyyy"))
        )
    }
}
