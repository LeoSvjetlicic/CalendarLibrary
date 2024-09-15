package com.example.calendarlibrary.utils

import java.time.LocalDate

/**
 * Represents different ways a day or range of days can be selected.
 */
sealed class Selected {
    /**
     * Represents a single selected day.
     *
     * @param day The selected day, or null if no day is selected.
     */
    data class SingleDay(val day: LocalDate?) : Selected()

    /**
     * Represents a range of selected days.
     *
     * @param startDay The start day of the range, or null if no start day is selected.
     * @param endDay The end day of the range, or null if no end day is selected.
     */
    data class DayRange(val startDay: LocalDate?, val endDay: LocalDate?) : Selected()
}
