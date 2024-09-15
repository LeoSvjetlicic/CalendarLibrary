package com.example.calendarlibrary.examples.rangeexample.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.calendarlibrary.examples.rangeexample.RangeCalendarDay
import com.example.calendarlibrary.ui.calendarday.singleday.CalendarDay
import com.example.calendarlibrary.ui.calendarday.singleday.ICalendarDay
import com.example.calendarlibrary.ui.colors.LightGreen
import java.time.LocalDate

/**
 * This composable function renders the UI for a single day within a range calendar.
 *
 * This function is intended to be used within a `RowScope`.
 *
 * @param day The `ICalendarDay` object representing the day data.
 * @param modifier (Optional) A modifier to style the overall layout of the day UI.
 * @param onClick A callback function to handle clicks on the day.
 * @param content (Optional) A lambda that defines the content to be displayed within the day. Defaults to rendering a `RangeCalendarDayContent`.
 */
@Composable
fun RowScope.RangeCalendarDayUI(
    day: ICalendarDay,
    modifier: Modifier = Modifier,
    onClick: (LocalDate) -> Unit,
    content: @Composable BoxScope.() -> Unit = {
        RangeCalendarDayContent(
            day = day as RangeCalendarDay,
            onClick = onClick
        )
    }
) {
    CalendarDay(
        modifier = modifier
            .weight(1f)
            .then(
                if (day is RangeCalendarDay && day.isInRange && day.isCurrentMonth) {
                    Modifier.background(
                        color = LightGreen.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(0.dp)
                    )
                } else {
                    Modifier
                }
            ),
        viewState = day,
        content = {
            content()
        }
    )
}
