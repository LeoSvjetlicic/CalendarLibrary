package com.example.calendarlibrary.ui.calendarweekdays

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
    BaseCalendarWeekDays(viewState = viewState, modifier = modifier)
}
