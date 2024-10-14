package com.leosvjetlicic.calendarlibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leosvjetlicic.calendarlibrary.examples.defaultexample.DefaultCalendarExample
import com.leosvjetlicic.calendarlibrary.examples.rangeexample.RangeCalendarDay
import com.leosvjetlicic.calendarlibrary.examples.rangeexample.RangeCalendarExample
import com.leosvjetlicic.calendarlibrary.examples.rangeexample.RangeCalendarViewState
import com.leosvjetlicic.calendarlibrary.examples.simpleexample.SimpleCalendarExample
import com.leosvjetlicic.calendarlibrary.examples.simpleexample.SimpleCalendarViewState
import com.leosvjetlicic.calendarlibrary.exampleswithviewmodel.DefaultCalendarViewState
import com.leosvjetlicic.calendarlibrary.exampleswithviewmodel.DefaultCalendarWithViewModel
import com.leosvjetlicic.calendarlibrary.exampleswithviewmodel.RangeCalendarWithViewModel
import com.leosvjetlicic.calendarlibrary.exampleswithviewmodel.viewmodels.RangeViewModel
import com.leosvjetlicic.calendarlibrary.exampleswithviewmodel.viewmodels.RangeViewModelFactory
import com.leosvjetlicic.calendarlibrary.exampleutils.defaulthelper.DefaultCalendarHelper
import com.leosvjetlicic.calendarlibrary.exampleutils.rangehelper.RangeCalendarHelper
import com.leosvjetlicic.calendarlibrary.exampleutils.simplehelper.SimpleCalendarHelper
import com.leosvjetlicic.calendarlibrary.theme.LibraryTheme
import com.leosvjetlicic.calendarlibrary.ui.calendar.ICalendarViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarday.singleday.CalendarDayViewState
import com.leosvjetlicic.calendarlibrary.utils.DateHelper.getMiddleDate
import com.leosvjetlicic.calendarlibrary.utils.ICalendarHelper
import com.leosvjetlicic.calendarlibrary.utils.Selected
import com.leosvjetlicic.calendarlibrary.viewmodel.BaseViewModel
import com.leosvjetlicic.calendarlibrary.viewmodel.BaseViewModelFactory
import java.time.DayOfWeek
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    private val helper1 = DefaultCalendarHelper(
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
    private val helperWorkDays = SimpleCalendarHelper(
        listOf(
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY,
            DayOfWeek.FRIDAY,
        )
    )
    private val helper3 = RangeCalendarHelper(
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

    val viewModel1 by viewModels<BaseViewModel> {
        BaseViewModelFactory(
            helper = helperWorkDays,
            selected = Selected.SingleDay(null)
        ) { viewState, daysViewState, _ ->
            (viewState as SimpleCalendarViewState).copy(daysViewState = daysViewState)
        }
    }

    val viewModel2 by viewModels<RangeViewModel> {
        RangeViewModelFactory(
            helper3,
            selected = Selected.DayRange(null, null)
        ) { viewState, daysViewState, selectedRange ->
            (viewState as RangeCalendarViewState).copy(
                daysViewState = daysViewState,
                selectedRange = selectedRange as Selected.DayRange
            )
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryTheme {
                LazyColumn {
                    item { Examples(helper1, helper3, helperWorkDays) }
                    item {
                        ExamplesWithViewModels(
                            viewModel1 = viewModel1,
                            viewModel2 = viewModel2
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Examples(helper1: ICalendarHelper, helper2: ICalendarHelper, weekDaysHelper: ICalendarHelper) {
    val currentMonth by remember {
        mutableStateOf(LocalDate.now().month)
    }
    val currentYear by remember {
        mutableIntStateOf(LocalDate.now().year)
    }
    var viewState1: ICalendarViewState by remember {
        mutableStateOf(helper1.generateCalendarViewState())
    }

    var viewState2 by remember {
        mutableStateOf(weekDaysHelper.generateCalendarViewState())
    }

    var viewState3 by remember {
        mutableStateOf(
            helper2.generateCalendarViewState(
                year = currentYear,
                month = currentMonth,
                selected = Selected.DayRange(null, null)
            )
        )
    }
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
                (viewState1 as DefaultCalendarViewState).copy(daysViewState = newDaysViewState)
        }
    )
    Spacer(modifier = Modifier.height(30.dp))
    SimpleCalendarExample(
        viewState = viewState2 as SimpleCalendarViewState,
        onHeaderAction = {},
        onDayClick = {
            val newDays = viewState2.daysViewState.days.map { week ->
                week.map { d ->
                    d as CalendarDayViewState
                    if (d.isSelected) {
                        d.copy(isSelected = false)
                    } else {
                        d.copy(isSelected = d.value == it && d.isCurrentMonth)
                    }
                }
            }
            val newDaysViewState = viewState2.daysViewState.copy(
                days = newDays
            )
            viewState2 =
                (viewState2 as SimpleCalendarViewState).copy(daysViewState = newDaysViewState)

        })
    Spacer(modifier = Modifier.height(30.dp))
    RangeCalendarExample(
        viewState = viewState3,
        onHeaderAction = {},
        onDayClick = { clickedDay ->
            var newStartDate =
                (viewState3 as RangeCalendarViewState).selectedRange.startDay
            var newEndDate =
                (viewState3 as RangeCalendarViewState).selectedRange.endDay
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
                        val middle = if (newStartDate != null && newEndDate != null) {
                            getMiddleDate(newStartDate, newEndDate)
                        } else {
                            null
                        }
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

            viewState3 = (viewState3 as RangeCalendarViewState).copy(
                daysViewState = viewState3.daysViewState.copy(days = newDays),
                selectedRange = Selected.DayRange(newStartDate, newEndDate)
            )
        })
}

@Composable
fun ExamplesWithViewModels(
    viewModel1: BaseViewModel,
    viewModel2: RangeViewModel,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "ViewModel examples",
            fontSize = 32.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        DefaultCalendarWithViewModel(viewModel1)
        Spacer(modifier = Modifier.height(20.dp))
        RangeCalendarWithViewModel(viewModel2)
    }
}
