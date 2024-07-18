package com.example.library

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.library.ui.theme.LibraryTheme
import sample.example.app.guide.data.CalendarDayViewState
import sample.example.app.guide.ui.ExampleCalendarDay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LibraryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var viewState by remember {
                        mutableStateOf(CalendarDayViewState(1, true, true, true))
                    }
                    var viewState2 by remember {
                        mutableStateOf(CalendarDayViewState(14, false, false, false))
                    }
                    Row(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        ExampleCalendarDay(
                            modifier = Modifier,
                            viewState = viewState,
                        ) {
                            viewState = viewState.copy(isSelected = !viewState.isSelected)
                        }
                        ExampleCalendarDay(
                            modifier = Modifier,
                            viewState = viewState2,
                        ) {
                            viewState2 = viewState2.copy(isSelected = !viewState2.isSelected)
                        }
                    }
                }
            }
        }
    }
}

