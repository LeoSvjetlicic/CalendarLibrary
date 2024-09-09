package com.example.calendarlibrary.utils.rangehelper

import com.example.calendarlibrary.examples.rangeexample.RangeCalendarDay
import com.example.calendarlibrary.examples.rangeexample.RangeCalendarViewState
import com.example.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.example.calendarlibrary.ui.calendarheader.CalendarHeaderViewState
import com.example.calendarlibrary.ui.calendarweekdays.CalendarWeekDaysViewState
import com.example.calendarlibrary.utils.BaseCalendarHelper
import com.example.calendarlibrary.utils.SelectedDays
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.format.TextStyle
import java.util.Locale

class RangeCalendarHelper(
    override val weekDays: List<DayOfWeek>
) : BaseCalendarHelper(weekDays) {
    override fun generateCalendarViewState(
        year: Int,
        month: Month,
        weekDayStyle: TextStyle,
        monthStyle: TextStyle,
        locale: Locale,
        selectedDays: SelectedDays
    ): RangeCalendarViewState {
        val currentDay = LocalDate.now()
        val weeks = generateWeeks(year, month)
        return RangeCalendarViewState(
            headerViewState = CalendarHeaderViewState(
                currentDate = month.getDisplayName(monthStyle, locale) + " $year"
            ),
            weekDaysViewState = CalendarWeekDaysViewState(getDaysOfWeekNames(weekDayStyle, locale)),
            daysViewState = CalendarDaysViewState(
                days = weeks.map { days ->
                    days.map { day ->
                        val tempSelectedDays = (selectedDays as SelectedDays.DayRange)
                        RangeCalendarDay(
                            value = day,
                            isSelected = day == tempSelectedDays.startDay || day == tempSelectedDays.endDay,
                            isToday = day == currentDay,
                            isCurrentMonth = day.monthValue == month.value && day.year == year,
                            isInRange = if (tempSelectedDays.startDay != null && tempSelectedDays.endDay != null) {
                                tempSelectedDays.startDay < day && tempSelectedDays.endDay > day
                            } else {
                                false
                            }
                        )
                    }
                }
            ),
            selectedRange = selectedDays as SelectedDays.DayRange
        )
    }
}
