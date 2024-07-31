package com.example.calendarlibrary.ui.calendarday

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BaseCalendarDay(
    viewState: CalendarDayViewState,
    onClick: () -> Unit,
    content: @Composable BoxScope.() -> Unit = {
        DefaultCalendarDayTextContent(
            viewState = viewState,
            onClick = onClick
        )
    },
    helperContent: @Composable BoxScope.() -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
    ) {
        content()
        helperContent()
    }
}

@Composable
internal fun DefaultCalendarDayTextContent(
    viewState: CalendarDayViewState,
    onClick: () -> Unit
) {
    BaseCalendarDayContent(
        viewState = viewState,
        onClick = onClick
    )
}
