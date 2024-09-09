package com.example.calendarlibrary.exampleswithviewmodel.viewmodels

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.calendarlibrary.ui.calendar.ICalendarViewState
import com.example.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.example.calendarlibrary.ui.calendarday.singleday.CalendarDayViewState
import com.example.calendarlibrary.ui.calendarheader.CalendarHeaderAction
import com.example.calendarlibrary.ui.calendarheader.ContentAction
import com.example.calendarlibrary.ui.calendarheader.FirstLeadingAction
import com.example.calendarlibrary.ui.calendarheader.FirstTrailingAction
import com.example.calendarlibrary.ui.calendarheader.SecondLeadingAction
import com.example.calendarlibrary.ui.calendarheader.SecondTrailingAction
import com.example.calendarlibrary.utils.ICalendarHelper
import com.example.calendarlibrary.utils.SelectedDays
import java.time.LocalDate
import java.time.Month

open class BaseViewModel(
    private val helper: ICalendarHelper,
    protected var selectedDays: SelectedDays = SelectedDays.SingleDay(null),
    val copyViewState: (ICalendarViewState, CalendarDaysViewState, SelectedDays) -> ICalendarViewState
) : ViewModel() {
    val viewState = mutableStateOf(helper.generateCalendarViewState(selectedDays = selectedDays))
    private val month = mutableStateOf(LocalDate.now().month)
    private val year = mutableIntStateOf(LocalDate.now().year)

    open fun onDayClick(clickedDay: LocalDate) {
        val newDays = viewState.value.daysViewState.days.map { week ->
            week.map { d ->
                d as CalendarDayViewState
                if (d.isSelected) {
                    selectedDays = (selectedDays as SelectedDays.SingleDay).copy(day = null)
                    d.copy(isSelected = false)
                } else {
                    if (d.value == clickedDay && d.isCurrentMonth) {
                        selectedDays =
                            (selectedDays as SelectedDays.SingleDay).copy(day = clickedDay)
                        d.copy(isSelected = true)
                    } else {
                        d.copy(isSelected = false)
                    }
                }
            }
        }
        val newDaysViewState = viewState.value.daysViewState.copy(
            days = newDays,
        )
        viewState.value = copyViewState(viewState.value, newDaysViewState, selectedDays)
    }

    open fun onHeaderAction(action: CalendarHeaderAction) {
        when (action) {
            SecondLeadingAction -> {
                if (month.value.value == 1) {
                    month.value = Month.of(12)
                    year.intValue -= 1
                } else {
                    month.value = Month.of(month.value.value - 1)
                }
            }

            FirstTrailingAction -> {
                if (month.value.value == 12) {
                    month.value = Month.of(1)
                    year.intValue += 1
                } else {
                    month.value = Month.of(month.value.value + 1)
                }
            }

            FirstLeadingAction -> {
                year.intValue -= 1
            }

            SecondTrailingAction -> {
                year.intValue += 1
            }

            ContentAction -> {
                year.intValue = LocalDate.now().year
                month.value = LocalDate.now().month
            }
        }
        viewState.value = helper.generateCalendarViewState(
            year = year.intValue,
            month = month.value,
            selectedDays = selectedDays
        )
    }
}
