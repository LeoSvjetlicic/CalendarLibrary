package com.leosvjetlicic.library.exampleswithviewmodel.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.leosvjetlicic.calendarlibrary.ui.calendar.ICalendarViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.leosvjetlicic.calendarlibrary.utils.DateHelper.getMiddleDate
import com.leosvjetlicic.calendarlibrary.utils.Selected
import com.leosvjetlicic.calendarlibrary.viewmodel.BaseViewModel
import com.leosvjetlicic.library.examples.rangeexample.RangeCalendarDay
import com.leosvjetlicic.library.exampleutils.rangehelper.RangeCalendarHelper
import java.time.LocalDate

/**
 * View model class specifically designed for handling a calendar UI with
 * selectable date ranges.
 *
 * This class inherits from `BaseViewModel` and overrides the `onDayClick`
 * function to handle user selections in the context of a date range. It updates
 * the selected start and end dates based on user interaction and keeps track of
 * the "in range" state for individual days within the calendar view state.
 * For parameter details @see [BaseViewModel]
 */
class RangeViewModel(
    helper: RangeCalendarHelper,
    selected: Selected = Selected.DayRange(null, null),
    copyViewState: (ICalendarViewState, CalendarDaysViewState, Selected) -> ICalendarViewState
) : BaseViewModel(helper, selected, copyViewState) {
    /**
     * Handles user clicks on individual calendar days, updating the selected
     * date range and visual state accordingly.
     *
     * This function considers the current selection state (no selection,
     * single day selected, or range selected) and updates the start and
     * end dates of the selected range based on the clicked day. It also
     * recalculates the "in range" state for each day within the calendar view
     * state. Finally, it triggers a view state update using the provided
     * `copyViewState` function.
     *
     * @param clickedDay The LocalDate object representing the clicked day.
     */
    override fun onDayClick(clickedDay: LocalDate) {
        var newStartDate =
            (selected as Selected.DayRange).startDay
        var newEndDate =
            (selected as Selected.DayRange).endDay
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
                    val middle = if (newStartDate != null && newEndDate != null) {
                        getMiddleDate(newStartDate, newEndDate)
                    } else {
                        null
                    }
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
        selected = (selected as Selected.DayRange).copy(
            startDay = newStartDate,
            endDay = newEndDate
        )
        viewState.value = copyViewState(
            viewState.value,
            newDaysViewState,
            selected
        )
    }
}

@Suppress("UNCHECKED_CAST")
class RangeViewModelFactory(
    val helper: RangeCalendarHelper,
    val selected: Selected,
    val onCopy: (ICalendarViewState, CalendarDaysViewState, Selected) -> ICalendarViewState
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RangeViewModel(
            helper = helper,
            selected = selected,
            copyViewState = onCopy
        ) as T
    }
}
