package com.example.calendarlibrary.ui.calendarday

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.calendarlibrary.ui.calendarday.singleday.ICalendarDay
import java.time.LocalDate

@Composable
fun CalendarDays(
    viewState: CalendarDaysViewState,
    modifier: Modifier = Modifier,
    onClick: (LocalDate) -> Unit = {},
    dayContent: @Composable (List<ICalendarDay>) -> Unit = {
        DefaultCalendarDaysRow(viewState = it, onClick = onClick)
    }
) {
    Column(modifier = modifier) {
        for (day in viewState.days) {
            dayContent(day)
        }
    }
}

@Composable
internal fun DefaultCalendarDaysRow(
    viewState: List<ICalendarDay>,
    modifier: Modifier = Modifier,
    onClick: (LocalDate) -> Unit
) {
    CalendarDaysRow(
        viewState = viewState,
        modifier = modifier,
        onClick = onClick
    )
}
