package com.example.calendarlibrary.ui.calendarday

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.calendarlibrary.ui.calendarday.singleday.CalendarDay
import com.example.calendarlibrary.ui.calendarday.singleday.CalendarDayViewState

@Composable
fun CalendarDaysRow(
    viewState: List<CalendarDayViewState>,
    modifier: Modifier = Modifier,
    alignment: Alignment.Vertical = Alignment.CenterVertically,
    arrangement: Arrangement.Horizontal = Arrangement.SpaceEvenly,
    onClick: (Int) -> Unit,
    day: @Composable RowScope.(CalendarDayViewState) -> Unit = {
        DefaultSingleCalendarDay(
            modifier = Modifier.weight(1f),
            viewState = it,
            onClick = onClick
        )
    }
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = alignment,
        horizontalArrangement = arrangement
    ) {
        viewState.forEach {
            day(it)
        }
    }
}

@Composable
fun DefaultSingleCalendarDay(
    viewState: CalendarDayViewState,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit
) {
    CalendarDay(viewState = viewState, modifier = modifier, onClick = onClick)
}
