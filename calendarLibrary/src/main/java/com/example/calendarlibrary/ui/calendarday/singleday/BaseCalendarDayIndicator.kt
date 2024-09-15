package com.example.calendarlibrary.ui.calendarday.singleday

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.calendarlibrary.ui.colors.Purple

/**
 * Composable function that renders an indicator for a calendar day within a [BoxScope].
 *
 * This function displays a small visual indicator (e.g., a dot) at the bottom center of a calendar day cell.
 * The indicator can be customized in terms of color, size, and positioning using the provided parameters.
 *
 * @param modifier A [Modifier] to apply customizations such as size, alignment, or other layout adjustments
 *                 to the indicator. Changing this parameter allows for alterations in the indicator's visual
 *                 presentation and placement within the cell.
 * @param indicatorColor The color of the indicator. Defaults to [Purple]. Changing this parameter will modify
 *                       the color of the dot or shape used as the indicator, allowing it to match different themes
 *                       or highlight specific days.
 * @param indicatorSize The size of the indicator. Defaults to [4.5.dp]. Modifying this parameter changes the
 *                      diameter of the indicator, which can be useful for adjusting its prominence or fit within
 *                      the calendar cell.
 */
@Composable
fun BoxScope.BaseCalendarDayIndicator(
    modifier: Modifier = Modifier,
    indicatorColor: Color = Purple,
    indicatorSize: Dp = 4.5.dp,
) {
    Spacer(
        modifier = modifier
            .align(Alignment.BottomCenter)
            .size(indicatorSize)
            .clip(CircleShape)
            .background(indicatorColor)
    )
}
