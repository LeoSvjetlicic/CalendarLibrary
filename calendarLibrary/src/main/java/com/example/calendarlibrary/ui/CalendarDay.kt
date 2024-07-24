package com.example.calendarlibrary.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.calendarlibrary.data.CalendarDayViewState
import com.example.calendarlibrary.ui.calendarday.BaseCalendarDay

@Composable
fun CalendarDay(
    viewState: CalendarDayViewState,
    onClick: () -> Unit,
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
    onClick: () -> Unit
) {
    BaseCalendarDay(viewState = viewState, modifier = modifier, onClick = onClick)
}
