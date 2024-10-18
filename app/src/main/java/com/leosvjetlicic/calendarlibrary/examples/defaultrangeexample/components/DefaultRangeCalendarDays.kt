package com.leosvjetlicic.calendarlibrary.examples.defaultrangeexample.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.leosvjetlicic.calendarlibrary.ui.calendarday.CalendarDays
import com.leosvjetlicic.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarday.singleday.ICalendarDay
import java.time.LocalDate

@Composable
fun DefaultRangeCalendarDays(
    viewState: CalendarDaysViewState,
    modifier: Modifier = Modifier,
    onClick: (LocalDate) -> Unit = {},
    content: @Composable RowScope.(ICalendarDay) -> Unit = { day ->
        DefaultRangeCalendarDay(
            day = day, onClick = onClick
        )
    }
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
                content(day)
            }
        }
    }
}
