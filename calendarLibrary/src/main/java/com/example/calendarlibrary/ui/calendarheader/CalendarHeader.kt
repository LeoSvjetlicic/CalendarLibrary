package com.example.calendarlibrary.ui.calendarheader

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CalendarHeader(
    viewState: CalendarHeaderViewState,
    modifier: Modifier = Modifier,
    onAction: (CalendarHeaderAction) -> Unit,
    content: @Composable () -> Unit = {
        DefaultCalendarHeader(viewState = viewState, modifier = modifier, onAction = onAction)
    },
) {
    content()
}

@Composable
internal fun DefaultCalendarHeader(
    viewState: CalendarHeaderViewState,
    modifier: Modifier = Modifier,
    onAction: (CalendarHeaderAction) -> Unit,
) {
    BaseCalendarHeader(
        viewState = viewState,
        modifier = modifier.padding(horizontal = 10.dp),
        onAction = onAction
    )
}
