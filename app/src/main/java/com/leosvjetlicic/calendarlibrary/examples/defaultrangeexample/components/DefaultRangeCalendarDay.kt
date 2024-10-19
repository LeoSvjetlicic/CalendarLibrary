package com.leosvjetlicic.calendarlibrary.examples.defaultrangeexample.components

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import com.leosvjetlicic.calendarlibrary.examples.defaultrangeexample.DefaultRangeCalendarDayViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarday.singleday.BaseCalendarDayContent
import com.leosvjetlicic.calendarlibrary.ui.calendarday.singleday.CalendarDay
import com.leosvjetlicic.calendarlibrary.ui.calendarday.singleday.ICalendarDay
import com.leosvjetlicic.calendarlibrary.ui.colors.LightPurple
import java.time.LocalDate

@Composable
fun RowScope.DefaultRangeCalendarDay(
    day: ICalendarDay,
    modifier: Modifier = Modifier,
    onClick: (LocalDate) -> Unit,
    content: @Composable BoxScope.() -> Unit = {
        BaseCalendarDayContent(
            modifier = Modifier.align(Alignment.Center),
            viewState = day as DefaultRangeCalendarDayViewState,
            onClick = onClick
        )
    }
) {
    CalendarDay(
        modifier = modifier
            .weight(1f)
            .then(
                if (day is DefaultRangeCalendarDayViewState && day.isInRange && day.isCurrentMonth && day.isSelected) {
                    Modifier.drawBehind {
                        drawRect(
                            color = LightPurple.copy(0.5f),
                            topLeft = if (day.isFirstDayInRange) {
                                Offset(
                                    center.x,
                                    10f
                                )
                            } else {
                                Offset(
                                    0f,
                                    10f
                                )
                            },
                            size = Size(
                                (size.width / 2),
                                size.height - 20
                            )
                        )
                    }
                } else
                    if (day is DefaultRangeCalendarDayViewState && day.isInRange && day.isCurrentMonth) {
                        Modifier.drawBehind {
                            drawRect(
                                color = LightPurple.copy(0.5f),
                                topLeft =
                                Offset(
                                    0f,
                                    10f
                                ),
                                size = Size(
                                    size.width,
                                    size.height - 20
                                )
                            )
                        }
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


