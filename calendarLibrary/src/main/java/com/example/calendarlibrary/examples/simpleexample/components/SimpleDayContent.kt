package com.example.calendarlibrary.examples.simpleexample.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.calendarlibrary.ui.calendarday.singleday.BaseCalendarDayContent
import com.example.calendarlibrary.ui.calendarday.singleday.BaseCalendarDayTextContent
import com.example.calendarlibrary.ui.calendarday.singleday.ICalendarDay
import com.example.calendarlibrary.ui.colors.DarkGreen
import java.time.LocalDate

/**
 * This composable function renders the content for a single day within the calendar.
 *
 * @param day The day to be displayed.
 * @param modifier (Optional) A modifier to style the overall layout of the day content.
 * @param onClick A callback function to handle clicks on the day.
 */
@Composable
fun BoxScope.SimpleDayContent(
    day: ICalendarDay,
    modifier: Modifier = Modifier,
    onClick: (LocalDate) -> Unit
) {
    BaseCalendarDayContent(
        onClick = onClick,
        modifier = modifier
            .clip(CircleShape)
            .then(
                if (day.isSelected) {
                    Modifier.border(
                        width = 4.dp,
                        color = Color.Blue,
                        shape = CircleShape
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
                notCurrentMonthTextColor = Color.Gray,
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
