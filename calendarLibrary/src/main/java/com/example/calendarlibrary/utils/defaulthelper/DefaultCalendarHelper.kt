package com.example.calendarlibrary.utils.defaulthelper

import com.example.calendarlibrary.ui.calendar.DefaultCalendarViewState
import com.example.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.example.calendarlibrary.ui.calendarday.singleday.CalendarDayViewState
import com.example.calendarlibrary.ui.calendarheader.CalendarHeaderViewState
import com.example.calendarlibrary.ui.calendarweekdays.CalendarWeekDaysViewState
import com.example.calendarlibrary.utils.BaseCalendarHelper
import com.example.calendarlibrary.utils.SelectedDays
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.format.TextStyle
import java.util.Locale

class DefaultCalendarHelper(
    weekDays: List<DayOfWeek> = listOf(
        DayOfWeek.MONDAY,
        DayOfWeek.TUESDAY,
        DayOfWeek.WEDNESDAY,
        DayOfWeek.THURSDAY,
        DayOfWeek.FRIDAY,
        DayOfWeek.SATURDAY,
        DayOfWeek.SUNDAY
    )
) : BaseCalendarHelper(weekDays) {

    override fun generateCalendarViewState(
        year: Int,
        month: Month,
        weekDayStyle: TextStyle,
        monthStyle: TextStyle,
        locale: Locale,
        selectedDays: SelectedDays
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
                            selectedDays is SelectedDays.SingleDay && selectedDays.day != null &&
                                    selectedDays.day == day,
                            isToday = day == currentDay,
                            isCurrentMonth = day.monthValue == month.value && day.year == year
                        )
                    }
                }
            )
        )
    }
}
