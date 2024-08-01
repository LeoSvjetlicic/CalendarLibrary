package com.example.calendarlibrary.ui.calendarweekdays

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

@Composable
fun BaseCalendarWeekDays(
    viewState: CalendarWeekDaysViewState,
    modifier: Modifier = Modifier,
    alignment: Alignment.Vertical = Alignment.CenterVertically,
    arrangement: Arrangement.Horizontal = Arrangement.SpaceAround,
    textStyle: TextStyle = TextStyle.Default,
) {
    Row(
        modifier = modifier,
        verticalAlignment = alignment,
        horizontalArrangement = arrangement
    ) {
        viewState.daysOfWeek.forEach {
            Text(
                modifier = Modifier.weight(1f),
                text = it,
                style = textStyle,
                textAlign = TextAlign.Center
            )
        }
    }
}
