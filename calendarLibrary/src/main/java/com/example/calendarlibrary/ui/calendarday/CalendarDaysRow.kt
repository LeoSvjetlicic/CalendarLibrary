package com.example.calendarlibrary.ui.calendarday

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.calendarlibrary.ui.calendarday.singleday.CalendarDay
import com.example.calendarlibrary.ui.calendarday.singleday.ICalendarDay
import java.time.LocalDate

@Composable
fun CalendarDaysRow(
    viewState: List<ICalendarDay>,
    modifier: Modifier = Modifier,
    alignment: Alignment.Vertical = Alignment.CenterVertically,
    arrangement: Arrangement.Horizontal = Arrangement.SpaceEvenly,
    onClick: (LocalDate) -> Unit = {},
    day: @Composable RowScope.(ICalendarDay) -> Unit = {
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
    viewState: ICalendarDay,
    modifier: Modifier = Modifier,
    onClick: (LocalDate) -> Unit
) {
    CalendarDay(viewState = viewState, modifier = modifier, onClick = onClick)
}