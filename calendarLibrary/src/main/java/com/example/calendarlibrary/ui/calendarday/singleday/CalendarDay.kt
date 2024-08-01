package com.example.calendarlibrary.ui.calendarday.singleday

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CalendarDay(
    viewState: CalendarDayViewState,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {
        DefaultCalendarDay(viewState = viewState, onClick = onClick, modifier = modifier)
    },
) {
    content()
}

@Composable
internal fun DefaultCalendarDay(
    viewState: CalendarDayViewState,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit
) {
    BaseCalendarDay(viewState = viewState, modifier = modifier, onClick = onClick)
}
