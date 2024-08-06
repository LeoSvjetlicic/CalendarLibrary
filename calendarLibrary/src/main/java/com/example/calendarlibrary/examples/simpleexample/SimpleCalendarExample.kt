package com.example.calendarlibrary.examples.simpleexample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calendarlibrary.examples.simpleexample.components.SimpleDays
import com.example.calendarlibrary.examples.simpleexample.components.SimpleHeader
import com.example.calendarlibrary.examples.simpleexample.components.SimpleWeekDays
import com.example.calendarlibrary.ui.calendar.Calendar
import com.example.calendarlibrary.ui.calendarheader.CalendarHeaderAction

@Composable
fun SimpleCalendarExample(
    viewState: SimpleCalendarViewState,
    modifier: Modifier = Modifier,
    onHeaderAction: (CalendarHeaderAction) -> Unit,
    onDayClick: (Int) -> Unit
) {
    Calendar(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(Color(222, 222, 222))
            .padding(12.dp),
        viewState = viewState,
        onHeaderAction = onHeaderAction,
        header = {
            SimpleHeader(
                modifier = Modifier.fillMaxWidth(),
                viewState = viewState.headerViewState,
                onAction = onHeaderAction
            )
        },
        weekDays = {
            SimpleWeekDays(viewState = viewState.weekDaysViewState)
        },
        content = {
            SimpleDays(
                viewState = viewState.daysViewState,
                onClick = onDayClick
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(0.3.dp)
                    .background(Color.DarkGray)
            )
            Column(modifier = Modifier.padding(top = 12.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Today's date: ",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = viewState.today,
                        fontSize = 16.sp,
                    )
                }
            }
        }
    )
}
