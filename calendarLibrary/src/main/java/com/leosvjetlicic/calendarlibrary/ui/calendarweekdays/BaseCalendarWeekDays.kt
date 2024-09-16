package com.leosvjetlicic.calendarlibrary.ui.calendarweekdays

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

/**
 * This internal composable function lays out the weekdays for the calendar.
 *
 * It takes the following arguments:
 *  @param viewState An instance of `CalendarWeekDaysViewState` holding the data for display.
 *  @param modifier (Optional) A modifier to style the overall layout.
 *  @param alignment (Optional) The vertical alignment of the weekdays. Defaults to CenterVertically.
 *         Changing it will affect the content position in the Row vertically (top, center, bottom)
 *  @param arrangement (Optional) The horizontal arrangement of the weekdays. Defaults to SpaceAround.
 *         Changing it will affect how the elements are positioned horizontally ()
 *  @param textStyle (Optional) The text style for the weekdays.
 *         Changing it will affect on the style of calendar day text
 */
@Composable
internal fun BaseCalendarWeekDays(
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
        viewState.daysOfWeek.forEach { day ->
            Text(
                modifier = Modifier.weight(1f),
                text = day,
                style = textStyle,
                textAlign = TextAlign.Center
            )
        }
    }
}
