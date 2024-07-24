package com.example.library

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.calendarlibrary.data.CalendarDayViewState
import com.example.calendarlibrary.ui.CalendarDay
import com.example.library.ui.theme.LibraryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryTheme {
                var viewState1 by remember {
                    mutableStateOf(CalendarDayViewState(12, false, true, true))
                }
                var viewState2 by remember {
                    mutableStateOf(CalendarDayViewState(12, false, true, false))
                }
                var viewState3 by remember {
                    mutableStateOf(CalendarDayViewState(12, false, false, true))
                }
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(23, 23, 23)),
                ) {
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
    }
}

