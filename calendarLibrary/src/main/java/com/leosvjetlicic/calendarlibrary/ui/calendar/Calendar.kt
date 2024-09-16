package com.leosvjetlicic.calendarlibrary.ui.calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.leosvjetlicic.calendarlibrary.ui.calendarday.CalendarDays
import com.leosvjetlicic.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.CalendarHeader
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.CalendarHeaderAction
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.CalendarHeaderViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarweekdays.CalendarWeekDays
import com.leosvjetlicic.calendarlibrary.ui.calendarweekdays.CalendarWeekDaysViewState
import java.time.LocalDate

/**
 * Composable function that renders a calendar view based on the provided view state and customization options.
 *
 * This function constructs a calendar UI by assembling its header, week days, and days sections using
 * the specified view state. It allows for customization of the header, week days, and days sections,
 * and handles interactions such as header actions and day clicks.
 *
 * @param viewState The state object that provides the data needed to render the calendar. It should
 *                  implement the [ICalendarViewState] interface and include information for the header,
 *                  week days, and days.
 * @param modifier A [Modifier] to apply customization such as padding, size, or other layout adjustments
 *                 to the entire calendar.
 * @param onHeaderAction A lambda function to handle actions triggered by interacting with the calendar's
 *                       header. This handles clicks on navigation buttons in the header.
 * @param onDayClick A lambda function that is triggered when a day is clicked. It receives a [LocalDate]
 *                    representing the clicked day. The default is an empty lambda, meaning no action occurs
 *                    if not explicitly provided.
 * @param header A composable function to render the calendar header. It defaults to [DefaultHeader], which
 *                takes the header view state and action handler as parameters.
 * @param weekDays A composable function to render the week days. It defaults to [DefaultWeekDays], which
 *                  takes the week days view state as a parameter.
 * @param content A composable function to render the days of the calendar. It defaults to [DefaultDays],
 *                which takes the days view state and day click handler as parameters.
 */
@Composable
fun Calendar(
    viewState: ICalendarViewState,
    modifier: Modifier = Modifier,
    onHeaderAction: (CalendarHeaderAction) -> Unit,
    onDayClick: (LocalDate) -> Unit = {},
    header: @Composable () -> Unit = {
        DefaultHeader(
            viewState = viewState.headerViewState,
            onAction = onHeaderAction
        )
    },
    weekDays: @Composable () -> Unit = {
        DefaultWeekDays(viewState = viewState.weekDaysViewState)
    },
    content: @Composable () -> Unit = {
        DefaultDays(viewState.daysViewState, onClick = onDayClick)
    }
) {
    Column(modifier = modifier) {
        header()
        weekDays()
        content()
    }
}

@Composable
internal fun DefaultHeader(
    viewState: CalendarHeaderViewState,
    onAction: (CalendarHeaderAction) -> Unit
) {
    CalendarHeader(modifier = Modifier.fillMaxWidth(), viewState = viewState, onAction = onAction)
}

@Composable
internal fun DefaultWeekDays(viewState: CalendarWeekDaysViewState) {
    CalendarWeekDays(modifier = Modifier.fillMaxWidth(), viewState = viewState)
}

@Composable
internal fun DefaultDays(viewState: CalendarDaysViewState, onClick: (LocalDate) -> Unit) {
    CalendarDays(modifier = Modifier.fillMaxWidth(), viewState = viewState, onClick = onClick)
}
