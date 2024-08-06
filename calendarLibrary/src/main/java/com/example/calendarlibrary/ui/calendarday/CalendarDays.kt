package com.example.calendarlibrary.ui.calendarday

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.calendarlibrary.ui.calendarday.singleday.ICalendarDay

@Composable
fun CalendarDays(
    viewState: CalendarDaysViewState,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit = {},
    dayContent: @Composable (List<ICalendarDay>) -> Unit = {
        DefaultCalendarDaysRow(viewState = it, onClick = onClick)
    }
) {
    Column(modifier = modifier) {
        for (day in viewState.daysViewState) {
            dayContent(day)
        }
    }
}

@Composable
internal fun DefaultCalendarDaysRow(
    viewState: List<ICalendarDay>,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit
) {
    CalendarDaysRow(
        viewState = viewState,
        modifier = modifier,
        onClick = onClick
    )
}
