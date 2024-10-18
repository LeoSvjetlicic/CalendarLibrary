package com.leosvjetlicic.calendarlibrary.examples.simpleexample.components

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.leosvjetlicic.calendarlibrary.ui.calendarweekdays.CalendarWeekDaysViewState

/**
 * This composable function renders the weekdays for a simple calendar.
 *
 * @param viewState The view state for the calendar weekdays.
 * @param modifier (Optional) A modifier to style the overall layout of the weekdays.
 * @param alignment (Optional) The vertical alignment of the weekdays within the container. Defaults to centered vertically.
 * @param arrangement (Optional) The horizontal arrangement of the weekdays. Defaults to spaced around.
 * @param textStyle (Optional) The text style to be applied to the weekday labels. Defaults to the default text style.
 */
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
            Spacer(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(2.dp)
                    .background(Color.Transparent)
            )
            viewState.daysOfWeek.forEachIndexed { index, it ->
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

