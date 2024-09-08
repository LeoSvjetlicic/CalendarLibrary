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
import com.example.calendarlibrary.examples.rangeexample.RangeCalendarDay
import com.example.calendarlibrary.examples.rangeexample.RangeCalendarExample
import com.example.calendarlibrary.examples.simpleexample.SimpleCalendarExample
import com.example.calendarlibrary.ui.calendarday.singleday.CalendarDayViewState
import com.example.calendarlibrary.utils.DateHelper.getMiddleDate
import com.example.calendarlibrary.utils.SelectedDays
import com.example.calendarlibrary.utils.defaulthelper.DefaultCalendarHelper
import com.example.calendarlibrary.utils.rangehelper.RangeCalendarHelper
import com.example.calendarlibrary.utils.simplehelper.SimpleCalendarHelper
import com.example.library.ui.theme.LibraryTheme
import java.time.DayOfWeek
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    private val helperUK = DefaultCalendarHelper(
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
    private val helperUS = RangeCalendarHelper(
        listOf(
            DayOfWeek.SUNDAY,
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY,
            DayOfWeek.FRIDAY,
            DayOfWeek.SATURDAY,
        )
    )
    private val workDays = SimpleCalendarHelper(
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
            val currentMonth by remember {
                mutableStateOf(LocalDate.now().month)
            }
            val currentYear by remember {
                mutableStateOf(LocalDate.now().year)
            }
            var viewState1 by remember {
                mutableStateOf(helperUK.generateCalendarViewState())
            }

            var viewState2 by remember {
                mutableStateOf(workDays.generateCalendarViewState())
            }

            var viewState3 by remember {
                mutableStateOf(
                    helperUS.generateCalendarViewState(
                        year = currentYear,
                        month = currentMonth,
                        selectedDays = SelectedDays.DayRange(null, null)
                    )
                )
            }
            LibraryTheme {
                LazyColumn {
                    item {
                        DefaultCalendarExample(
                            modifier = Modifier.width(300.dp),
                            viewState = viewState1,
                            onHeaderAction = {},
                            onDayClick = {
                                val newDays = viewState1.daysViewState.days.map { week ->
                                    week.map { d ->
                                        d as CalendarDayViewState
                                        if (d.isSelected) {
                                            d.copy(isSelected = false)
                                        } else {
                                            d.copy(isSelected = d.value == it && d.isCurrentMonth)
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
                                        if (d.isSelected) {
                                            d.copy(isSelected = false)
                                        } else {
                                            d.copy(isSelected = d.value == it && d.isCurrentMonth)
                                        }                                    }
                                }
                                val newDaysViewState = viewState2.daysViewState.copy(
                                    days = newDays
                                )
                                viewState2 =
                                    viewState2.copy(daysViewState = newDaysViewState)
                            })
                        Spacer(modifier = Modifier.height(30.dp))
                        RangeCalendarExample(
                            viewState = viewState3,
                            onHeaderAction = {},
                            onDayClick = { clickedDay ->
                                var newStartDate = viewState3.selectedRange.startDay
                                var newEndDate = viewState3.selectedRange.endDay
                                val selectedDaysSum =
                                    viewState3.daysViewState.days.sumOf { week -> week.count { day -> day.isSelected } }

                                when (selectedDaysSum) {
                                    0 -> newStartDate = clickedDay
                                    1 -> {
                                        if (clickedDay == newStartDate) {
                                            newStartDate = null
                                        } else if (newStartDate != null && clickedDay < newStartDate) {
                                            newEndDate =
                                                newStartDate
                                            newStartDate = clickedDay
                                        } else if (clickedDay == newEndDate) {
                                            newEndDate = null
                                        } else if (newEndDate != null && clickedDay > newEndDate) {
                                            newStartDate =
                                                newEndDate
                                            newEndDate = clickedDay
                                        } else {
                                            if (newStartDate == null) {
                                                newStartDate = clickedDay
                                            } else {
                                                newEndDate = clickedDay
                                            }
                                        }
                                    }

                                    2 -> {
                                        if (clickedDay != newStartDate && clickedDay != newEndDate) {
                                            val middle = getMiddleDate(newStartDate, newEndDate)
                                            if (clickedDay < middle) {
                                                newStartDate = clickedDay
                                            } else {
                                                newEndDate = clickedDay
                                            }
                                        } else {
                                            if (newStartDate == clickedDay) {
                                                newStartDate = null
                                            } else if (newEndDate == clickedDay) {
                                                newEndDate = null
                                            }
                                        }
                                    }
                                }

                                val newDays = viewState3.daysViewState.days.map { week ->
                                    week.map { d ->
                                        d as RangeCalendarDay
                                        when (d.value) {
                                            newStartDate, newEndDate -> d.copy(
                                                isSelected = true,
                                                isInRange = false
                                            )

                                            else -> d.copy(
                                                isSelected = false,
                                                isInRange = newStartDate != null && newEndDate != null && d.value > newStartDate && d.value < newEndDate
                                            )
                                        }
                                    }
                                }

                                viewState3 = viewState3.copy(
                                    daysViewState = viewState3.daysViewState.copy(days = newDays),
                                    selectedRange = SelectedDays.DayRange(newStartDate, newEndDate)
                                )
                            })
                    }
                }
            }
        }
    }
}

