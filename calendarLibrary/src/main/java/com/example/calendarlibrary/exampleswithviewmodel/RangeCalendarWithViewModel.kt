package com.example.calendarlibrary.exampleswithviewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.calendarlibrary.examples.rangeexample.RangeCalendarExample
import com.example.calendarlibrary.examples.rangeexample.RangeCalendarViewState
import com.example.calendarlibrary.exampleswithviewmodel.viewmodels.RangeViewModel
import com.example.calendarlibrary.utils.SelectedDays
import com.example.calendarlibrary.utils.rangehelper.RangeCalendarHelper

@Composable
fun RangeCalendarWithViewModel(
    helper: RangeCalendarHelper,
    modifier: Modifier = Modifier
) {
    val rangeViewModel by remember {
        mutableStateOf(RangeViewModel(helper) { viewState, daysViewState, selectedRange ->
            (viewState as RangeCalendarViewState).copy(
                daysViewState = daysViewState,
                selectedRange = selectedRange as SelectedDays.DayRange
            )
        })
    }

    RangeCalendarExample(
        modifier = modifier,
        viewState = rangeViewModel.viewState.value,
        onHeaderAction = rangeViewModel::onHeaderAction,
        onDayClick = rangeViewModel::onDayClick
    )
}
