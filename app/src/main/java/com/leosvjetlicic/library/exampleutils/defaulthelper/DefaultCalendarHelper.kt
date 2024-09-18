package com.leosvjetlicic.library.exampleutils.defaulthelper

import com.leosvjetlicic.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarday.singleday.CalendarDayViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.CalendarHeaderViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarweekdays.CalendarWeekDaysViewState
import com.leosvjetlicic.calendarlibrary.utils.BaseCalendarHelper
import com.leosvjetlicic.calendarlibrary.utils.Selected
import com.leosvjetlicic.library.exampleswithviewmodel.DefaultCalendarViewState
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.format.TextStyle
import java.util.Locale

/**
 * A calendar helper class that generates default calendar data.
 * @param weekDays changing enables you to select what week day range to display.
 */
class DefaultCalendarHelper(
    override val weekDays: List<DayOfWeek>
) : BaseCalendarHelper(weekDays) {

    /**
     * Generates a view state representing the calendar for a given year and month.
     *
     * For parameter details @see [BaseCalendarHelper.generateCalendarViewState]
     *
     * @return A DefaultCalendarViewState object containing all necessary data to display the calendar.
     */
    override fun generateCalendarViewState(
        year: Int,
        month: Month,
        weekDayStyle: TextStyle,
        monthStyle: TextStyle,
        locale: Locale,
        selected: Selected?
    ): DefaultCalendarViewState {
        val currentDay = LocalDate.now()
        val weeks = generateWeeks(year, month)
        return DefaultCalendarViewState(
            headerViewState = CalendarHeaderViewState(
                currentDate = month.getDisplayName(monthStyle, locale) + " $year"
            ),
            weekDaysViewState = CalendarWeekDaysViewState(getDaysOfWeekNames(weekDayStyle, locale)),
            daysViewState = CalendarDaysViewState(
                days = weeks.map { days ->
                    days.map { day ->
                        CalendarDayViewState(
                            value = day,
                            isSelected =
                            selected is Selected.SingleDay && selected.day != null &&
                                    selected.day == day,
                            isToday = day == currentDay,
                            isCurrentMonth = day.month == month && day.year == year
                        )
                    }
                }
            )
        )
    }
}
