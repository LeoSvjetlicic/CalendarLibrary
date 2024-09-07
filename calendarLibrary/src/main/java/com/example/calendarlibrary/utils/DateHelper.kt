package com.example.calendarlibrary.utils

import java.time.LocalDate
import java.time.temporal.ChronoUnit

object DateHelper {
    fun getMiddleDate(startDate: LocalDate?, endDate: LocalDate?): LocalDate? {
        if (startDate == null || endDate == null)
            return null
        val daysBetween = ChronoUnit.DAYS.between(startDate, endDate)
        val middleDate = startDate.plusDays(daysBetween / 2)
        return middleDate
    }
}
