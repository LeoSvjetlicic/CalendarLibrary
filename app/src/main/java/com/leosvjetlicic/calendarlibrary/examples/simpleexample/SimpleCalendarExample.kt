package com.leosvjetlicic.calendarlibrary.examples.simpleexample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.leosvjetlicic.calendarlibrary.examples.simpleexample.components.SimpleDays
import com.leosvjetlicic.calendarlibrary.examples.simpleexample.components.SimpleExtraContent
import com.leosvjetlicic.calendarlibrary.examples.simpleexample.components.SimpleHeader
import com.leosvjetlicic.calendarlibrary.examples.simpleexample.components.SimpleWeekDays
import com.leosvjetlicic.calendarlibrary.ui.calendar.Calendar
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.CalendarHeaderAction
import java.time.LocalDate

/**
 * This composable function displays a simple calendar example.
 *
 * @param viewState The view state for the simple calendar.
 * @param modifier (Optional) A modifier to style the overall calendar layout.
 * @param onHeaderAction A callback function to handle header actions.
 * @param onDayClick A callback function to handle day clicks.
 */
@Composable
fun SimpleCalendarExample(
    viewState: SimpleCalendarViewState,
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
        header = {
            SimpleHeader(
                modifier = Modifier.fillMaxWidth(),
                viewState = viewState.headerViewState,
                onAction = onHeaderAction
            )
        },
        weekDays = {
            SimpleWeekDays(viewState = viewState.weekDaysViewState)
        },
        content = {
            SimpleDays(
                viewState = viewState.daysViewState,
                onClick = onDayClick
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(0.3.dp)
                    .background(Color.DarkGray)
            )
            SimpleExtraContent(
                today = viewState.today,
                modifier = Modifier.padding(top = 12.dp)
            )
        }
    )
}
