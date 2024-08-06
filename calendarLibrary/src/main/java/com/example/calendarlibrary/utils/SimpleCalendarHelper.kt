package com.example.calendarlibrary.utils

import com.example.calendarlibrary.examples.simpleexample.SimpleCalendarViewState
import com.example.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.example.calendarlibrary.ui.calendarday.singleday.CalendarDayViewState
import com.example.calendarlibrary.ui.calendarheader.CalendarHeaderViewState
import com.example.calendarlibrary.ui.calendarweekdays.CalendarWeekDaysViewState
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

class SimpleCalendarHelper(
    override val weekDays: List<DayOfWeek>
) : BaseCalendarHelper(weekDays) {
    override fun getDaysOfWeekNames(
        style: TextStyle,
        locale: Locale,
    ): List<String> = DayOfWeek.entries.map { it.getDisplayName(style, locale) }

    override fun generateCalendarViewState(
        year: Int,
        month: Month,
        weekDayStyle: TextStyle,
        monthStyle: TextStyle,
        locale: Locale,
        selectedDay: String
    ): SimpleCalendarViewState {
        val currentDay = LocalDate.now()
        val weeks = generateWeeks(year, month)
        val selectedElement = if (selectedDay.isNotEmpty()) {
            selectedDay.split(" ")
        } else {
            emptyList()
        }
        return SimpleCalendarViewState(
            headerViewState = CalendarHeaderViewState(
                currentDate = month.getDisplayName(monthStyle, locale) + " $year"
            ),
            weekDaysViewState = CalendarWeekDaysViewState(getDaysOfWeekNames(weekDayStyle, locale)),
            daysViewState = CalendarDaysViewState(
                days = weeks.map { days ->
                    days.map { day ->
                        CalendarDayViewState(
                            value = day.dayOfMonth,
                            isSelected =
                            selectedElement.isNotEmpty() &&
                                    selectedElement[1] == day.dayOfMonth.toString() &&
                                    selectedElement[0].equals(
                                        day.month.getDisplayName(monthStyle, locale),
                                        true
                                    ) && selectedElement[2] == day.year.toString(),
                            isToday = day == currentDay,
                            isCurrentMonth = day.monthValue == month.value && day.year == year
                        )
                    }
                }
            ),
            today = currentDay.format(DateTimeFormatter.ofPattern("d MMMM yyyy"))
        )
    }
}
