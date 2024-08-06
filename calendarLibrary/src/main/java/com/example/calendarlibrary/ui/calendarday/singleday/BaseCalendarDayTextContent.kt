package com.example.calendarlibrary.ui.calendarday.singleday

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp


@Composable
fun BoxScope.BaseCalendarDayTextContent(
    viewState: ICalendarDay,
    modifier: Modifier = Modifier,
    selectedTextColor: Color = White,
    unselectedTextColor: Color = White,
    notCurrentMonthTextColor: Color = Transparent,
    textPadding: Dp = 6.dp,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    width: Dp = 0.dp
) {
    Text(
        modifier = modifier
            .widthIn(min = width)
            .padding(textPadding)
            .align(
                alignment = Alignment.Center
            ),
        textAlign = TextAlign.Center,
        text = viewState.value.toString(),
        color = if (viewState.currentMonth) {
            if (viewState.isSelected) {
                selectedTextColor
            } else {
                unselectedTextColor
            }
        } else {
            notCurrentMonthTextColor
        },
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontFamily = fontFamily,
        fontWeight = fontWeight
    )
}
