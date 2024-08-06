package com.example.calendarlibrary.utils

import com.example.calendarlibrary.ui.calendar.CalendarViewState
import com.example.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.example.calendarlibrary.ui.calendarday.singleday.CalendarDayViewState
import com.example.calendarlibrary.ui.calendarheader.CalendarHeaderViewState
import com.example.calendarlibrary.ui.calendarweekdays.CalendarWeekDaysViewState
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.format.TextStyle
import java.util.Locale

class SimpleCalendarHelper(
    weekDays: List<DayOfWeek> = listOf(
        DayOfWeek.MONDAY,
        DayOfWeek.TUESDAY,
        DayOfWeek.WEDNESDAY,
        DayOfWeek.THURSDAY,
        DayOfWeek.FRIDAY,
        DayOfWeek.SATURDAY,
        DayOfWeek.SUNDAY
    )
) : DefaultCalendarHelper(weekDays) {

    override fun generateCalendarViewState(
        year: Int,
        month: Month,
        weekDayStyle: TextStyle,
        monthStyle: TextStyle,
        locale: Locale,
        selectedDay: String
    ): CalendarViewState {
        val currentDay = LocalDate.now()
        val weeks = generateWeeks(year, month)
        val selectedElement = if (selectedDay.isNotEmpty()) {
            selectedDay.split(" ")
        } else {
            emptyList()
        }
        return CalendarViewState(
            headerViewState = CalendarHeaderViewState(
                currentDate = month.getDisplayName(monthStyle, locale) + " $year"
            ),
            weekDaysViewState = CalendarWeekDaysViewState(getDaysOfWeekNames(weekDayStyle, locale)),
            daysViewState = CalendarDaysViewState(
                daysViewState = weeks.map { days ->
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
                            currentMonth = day.monthValue == month.value && day.year == year
                        )
                    }
                }
            )
        )
    }
}
