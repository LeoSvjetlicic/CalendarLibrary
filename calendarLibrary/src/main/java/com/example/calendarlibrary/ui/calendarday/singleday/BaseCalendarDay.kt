package com.example.calendarlibrary.ui.calendarday.singleday

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun BaseCalendarDay(
    viewState: CalendarDayViewState,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit = {
        DefaultCalendarDayContent(
            modifier = Modifier.align(Alignment.Center),
            viewState = viewState,
            onClick = onClick
        )
    },
    helperContent: @Composable BoxScope.() -> Unit = {}
) {
    Box(
        modifier = modifier
    ) {
        content()
        helperContent()
    }
}

@Composable
internal fun DefaultCalendarDayContent(
    viewState: CalendarDayViewState,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit
) {
    BaseCalendarDayContent(
        modifier = modifier,
        viewState = viewState,
        onClick = onClick
    )
}
