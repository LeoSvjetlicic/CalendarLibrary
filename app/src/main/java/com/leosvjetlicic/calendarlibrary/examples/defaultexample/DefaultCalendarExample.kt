package com.leosvjetlicic.calendarlibrary.examples.defaultexample

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.leosvjetlicic.calendarlibrary.ui.calendar.Calendar
import com.leosvjetlicic.calendarlibrary.ui.calendar.ICalendarViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.CalendarHeaderAction
import java.time.LocalDate

/**
 * This composable function displays a default calendar example.
 *
 *  @param viewState An instance of `ICalendarViewState` holding the data for the calendar.
 *  @param modifier (Optional) A modifier to style the overall calendar layout.
 *  @param onHeaderAction A callback function to handle actions triggered from the calendar header.
 *  @param onDayClick A callback function to handle clicks on specific calendar days.
 */
@Composable
fun DefaultCalendarExample(
    viewState: ICalendarViewState,
    modifier: Modifier = Modifier,
    onHeaderAction: (CalendarHeaderAction) -> Unit,
    onDayClick: (LocalDate) -> Unit
) {
    Calendar(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .border(width = 0.5.dp, shape = RoundedCornerShape(12.dp), color = Color.Black)
            .padding(8.dp),
        viewState = viewState,
        onHeaderAction = onHeaderAction,
        onDayClick = onDayClick
    )
}
