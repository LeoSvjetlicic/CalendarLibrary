package com.example.calendarlibrary.utils

import com.example.calendarlibrary.ui.calendar.ICalendarViewState
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.format.TextStyle
import java.util.Locale

/**
 * This interface defines helper methods for calendar functionality.
 */
interface ICalendarHelper {

    /**
     *  An unmodifiable list of all days of the week represented by the [DayOfWeek] enum.
     */
    val weekDays: List<DayOfWeek>

    /**
     * Generates a list of weekday names based on the provided styling and locale.
     *
     * @param style The text style for formatting the weekday names
     *        (e.g., [TextStyle.FULL] for full names, [TextStyle.SHORT] for abbreviations).
     * @param locale The locale to use for formatting the names.
     * @return A list of weekday names as strings.
     */
    fun getDaysOfWeekNames(
        style: TextStyle,
        locale: Locale
    ): List<String>

    /**
     * Generates a list of weeks for a specific month of a year.
     * Each inner list represents a week containing `LocalDate` objects.
     *
     * @param year The year (defaults to current year).
     * @param month The month (defaults to current month).
     * @return A list of weeks, where each week is a list of `LocalDate` objects.
     */
    fun generateWeeks(
        year: Int = LocalDate.now().year,
        month: Month = LocalDate.now().month
    ): List<List<LocalDate>>

    /**
     * Generates a complete calendar
     * @see ICalendarViewState based on provided parameters.
     * This state object contains data for rendering the calendar UI.
     *
     * @param year The year for which to generate the calendar (defaults to current year).
     * @param month The month for which to generate the calendar (defaults to current month).
     * @param weekDayStyle The text style for formatting weekday names.
     * @param monthStyle The text style for formatting month names.
     * @param locale The locale to use for formatting dates and strings within the calendar.
     * @param selected An object representing the currently selected days in the calendar.
     * @return An `ICalendarViewState` object containing data for the calendar UI.
     */
    fun generateCalendarViewState(
        year: Int = LocalDate.now().year,
        month: Month = LocalDate.now().month,
        weekDayStyle: TextStyle = TextStyle.NARROW,
        monthStyle: TextStyle = TextStyle.SHORT,
        locale: Locale = Locale.getDefault(),
        selected: Selected? = null
    ): ICalendarViewState
}
