package com.example.calendarlibrary.examples.simpleexample.components

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.calendarlibrary.ui.calendarday.singleday.CalendarDay
import com.example.calendarlibrary.ui.calendarday.singleday.ICalendarDay
import java.time.LocalDate

/**
 * This composable function renders a single day within a row of days.
 *
 * @param day The day to be rendered.
 * @param modifier (Optional) A modifier to style the overall layout of the day.
 * @param onClick (Optional) A callback function to handle clicks on the day.
 * @param content (Optional) A lambda that defines the content to be displayed within the day. Defaults to rendering a `SimpleDayContent` composable.
 */
@Composable
fun RowScope.SimpleDay(
    day: ICalendarDay,
    modifier: Modifier = Modifier,
    onClick: (LocalDate) -> Unit,
    content: @Composable BoxScope.() -> Unit = {
        SimpleDayContent(day = day, onClick = onClick)
    }
) {
    CalendarDay(
        modifier = modifier.weight(1f),
        viewState = day,
        content = {
            content()
        }
    )
}
