package com.example.calendarlibrary.examples.simpleexample.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.calendarlibrary.ui.calendarday.CalendarDays
import com.example.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.example.calendarlibrary.ui.calendarday.singleday.BaseCalendarDayContent
import com.example.calendarlibrary.ui.calendarday.singleday.BaseCalendarDayTextContent
import com.example.calendarlibrary.ui.calendarday.singleday.CalendarDay
import com.example.calendarlibrary.ui.colors.DarkGreen
import java.time.LocalDate

@Composable
fun SimpleDays(
    viewState: CalendarDaysViewState,
    modifier: Modifier = Modifier,
    onClick: (LocalDate) -> Unit = {}
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
                CalendarDay(
                    modifier = Modifier.weight(1f),
                    viewState = day,
                    content = {
                        BaseCalendarDayContent(
                            onClick = onClick,
                            modifier = Modifier
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
                )
            }
        }
    }
}
