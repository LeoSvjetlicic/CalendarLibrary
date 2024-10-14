package com.leosvjetlicic.calendarlibrary.examples.defaultrangeexample.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import com.leosvjetlicic.calendarlibrary.examples.rangeexample.RangeCalendarDay
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
            viewState = day as RangeCalendarDay,
            onClick = onClick
        )
    }
) {
    CalendarDay(
        modifier = modifier
            .weight(1f)
            .then(
                if (day is RangeCalendarDay && day.isInRange && day.isCurrentMonth && day.isSelected) {
                    Modifier.drawBehind {
                        drawRect(
                            color = LightPurple.copy(0.5f),
                            topLeft = if (day.isFirstDayInRange) {
                                Offset(
                                    center.x,
                                    0f
                                )
                            } else {
                                Offset(
                                    0f,
                                    0f
                                )
                            },
                            size = androidx.compose.ui.geometry.Size(
                                (size.width / 2),
                                size.height
                            )
                        )
                    }
                } else
                    if (day is RangeCalendarDay && day.isInRange && day.isCurrentMonth) {
                        Modifier.background(
                            color = LightPurple.copy(alpha = 0.5f),
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


