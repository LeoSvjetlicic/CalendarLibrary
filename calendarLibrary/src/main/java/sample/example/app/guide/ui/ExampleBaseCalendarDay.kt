package sample.example.app.guide.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sample.example.app.guide.data.CalendarDayViewState
import sample.example.app.guide.ui.base.CalendarDay

@Composable
fun ExampleBaseCalendarDay(
    viewState: CalendarDayViewState,
    modifier: Modifier = Modifier,
    indicatorColor: Color = Red,
    textColor: Color = Black,
    selectedBackgroundColor: Color = Cyan,
    defaultBackgroundColor: Color = Transparent,
    onClick: () -> Unit
) {
    CalendarDay(
        viewState = viewState,
        onClick = onClick,
        modifier = modifier
            .wrapContentSize()
            .clip(
                RoundedCornerShape(8.dp)
            )
            .then(
                if (viewState.isSelected) {
                    Modifier.background(selectedBackgroundColor)
                } else {
                    Modifier.background(defaultBackgroundColor)
                }
            )
            .then(
                if (viewState.currentMonth) {
                    Modifier
                        .clickable { onClick() }
                } else {
                    Modifier
                }
            )
            .padding(8.dp),
        content = { contentModifier ->
            Text(
                modifier = contentModifier
                    .padding(10.dp),
                textAlign = TextAlign.Center,
                text = viewState.value.toString(),
                color = if (viewState.currentMonth) {
                    textColor
                } else {
                    Gray
                }
            )
        },
        bottomElement = { bottomElementModifier ->
            if (viewState.isToday) {
                RedIndicator(modifier = bottomElementModifier, indicatorColor, isVertical = true)
            }
        },
        topElement = { topElementModifier ->
            if (viewState.isToday) {
                RedIndicator(modifier = topElementModifier, indicatorColor, isVertical = true)
            }
        },
        trailingElement = { trailingElementModifier ->
            if (viewState.isToday) {
                RedIndicator(modifier = trailingElementModifier, indicatorColor, isVertical = false)
            }
        },
        leadingElement = { leadingElementModifier ->
            if (viewState.isToday) {
                RedIndicator(modifier = leadingElementModifier, indicatorColor, isVertical = false)
            }
        },
    )
}

@Composable
private fun RedIndicator(modifier: Modifier, color: Color, isVertical: Boolean) {
    Spacer(
        modifier = modifier
            .clip(
                RoundedCornerShape(4.dp)
            )
            .then(
                if (isVertical) {
                    Modifier
                        .width(10.dp)
                        .height(3.dp)
                } else {
                    Modifier
                        .width(3.dp)
                        .height(10.dp)
                }
            )
            .background(color)
    )
}

@Preview
@Composable
private fun adfac() {
    ExampleBaseCalendarDay(viewState = CalendarDayViewState(1, true, true, true)){}
}

