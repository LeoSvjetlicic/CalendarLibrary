package com.example.calendarlibrary.utils

import com.example.calendarlibrary.ui.calendar.CalendarViewState
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.format.TextStyle
import java.time.temporal.TemporalAdjusters
import java.util.Locale

abstract class DefaultCalendarHelper(
    private val weekDays: List<DayOfWeek> = listOf(
        DayOfWeek.MONDAY,
        DayOfWeek.TUESDAY,
        DayOfWeek.WEDNESDAY,
        DayOfWeek.THURSDAY,
        DayOfWeek.FRIDAY,
        DayOfWeek.SATURDAY,
        DayOfWeek.SUNDAY
    )
) {

    protected fun getDaysOfWeekNames(
        style: TextStyle,
        locale: Locale,
    ): List<String> = weekDays.map { it.getDisplayName(style, locale) }

    fun generateWeeks(
        year: Int = LocalDate.now().year,
        month: Month = LocalDate.now().month,
    ): List<List<LocalDate>> {
        val startOfMonth = LocalDate.of(year, month.value, 1)
        val endOfMonth = startOfMonth.with(TemporalAdjusters.lastDayOfMonth())

        val startOfFirstWeek = startOfMonth.with(TemporalAdjusters.previousOrSame(weekDays[0]))
        val endOfLastWeek = endOfMonth.with(TemporalAdjusters.nextOrSame(weekDays.last()))

        val weeks = mutableListOf<List<LocalDate>>()
        var currentDate = startOfFirstWeek

        while (currentDate <= endOfLastWeek) {
            val datesOfWeek = mutableListOf<LocalDate>()

            repeat(weekDays.size) {
                datesOfWeek.add(currentDate)
                currentDate = currentDate.plusDays(1)
            }

            weeks.add(datesOfWeek)
        }
        return weeks
    }

    abstract fun generateCalendarViewState(
        year: Int = LocalDate.now().year,
        month: Month = LocalDate.now().month,
        weekDayStyle: TextStyle = TextStyle.NARROW,
        monthStyle: TextStyle = TextStyle.SHORT,
        locale: Locale = Locale.getDefault(),
        selectedDay: String = ""
    ): CalendarViewState
}
