package com.example.calendarlibrary.ui.calendarday.singleday

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import java.time.LocalDate

@Composable
fun CalendarDay(
    viewState: ICalendarDay,
    modifier: Modifier = Modifier,
    onClick: (LocalDate) -> Unit = {},
    content: @Composable BoxScope.(ICalendarDay) -> Unit = {
        DefaultCalendarDay(
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
        content(viewState)
        helperContent()
    }
}

@Composable
internal fun DefaultCalendarDay(
    viewState: ICalendarDay,
    modifier: Modifier = Modifier,
    onClick: (LocalDate) -> Unit
) {
    BaseCalendarDayContent(
        modifier = modifier,
        viewState = viewState,
        onClick = onClick
    )
}
