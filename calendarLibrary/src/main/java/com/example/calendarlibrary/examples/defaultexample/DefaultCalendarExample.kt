package com.example.calendarlibrary.examples.defaultexample

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.calendarlibrary.ui.calendar.Calendar
import com.example.calendarlibrary.ui.calendar.ICalendarViewState
import com.example.calendarlibrary.ui.calendarheader.CalendarHeaderAction

@Composable
fun DefaultCalendarExample(
    viewState: ICalendarViewState,
    modifier: Modifier = Modifier,
    onHeaderAction: (CalendarHeaderAction) -> Unit,
    onDayClick: (Int) -> Unit
) {
    Calendar(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .border(width = 0.5.dp, shape = RoundedCornerShape(12.dp), color = Color.Black)
            .padding(8.dp),
        viewState = viewState,
        onHeaderAction = onHeaderAction,
        onDayClick = onDayClick
    )
}
