package com.example.calendarlibrary.exampleswithviewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.calendarlibrary.examples.simpleexample.SimpleCalendarExample
import com.example.calendarlibrary.examples.simpleexample.SimpleCalendarViewState
import com.example.calendarlibrary.exampleswithviewmodel.viewmodels.BaseViewModel
import com.example.calendarlibrary.utils.simplehelper.SimpleCalendarHelper

@Composable
fun SimpleCalendarWithViewModel(
    helper: SimpleCalendarHelper,
    modifier: Modifier = Modifier
) {
    val simpleViewModel by remember {
        (mutableStateOf(BaseViewModel(helper) { viewState, daysViewState,_ ->
            (viewState as SimpleCalendarViewState).copy(daysViewState = daysViewState)
        }))
    }

    SimpleCalendarExample(
        modifier = modifier,
        viewState = simpleViewModel.viewState.value as SimpleCalendarViewState,
        onHeaderAction = simpleViewModel::onHeaderAction,
        onDayClick = simpleViewModel::onDayClick
    )
}
