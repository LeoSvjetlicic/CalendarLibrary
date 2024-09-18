package com.leosvjetlicic.calendarlibrary.viewmodel

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.leosvjetlicic.calendarlibrary.ui.calendar.ICalendarViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarday.singleday.CalendarDayViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.CalendarHeaderAction
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.ContentAction
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.FirstLeadingAction
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.FirstTrailingAction
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.SecondLeadingAction
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.SecondTrailingAction
import com.leosvjetlicic.calendarlibrary.utils.ICalendarHelper
import com.leosvjetlicic.calendarlibrary.utils.Selected
import java.time.LocalDate
import java.time.Month

/**
 * Base class for view models interacting with a calendar UI.
 *
 * This class provides common functionality for managing calendar state,
 * handling user interactions with days and the calendar header, and updating
 * the view state accordingly. Subclasses can extend this base class to
 * implement specific calendar UI behaviors.
 *
 * @param helper An implementation of the `ICalendarHelper` interface, used for
 *               generating calendar data.
 * @param selected The currently selected date information (defaults to empty SingleDay).
 * @param copyViewState A function to create a new `ICalendarViewState` object
 *                       based on the current state, updated day selection state,
 *                       and selected date.
 */
open class BaseViewModel(
    val helper: ICalendarHelper,
    protected var selected: Selected = Selected.SingleDay(null),
    val copyViewState: (ICalendarViewState, CalendarDaysViewState, Selected) -> ICalendarViewState
) : ViewModel() {

    /**
     * The current view state of the calendar UI.
     *
     * This observable state is updated based on user interactions and reflects the
     * current visual representation of the calendar.
     */
    val viewState = mutableStateOf(helper.generateCalendarViewState(selected = selected))

    /**
     * The internal state representing the current month.
     *
     * This mutable state variable is used to track the displayed month within the
     * calendar UI.
     */
    private val month = mutableStateOf(LocalDate.now().month)

    /**
     * The internal state representing the current year.
     *
     * This mutable integer state variable is used to track the displayed year
     * within the calendar UI.
     */
    private val year = mutableIntStateOf(LocalDate.now().year)

    /**
     * Handles user clicks on individual calendar days.
     *
     * This function updates the selected date information and the selection state
     * of individual days within the calendar view state based on the clicked day.
     * It then triggers a view state update using the provided `copyViewState`
     * function.
     *
     * @param clickedDay The LocalDate object representing the clicked day.
     */
    open fun onDayClick(clickedDay: LocalDate) {
        val newDays = viewState.value.daysViewState.days.map { week ->
            week.map { d ->
                d as CalendarDayViewState
                if (d.value == clickedDay && d.isSelected && d.isCurrentMonth) {
                    selected = (selected as Selected.SingleDay).copy(day = null)
                    d.copy(isSelected = false)
                } else {
                    if (d.value == clickedDay && d.isCurrentMonth) {
                        selected = (selected as Selected.SingleDay).copy(day = clickedDay)
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
        viewState.value = copyViewState(viewState.value, newDaysViewState, selected)
    }

    /**
     * Handles user interactions with the calendar header's action buttons.
     *
     * This function updates the displayed month and year based on the provided
     * `CalendarHeaderAction` and then triggers a view state update by calling
     * the helper's `generateCalendarViewState` function with the updated month
     * and year.
     *
     * @param action The type of action triggered by the user interaction.
     */
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
            selected = selected
        )
    }
}

@Suppress("UNCHECKED_CAST")
class BaseViewModelFactory(
    private val helper: ICalendarHelper,
    val selected: Selected,
    private val onCopy: (ICalendarViewState, CalendarDaysViewState, Selected) -> ICalendarViewState
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BaseViewModel(
            helper = helper,
            selected = selected,
            copyViewState = onCopy
        ) as T
    }
}
