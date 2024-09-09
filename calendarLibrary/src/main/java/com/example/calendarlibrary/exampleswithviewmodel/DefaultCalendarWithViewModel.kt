package com.example.calendarlibrary.exampleswithviewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.calendarlibrary.examples.defaultexample.DefaultCalendarExample
import com.example.calendarlibrary.exampleswithviewmodel.viewmodels.BaseViewModel
import com.example.calendarlibrary.ui.calendar.DefaultCalendarViewState
import com.example.calendarlibrary.utils.defaulthelper.DefaultCalendarHelper

@Composable
fun DefaultCalendarWithViewModel(
    helper: DefaultCalendarHelper,
    modifier: Modifier = Modifier
) {
    val defaultViewModel by remember {
        mutableStateOf(BaseViewModel(helper) { viewState, daysViewState, _ ->
            (viewState as DefaultCalendarViewState).copy(daysViewState = daysViewState)
        })
    }

    DefaultCalendarExample(
        modifier = modifier,
        viewState = defaultViewModel.viewState.value,
        onHeaderAction = defaultViewModel::onHeaderAction,
        onDayClick = defaultViewModel::onDayClick
    )
}
