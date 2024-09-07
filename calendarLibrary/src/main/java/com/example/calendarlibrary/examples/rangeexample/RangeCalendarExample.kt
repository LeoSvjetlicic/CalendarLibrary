package com.example.calendarlibrary.examples.rangeexample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.calendarlibrary.examples.rangeexample.components.RangeCalendarDays
import com.example.calendarlibrary.ui.calendar.Calendar
import com.example.calendarlibrary.ui.calendar.ICalendarViewState
import com.example.calendarlibrary.ui.calendarheader.CalendarHeaderAction
import java.time.LocalDate

@Composable
fun RangeCalendarExample(
    viewState: ICalendarViewState,
    modifier: Modifier = Modifier,
    onHeaderAction: (CalendarHeaderAction) -> Unit,
    onDayClick: (LocalDate) -> Unit
) {
    Calendar(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(Color(222, 222, 222))
            .padding(12.dp),
        viewState = viewState,
        onHeaderAction = onHeaderAction,
        content = {
            RangeCalendarDays(viewState = viewState.daysViewState, onClick = onDayClick)
        }
    )
}
