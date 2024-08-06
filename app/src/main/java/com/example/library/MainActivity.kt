package com.example.library

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.calendarlibrary.examples.defaultexample.DefaultCalendarExample
import com.example.calendarlibrary.examples.simpleexample.SimpleCalendarExample
import com.example.calendarlibrary.ui.calendarday.singleday.CalendarDayViewState
import com.example.calendarlibrary.utils.DefaultCalendarHelper
import com.example.calendarlibrary.utils.SimpleCalendarHelper
import com.example.library.ui.theme.LibraryTheme
import java.time.DayOfWeek

class MainActivity : ComponentActivity() {
    val helperUK = DefaultCalendarHelper(
        listOf(
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY,
            DayOfWeek.FRIDAY,
            DayOfWeek.SATURDAY,
            DayOfWeek.SUNDAY,
        )
    )
    val workDays = SimpleCalendarHelper(
        listOf(
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY,
            DayOfWeek.FRIDAY,
        )
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryTheme {
                LazyColumn {
                    item {
                        var viewState1 by remember {
                            mutableStateOf(helperUK.generateCalendarViewState())
                        }

                        var viewState2 by remember {
                            mutableStateOf(workDays.generateCalendarViewState())
                        }
                        DefaultCalendarExample(
                            modifier = Modifier.width(300.dp),
                            viewState = viewState1,
                            onHeaderAction = {},
                            onDayClick = {
                                val newDays = viewState1.daysViewState.days.map { week ->
                                    week.map { d ->
                                        d as CalendarDayViewState
                                        if (d.value == it && d.isCurrentMonth) {
                                            d.copy(isSelected = true)
                                        } else {
                                            d.copy(isSelected = false)
                                        }
                                    }
                                }
                                val newDaysViewState = viewState1.daysViewState.copy(
                                    days = newDays
                                )
                                viewState1 =
                                    viewState1.copy(daysViewState = newDaysViewState)
                            }
                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        SimpleCalendarExample(
                            viewState = viewState2,
                            onHeaderAction = {},
                            onDayClick = {
                                val newDays = viewState2.daysViewState.days.map { week ->
                                    week.map { d ->
                                        d as CalendarDayViewState
                                        if (d.value == it && d.isCurrentMonth) {
                                            d.copy(isSelected = true)
                                        } else {
                                            d.copy(isSelected = false)
                                        }
                                    }
                                }
                                val newDaysViewState = viewState2.daysViewState.copy(
                                    days = newDays
                                )
                                viewState2 =
                                    viewState2.copy(daysViewState = newDaysViewState)
                            })
                    }
                }
            }
        }
    }
}
