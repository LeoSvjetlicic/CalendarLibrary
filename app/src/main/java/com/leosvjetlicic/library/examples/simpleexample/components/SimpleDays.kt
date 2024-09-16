package com.leosvjetlicic.library.examples.simpleexample.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.leosvjetlicic.calendarlibrary.ui.calendarday.CalendarDays
import com.leosvjetlicic.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarday.singleday.ICalendarDay
import java.time.LocalDate

/**
 * This composable function renders a grid of days for a simple calendar.
 *
 * @param viewState The view state for the calendar days.
 * @param modifier (Optional) A modifier to style the overall layout of the days grid.
 * @param onClick (Optional) A callback function to handle clicks on calendar days. Defaults to an empty function.
 * @param content (Optional) A lambda that defines the content to be displayed for each day. Defaults to rendering a `SimpleDay` composable.
 */
@Composable
fun SimpleDays(
    viewState: CalendarDaysViewState,
    modifier: Modifier = Modifier,
    onClick: (LocalDate) -> Unit = {},
    content: @Composable RowScope.(ICalendarDay) -> Unit = { day ->
        SimpleDay(day = day, onClick = onClick)
    }
) {
    CalendarDays(
        viewState = viewState,
        modifier = modifier,
        onClick = onClick
    ) { weekDays ->
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(
                    if (weekDays.any { it.isSelected }) {
                        Color.Blue.copy(alpha = 0.4f)
                    } else {
                        Color.Transparent
                    }
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            weekDays.forEach { day ->
                content(day)
            }
        }
    }
}
