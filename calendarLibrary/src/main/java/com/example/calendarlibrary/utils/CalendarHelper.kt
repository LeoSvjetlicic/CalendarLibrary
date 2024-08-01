package com.example.calendarlibrary.utils

import com.example.calendarlibrary.ui.calendar.CalendarViewState
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.temporal.TemporalAdjusters

class CalendarHelper() {
    enum class DAYS(val nameEng: String) {
        MONDAY("Mon"),
        TUESDAY("Tue"),
        WEDNESDAY("Wed"),
        THURSDAY("Thu"),
        FRIDAY("Fri"),
        SATURDAY("Sat"),
        SUNDAY("Sun")
    }

    fun getDaysOfWeekList(): List<String> {
        return DAYS.entries.map {
            it.nameEng[0].toString()
        }
    }

    fun generateCalendar(
        year: Int = LocalDate.now().year,
        month: Month = LocalDate.now().month,
        selectedDay: String = ""
    ) {
        val currentDay = LocalDate.now()
        val startOfMonth = LocalDate.of(year, month.value, 1)
        val endOfMonth = startOfMonth.with(TemporalAdjusters.lastDayOfMonth())

        val startOfFirstWeek = startOfMonth.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
        val endOfLastWeek = endOfMonth.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY))

        val weeks = mutableListOf<List<LocalDate>>()
        var currentDate = startOfFirstWeek

        while (currentDate <= endOfLastWeek) {
            val datesOfWeek = mutableListOf<LocalDate>()

            repeat(7) {
                datesOfWeek.add(currentDate)
                currentDate = currentDate.plusDays(1)
            }

            weeks.add(datesOfWeek)
        }
        val selectedElement = if (selectedDay.isNotEmpty()) {
            selectedDay.replace(",", "").split(" ")
        } else {
            emptyList()
        }
//        TODO
//        return CalendarViewState(
//            month = month.name,
//            year = year,
//            daysOfWeek = getDaysOfWeekList(),
//            dates = weeks.map { days ->
//                days.map { day ->
//                    CalendarDayViewState(
//                        value = day.dayOfMonth,
//                        isSelected = if (selectedDay.isNotEmpty()) {
//                            selectedElement[1] == day.dayOfMonth.toString() && selectedElement[0].equals(
//                                day.month.toString().substring(0, 3),
//                                true
//                            ) &&
//                                    selectedElement[2] == day.year.toString()
//                        } else {
//                            false
//                        },
//                        isToday = day == currentDay,
//                        currentMonth = day.monthValue == month.value && day.year == year
//                    )
//                }
//            }
//        )
    }
}
