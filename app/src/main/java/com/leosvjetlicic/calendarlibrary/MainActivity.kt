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
import com.leosvjetlicic.calendarlibrary.exampleswithviewmodel.DefaultCalendarWithRangeWithViewModel
import com.leosvjetlicic.calendarlibrary.exampleswithviewmodel.DefaultCalendarWithViewModel
import com.leosvjetlicic.calendarlibrary.exampleswithviewmodel.RangeCalendarWithViewModel
import com.leosvjetlicic.calendarlibrary.exampleswithviewmodel.viewmodels.RangeViewModel
import com.leosvjetlicic.calendarlibrary.exampleswithviewmodel.viewmodels.RangeViewModelFactory
import com.leosvjetlicic.calendarlibrary.theme.LibraryTheme
import com.leosvjetlicic.calendarlibrary.ui.calendar.ICalendarViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarday.singleday.CalendarDayViewState
import com.leosvjetlicic.calendarlibrary.utils.DateHelper.getMiddleDate
import com.leosvjetlicic.calendarlibrary.utils.DefaultCalendarHelper
import com.leosvjetlicic.calendarlibrary.utils.ICalendarHelper
import com.leosvjetlicic.calendarlibrary.utils.RangeCalendarHelper
import com.leosvjetlicic.calendarlibrary.utils.Selected
import com.leosvjetlicic.calendarlibrary.utils.SimpleCalendarHelper
import com.leosvjetlicic.calendarlibrary.viewmodel.BaseViewModel
import com.leosvjetlicic.calendarlibrary.viewmodel.BaseViewModelFactory
import java.time.DayOfWeek
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    private val defaultCalendarHelper = DefaultCalendarHelper(
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
    private val simpleCalendarHelper = SimpleCalendarHelper(
        listOf(
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY,
            DayOfWeek.FRIDAY,
        )
    )
    private val rangeCalendarHelper = RangeCalendarHelper(
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

    val simpleCalendarViewModel by viewModels<BaseViewModel> {
        BaseViewModelFactory(
            helper = simpleCalendarHelper,
            selected = Selected.SingleDay(null)
        ) { viewState, daysViewState, _ ->
            (viewState as SimpleCalendarViewState).copy(daysViewState = daysViewState)
        }
    }

    val rangeCalendarViewModel by viewModels<RangeViewModel> {
        RangeViewModelFactory(
            rangeCalendarHelper,
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
                    item {
                        DefaultCalendarWithRangeWithViewModel(rangeCalendarViewModel)

                        Examples(defaultCalendarHelper, rangeCalendarHelper, simpleCalendarHelper)
                    }
                    item {
                        ExamplesWithViewModels(
                            simpleCalendarViewModel = simpleCalendarViewModel,
                            rangeCalendarViewModel = rangeCalendarViewModel
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Examples(defaultCalendarHelper: ICalendarHelper, rangeCalendarHelper: ICalendarHelper, simpleCalendarHelper: ICalendarHelper) {
    val currentMonth by remember {
        mutableStateOf(LocalDate.now().month)
    }
    val currentYear by remember {
        mutableIntStateOf(LocalDate.now().year)
    }
    var defaultViewState: ICalendarViewState by remember {
        mutableStateOf(defaultCalendarHelper.generateCalendarViewState())
    }

    var simpleViewState by remember {
        mutableStateOf(simpleCalendarHelper.generateCalendarViewState())
    }

    var rangeViewState by remember {
        mutableStateOf(
            rangeCalendarHelper.generateCalendarViewState(
                year = currentYear,
                month = currentMonth,
                selected = Selected.DayRange(null, null)
            )
        )
    }
    DefaultCalendarExample(
        modifier = Modifier.width(300.dp),
        viewState = defaultViewState,
        onHeaderAction = {},
        onDayClick = {
            val newDays = defaultViewState.daysViewState.days.map { week ->
                week.map { d ->
                    d as CalendarDayViewState
                    if (d.isSelected) {
                        d.copy(isSelected = false)
                    } else {
                        d.copy(isSelected = d.value == it && d.isCurrentMonth)
                    }
                }
            }
            val newDaysViewState = defaultViewState.daysViewState.copy(
                days = newDays
            )
            defaultViewState =
                (defaultViewState as DefaultCalendarViewState).copy(daysViewState = newDaysViewState)
        }
    )
    Spacer(modifier = Modifier.height(30.dp))
    SimpleCalendarExample(
        viewState = simpleViewState as SimpleCalendarViewState,
        onHeaderAction = {},
        onDayClick = {
            val newDays = simpleViewState.daysViewState.days.map { week ->
                week.map { d ->
                    d as CalendarDayViewState
                    if (d.isSelected) {
                        d.copy(isSelected = false)
                    } else {
                        d.copy(isSelected = d.value == it && d.isCurrentMonth)
                    }
                }
            }
            val newDaysViewState = simpleViewState.daysViewState.copy(
                days = newDays
            )
            simpleViewState =
                (simpleViewState as SimpleCalendarViewState).copy(daysViewState = newDaysViewState)

        })
    Spacer(modifier = Modifier.height(30.dp))
    RangeCalendarExample(
        viewState = rangeViewState,
        onHeaderAction = {},
        onDayClick = { clickedDay ->
            var newStartDate =
                (rangeViewState as RangeCalendarViewState).selectedRange.startDay
            var newEndDate =
                (rangeViewState as RangeCalendarViewState).selectedRange.endDay
            val selectedDaysSum =
                rangeViewState.daysViewState.days.sumOf { week -> week.count { day -> day.isSelected } }

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

            val newDays = rangeViewState.daysViewState.days.map { week ->
                week.map { d ->
                    d as RangeCalendarDay
                    when (d.value) {
                        newStartDate -> d.copy(
                            isSelected = true,
                            isInRange = newEndDate != null,
                            isFirstDayInRange = true
                        )

                        newEndDate -> d.copy(
                            isSelected = true,
                            isInRange = newStartDate != null,
                            isFirstDayInRange = false
                        )

                        else -> d.copy(
                            isSelected = false,
                            isInRange = newStartDate != null && newEndDate != null && d.value > newStartDate && d.value < newEndDate
                        )
                    }
                }
            }

            rangeViewState = (rangeViewState as RangeCalendarViewState).copy(
                daysViewState = rangeViewState.daysViewState.copy(days = newDays),
                selectedRange = Selected.DayRange(newStartDate, newEndDate)
            )
        })
}

@Composable
fun ExamplesWithViewModels(
    simpleCalendarViewModel: BaseViewModel,
    rangeCalendarViewModel: RangeViewModel,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "ViewModel examples",
            fontSize = 32.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        DefaultCalendarWithViewModel(simpleCalendarViewModel)
        Spacer(modifier = Modifier.height(20.dp))
        RangeCalendarWithViewModel(rangeCalendarViewModel)
    }
}
