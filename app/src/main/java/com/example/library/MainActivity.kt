package com.example.library

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calendarlibrary.ui.calendarday.singleday.CalendarDay
import com.example.calendarlibrary.ui.calendarday.singleday.CalendarDayViewState
import com.example.calendarlibrary.ui.calendarheader.CalendarHeader
import com.example.calendarlibrary.ui.calendarheader.CalendarHeaderViewState
import com.example.calendarlibrary.utils.CalendarHelper
import com.example.library.ui.theme.LibraryTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    val helperUS = CalendarHelper(Locale.US)
    val helperUK = CalendarHelper(Locale.UK)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("adlkfnadf",helperUK.getDaysOfWeekList().toString())
        Log.d("adlkfnadf",helperUS.getDaysOfWeekList().toString())
        setContent {
            LibraryTheme {
            }
        }
    }
}

@Preview
@Composable
private fun afdc() {
    Column {
        var viewState1 by remember {
            mutableStateOf(CalendarDayViewState(12, false, true, true))
        }
        var viewState2 by remember {
            mutableStateOf(CalendarDayViewState(12, false, true, false))
        }
        var viewState3 by remember {
            mutableStateOf(CalendarDayViewState(12, false, false, true))
        }
        CalendarHeader(
            modifier = Modifier.fillMaxWidth(),
            viewState = CalendarHeaderViewState("June 2024"),
            onAction = {})

        Row {
            CalendarDay(
                modifier = Modifier,
                viewState = viewState1,
                onClick = {
                    viewState1 = viewState1.copy(isSelected = !viewState1.isSelected)
                })
            CalendarDay(
                modifier = Modifier,
                viewState = viewState2,
                onClick = {
                    viewState2 = viewState2.copy(isSelected = !viewState2.isSelected)
                })
            CalendarDay(
                modifier = Modifier,
                viewState = viewState3,
                onClick = {
                    viewState3 = viewState3.copy(isSelected = !viewState3.isSelected)
                })
        }
    }
}
