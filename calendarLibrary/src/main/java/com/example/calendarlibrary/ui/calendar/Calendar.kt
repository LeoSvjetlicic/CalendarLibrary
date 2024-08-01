package com.example.calendarlibrary.ui.calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.calendarlibrary.ui.calendarday.CalendarDays
import com.example.calendarlibrary.ui.calendarday.CalendarDaysViewState
import com.example.calendarlibrary.ui.calendarheader.CalendarHeader
import com.example.calendarlibrary.ui.calendarheader.CalendarHeaderAction
import com.example.calendarlibrary.ui.calendarheader.CalendarHeaderViewState
import com.example.calendarlibrary.ui.calendarweekdays.CalendarWeekDays
import com.example.calendarlibrary.ui.calendarweekdays.CalendarWeekDaysViewState

@Composable
fun Calendar(
    viewState: CalendarViewState,
    modifier: Modifier = Modifier,
    onHeaderAction: (CalendarHeaderAction) -> Unit,
    onDayClick: (Int) -> Unit,
    header: @Composable () -> Unit = {
        DefaultHeader(
            viewState = viewState.headerViewState,
            onAction = onHeaderAction
        )
    },
    weekDays: @Composable () -> Unit = {
        DefaultWeekDays(viewState = viewState.weekDaysViewState)
    },
    days: @Composable () -> Unit = {
        DefaultDays(viewState.daysViewState, onClick = onDayClick)
    }
) {
    Column(modifier = modifier) {
        header()
        weekDays()
        days()
    }
}

@Composable
internal fun DefaultHeader(
    viewState: CalendarHeaderViewState,
    onAction: (CalendarHeaderAction) -> Unit
) {
    CalendarHeader(viewState = viewState, onAction = onAction)
}

@Composable
internal fun DefaultWeekDays(viewState: CalendarWeekDaysViewState) {
    CalendarWeekDays(viewState = viewState)
}

@Composable
internal fun DefaultDays(viewState: CalendarDaysViewState, onClick: (Int) -> Unit) {
    CalendarDays(viewState = viewState, onClick = onClick)
}
