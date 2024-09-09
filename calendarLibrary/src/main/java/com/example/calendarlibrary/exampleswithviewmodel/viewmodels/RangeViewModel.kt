package com.example.calendarlibrary.exampleswithviewmodel.viewmodels

import com.example.calendarlibrary.examples.rangeexample.RangeCalendarDay
import com.example.calendarlibrary.ui.calendar.ICalendarViewState
import com.example.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.example.calendarlibrary.utils.DateHelper.getMiddleDate
import com.example.calendarlibrary.utils.SelectedDays
import com.example.calendarlibrary.utils.rangehelper.RangeCalendarHelper
import java.time.LocalDate

class RangeViewModel(
    helper: RangeCalendarHelper,
    selectedDays: SelectedDays = SelectedDays.DayRange(null, null),
    copyViewState: (ICalendarViewState, CalendarDaysViewState, SelectedDays) -> ICalendarViewState
) : BaseViewModel(helper, selectedDays, copyViewState) {

    override fun onDayClick(clickedDay: LocalDate) {
        var newStartDate =
            (selectedDays as SelectedDays.DayRange).startDay
        var newEndDate =
            (selectedDays as SelectedDays.DayRange).endDay
        val selectedDaysSum =
            if (newEndDate != null && newStartDate != null) 2 else {
                if (newEndDate != null || newStartDate != null) 1 else 0
            }
        when (selectedDaysSum) {
            0 -> newStartDate = clickedDay
            1 -> {
                if (clickedDay == newStartDate) {
                    newStartDate = null
                } else if (newStartDate != null && clickedDay < newStartDate) {
                    newEndDate =
                        newStartDate
                    newStartDate = clickedDay
                } else if (clickedDay == newEndDate) {
                    newEndDate = null
                } else if (newEndDate != null && clickedDay > newEndDate) {
                    newStartDate =
                        newEndDate
                    newEndDate = clickedDay
                } else {
                    if (newStartDate == null) {
                        newStartDate = clickedDay
                    } else {
                        newEndDate = clickedDay
                    }
                }
            }

            2 -> {
                if (clickedDay != newStartDate && clickedDay != newEndDate) {
                    val middle = getMiddleDate(newStartDate, newEndDate)
                    if (clickedDay < middle) {
                        newStartDate = clickedDay
                    } else {
                        newEndDate = clickedDay
                    }
                } else {
                    if (newStartDate == clickedDay) {
                        newStartDate = null
                    } else if (newEndDate == clickedDay) {
                        newEndDate = null
                    }
                }
            }
        }

        val newDays = viewState.value.daysViewState.days.map { week ->
            week.map { d ->
                d as RangeCalendarDay
                when (d.value) {
                    newStartDate, newEndDate -> d.copy(
                        isSelected = true,
                        isInRange = false
                    )

                    else -> d.copy(
                        isSelected = false,
                        isInRange = newStartDate != null && newEndDate != null && d.value > newStartDate && d.value < newEndDate
                    )
                }
            }
        }
        val newDaysViewState = viewState.value.daysViewState.copy(
            days = newDays,
        )
        selectedDays = (selectedDays as SelectedDays.DayRange).copy(
            startDay = newStartDate,
            endDay = newEndDate
        )
        viewState.value = copyViewState(
            viewState.value,
            newDaysViewState,
            selectedDays
        )
    }

}
