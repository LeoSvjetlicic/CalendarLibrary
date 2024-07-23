package com.example.calendarlibrary.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.calendarlibrary.data.CalendarDayViewState

@Composable
fun ExampleNoBaseCalendarDay(
    viewState: CalendarDayViewState,
    modifier: Modifier = Modifier,
    indicatorColor: Color = Red,
    indicatorSize: Dp = 4.dp,
    textColor: Color = Black,
    selectedBackgroundColor: Color = Cyan,
    defaultBackgroundColor: Color = Transparent,
    onClick: () -> Unit
) {
    Box(modifier = modifier
        .clip(RoundedCornerShape(8.dp))
        .then(
            if (viewState.currentMonth) {
                if (viewState.isSelected) {
                    Modifier.background(selectedBackgroundColor)
                } else {
                    Modifier.background(
                        defaultBackgroundColor
                    )
                }
            } else {
                Modifier
            }
        )
        .padding(4.dp)
        .clickable { onClick() }) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = viewState.value.toString(),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(6.dp)
                    .padding(top = indicatorSize),
                color = if (viewState.currentMonth) {
                    textColor
                } else {
                    Color.Gray
                }
            )

            Spacer(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(indicatorSize)
                    .background(
                        if (viewState.isToday) {
                            indicatorColor
                        } else {
                            Transparent
                        }
                    )
            )
        }
    }
}

@Preview
@Composable
private fun adfac() {
    ExampleNoBaseCalendarDay(viewState = CalendarDayViewState(1, true, true, true)){}
}
