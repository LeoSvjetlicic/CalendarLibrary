package com.leosvjetlicic.calendarlibrary.ui.calendarweekdays

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

/**
 * This composable function displays the weekdays for a calendar.
 *
 * It takes the following arguments:
 *  @param viewState An instance of `CalendarWeekDaysViewState` holding the data for display.
 *  @param modifier (Optional) A modifier to style the composable.
 *  @param content (Optional) A lambda that defines the content to be displayed.
 *      By default, it uses `DefaultCalendarWeekDays` composable.
 */
@Composable
fun CalendarWeekDays(
    viewState: CalendarWeekDaysViewState,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {
        DefaultCalendarWeekDays(viewState = viewState, modifier = modifier)
    }
) {
    content()
}

@Composable
internal fun DefaultCalendarWeekDays(
    viewState: CalendarWeekDaysViewState,
    modifier: Modifier = Modifier
) {
    BaseCalendarWeekDays(
        viewState = viewState,
        modifier = modifier.padding(vertical = 6.dp),
        textStyle = TextStyle.Default.copy(color = Color.Black)
    )
}
