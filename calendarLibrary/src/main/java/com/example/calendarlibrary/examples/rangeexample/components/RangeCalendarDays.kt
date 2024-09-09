package com.example.calendarlibrary.examples.rangeexample.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.calendarlibrary.examples.rangeexample.RangeCalendarDay
import com.example.calendarlibrary.ui.calendarday.CalendarDays
import com.example.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.example.calendarlibrary.ui.calendarday.singleday.BaseCalendarDayContent
import com.example.calendarlibrary.ui.calendarday.singleday.BaseCalendarDayTextContent
import com.example.calendarlibrary.ui.calendarday.singleday.CalendarDay
import com.example.calendarlibrary.ui.colors.DarkGreen
import com.example.calendarlibrary.ui.colors.LightGreen
import java.time.LocalDate

@Composable
fun RangeCalendarDays(
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
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            weekDays.forEach { day ->
                Log.d("kuibuo",day.toString())
                CalendarDay(
                    modifier = Modifier
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
                        BaseCalendarDayContent(
                            onClick = onClick,
                            modifier = Modifier
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
                )
            }
        }
    }
}
