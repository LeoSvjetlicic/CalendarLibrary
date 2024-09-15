package com.example.calendarlibrary.utils

import java.time.LocalDate
import java.time.temporal.ChronoUnit

/**
 *  A helper object to provide date-related utility functions
 */
object DateHelper {
    /**
     * This function calculates the middle date between two LocalDate values.
     *
     * @param startDate The start date of the range.
     * @param endDate The end date of the range.
     * @return The LocalDate representing the middle date of the range.
     *         Returns null if either startDate or endDate is null.
     */
    fun getMiddleDate(startDate: LocalDate, endDate: LocalDate): LocalDate {
        val daysBetween = ChronoUnit.DAYS.between(startDate, endDate)
        val middleDate = startDate.plusDays(daysBetween / 2)
        return middleDate
    }
}
