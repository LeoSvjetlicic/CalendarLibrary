package com.example.calendarlibrary.ui.calendarweekdays

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BaseCalendarWeekDays(
    viewState: CalendarWeekDaysViewState,
    modifier: Modifier = Modifier,
    alignment: Alignment.Vertical = Alignment.CenterVertically,
    arrangement: Arrangement.Horizontal = Arrangement.SpaceEvenly,
    spacerHeight: Dp = 12.dp,
    spacerWidth: Dp = 2.dp,
    spacerColor: Color = Color.LightGray,
    textStyle: TextStyle = TextStyle.Default,
) {
    Row(
        modifier = modifier,
        verticalAlignment = alignment,
        horizontalArrangement = arrangement
    ) {
        viewState.daysOfWeek.forEachIndexed { i, value ->
            Text(
                text = value,
                style = textStyle,
                textAlign = TextAlign.Center
            )
            if (i != viewState.daysOfWeek.size - 1) {
                Spacer(
                    modifier = Modifier
                        .height(spacerHeight)
                        .width(spacerWidth)
                        .clip(
                            RoundedCornerShape(8.dp)
                        )
                        .background(spacerColor)
                )
            }
        }
    }
}
