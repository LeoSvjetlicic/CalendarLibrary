package com.example.calendarlibrary.utils

import com.example.calendarlibrary.ui.calendar.ICalendarViewState
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.format.TextStyle
import java.time.temporal.TemporalAdjusters
import java.util.Locale

/**
 * Base class for calendar helper implementations.
 *
 * This class provides common functionality for generating calendar data,
 * such as weekday names and week grids. Subclasses are responsible for
 * generating the actual calendar view state based on the provided data.
 *
 * @param weekDays The range of days in a week.
 */
abstract class BaseCalendarHelper(
    override val weekDays: List<DayOfWeek>
) : ICalendarHelper {

    /**
     * Generates a list of weekday names based on the provided style and locale.
     *
     * This method uses the `weekDays` property and the `getDisplayName` function
     * on each `DayOfWeek` to retrieve the formatted names according to the
     * specified style (e.g., full, abbreviated) and locale.
     *
     * @param style The style for formatting weekday names (e.g., TextStyle.FULL, TextStyle.ABBREVIATED).
     * @param locale The locale for formatting weekday names.
     * @return A list of formatted weekday names as strings.
     */
    override fun getDaysOfWeekNames(
        style: TextStyle,
        locale: Locale,
    ): List<String> = weekDays.map { it.getDisplayName(style, locale) }

    /**
     * Generates a list of weeks containing LocalDate objects for the specified year and month.
     *
     * This method calculates the start and end dates of the month and then iterates
     * through each week, considering the first and last days that fall within the month.
     * It uses the `weekDays` property to determine the starting day of the week.
     *
     * @param year The year for which to generate weeks.
     * @param month The month for which to generate weeks.
     * @return A list of lists containing LocalDate objects for each week in the month.
     */
    override fun generateWeeks(
        year: Int,
        month: Month,
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
            currentDate = currentDate.plusDays((7 - weekDays.size).toLong())
            weeks.add(datesOfWeek)
        }
        return weeks
    }

    /**
     * Abstract method to generate the ICalendarViewState.
     *
     * @param year The year to display.
     * @param month The month to display.
     * @param weekDayStyle The style for weekday text.
     * @param monthStyle The style for month text.
     * @param locale The locale for formatting text.
     * @param selected The selected date information.
     * @return The generated calendar view state object.
     */
    abstract override fun generateCalendarViewState(
        year: Int,
        month: Month,
        weekDayStyle: TextStyle,
        monthStyle: TextStyle,
        locale: Locale,
        selected: Selected?
    ): ICalendarViewState
}
