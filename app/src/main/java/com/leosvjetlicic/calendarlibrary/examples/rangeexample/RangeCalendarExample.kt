package com.leosvjetlicic.calendarlibrary.examples.rangeexample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.leosvjetlicic.calendarlibrary.examples.rangeexample.components.RangeCalendarDays
import com.leosvjetlicic.calendarlibrary.ui.calendar.Calendar
import com.leosvjetlicic.calendarlibrary.ui.calendar.ICalendarViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.CalendarHeaderAction
import java.time.LocalDate

/**
 * This composable function displays a range calendar example.
 *
 * @param viewState The view state for the calendar.
 * @param modifier A modifier to style the overall calendar layout.
 * @param onHeaderAction A callback function to handle header actions.
 * @param onDayClick A callback function to handle day clicks.
 */
@Composable
fun RangeCalendarExample(
    viewState: ICalendarViewState,
    modifier: Modifier = Modifier,
    onHeaderAction: (CalendarHeaderAction) -> Unit,
    onDayClick: (LocalDate) -> Unit
) {
    Calendar(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(Color(222, 222, 222))
            .padding(12.dp),
        viewState = viewState,
        onHeaderAction = onHeaderAction,
        content = {
            RangeCalendarDays(viewState = viewState.daysViewState, onClick = onDayClick)
        }
    )
}
