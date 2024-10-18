package com.leosvjetlicic.calendarlibrary.examples.rangeexample.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.leosvjetlicic.calendarlibrary.examples.rangeexample.RangeCalendarDayViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarday.singleday.BaseCalendarDayContent
import com.leosvjetlicic.calendarlibrary.ui.calendarday.singleday.BaseCalendarDayTextContent
import com.leosvjetlicic.calendarlibrary.ui.colors.DarkGreen
import com.leosvjetlicic.calendarlibrary.ui.colors.LightGreen
import java.time.LocalDate

/**
 * This composable function renders the content for a single day within a range calendar.
 *
 * This function is intended to be used within a `BoxScope`.
 *
 * @param day The `RangeCalendarDay` object representing the day data.
 * @param modifier (Optional) A modifier to style the overall layout of the day content.
 * @param onClick A callback function to handle clicks on the day.
 */
@Composable
fun BoxScope.RangeCalendarDayContent(
    day: RangeCalendarDayViewState,
    modifier: Modifier = Modifier,
    onClick: (LocalDate) -> Unit
) {
    BaseCalendarDayContent(
        onClick = onClick,
        modifier = modifier
            .then(
                if (day.isSelected && day.isCurrentMonth) {
                    Modifier.border(
                        width = 4.dp,
                        color = LightGreen,
                        shape = RoundedCornerShape(0.dp)
                    )
                } else {
                    Modifier
                }
            )
            .align(Alignment.Center),
        viewState = day,
        shape = RoundedCornerShape(0.dp),
        selectedBackgroundColor = Color.Transparent,
        content = {
            BaseCalendarDayTextContent(
                viewState = day,
                selectedTextColor = Color.Black
            )
        },
        indicator = {
            Spacer(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .width(15.dp)
                    .height(2.5.dp)
                    .background(DarkGreen)
            )
        }
    )
}
