package com.example.calendarlibrary.examples.simpleexample.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.calendarlibrary.ui.calendarweekdays.CalendarWeekDaysViewState

@Composable
fun SimpleWeekDays(
    viewState: CalendarWeekDaysViewState,
    modifier: Modifier = Modifier,
    alignment: Alignment.Vertical = Alignment.CenterVertically,
    arrangement: Arrangement.Horizontal = Arrangement.SpaceAround,
    textStyle: TextStyle = TextStyle.Default,
) {
    Column(modifier = modifier) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.3.dp)
                .background(Color.DarkGray)
        )
        Row(
            modifier = Modifier.padding(vertical = 6.dp),
            verticalAlignment = alignment,
            horizontalArrangement = arrangement
        ) {
            viewState.daysOfWeek.forEachIndexed { index, it ->
                Spacer(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(2.dp)
                        .background(Color.Transparent)
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = it,
                    style = textStyle,
                    textAlign = TextAlign.Center
                )
                Spacer(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(2.dp)
                        .background(
                            if (index != viewState.daysOfWeek.size - 1) {
                                Color.DarkGray
                            } else {
                                Color.Transparent
                            }
                        )
                )
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.3.dp)
                .background(Color.DarkGray)
        )
    }
}
