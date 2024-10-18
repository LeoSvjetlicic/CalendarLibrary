package com.leosvjetlicic.calendarlibrary.exampleswithviewmodel

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.leosvjetlicic.calendarlibrary.examples.defaultrangeexample.DefaultRangeCalendarExample
import com.leosvjetlicic.calendarlibrary.examples.rangeexample.RangeCalendarViewState
import com.leosvjetlicic.calendarlibrary.exampleswithviewmodel.viewmodels.DefaultRangeViewModel

@Composable
fun DefaultCalendarWithRangeWithViewModel(
    viewModel: DefaultRangeViewModel,
    modifier: Modifier = Modifier
) {
    DefaultRangeCalendarExample(
        modifier = modifier,
        viewState = viewModel.viewState.value as RangeCalendarViewState,
        onHeaderAction = viewModel::onHeaderAction,
        onDayClick = viewModel::onDayClick
    )
}
