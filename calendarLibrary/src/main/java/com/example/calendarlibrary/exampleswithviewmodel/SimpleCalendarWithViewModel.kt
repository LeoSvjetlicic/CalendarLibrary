package com.example.calendarlibrary.exampleswithviewmodel

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.calendarlibrary.examples.simpleexample.SimpleCalendarExample
import com.example.calendarlibrary.examples.simpleexample.SimpleCalendarViewState
import com.example.calendarlibrary.exampleswithviewmodel.viewmodels.BaseViewModel

/**
 * This composable function renders a simple calendar using a BaseViewModel.
 *
 * @param simpleViewModel The BaseViewModel instance managing the simple calendar's state.
 * @param modifier (Optional) A modifier to style the overall calendar layout.
 */
@Composable
fun SimpleCalendarWithViewModel(
    simpleViewModel: BaseViewModel,
    modifier: Modifier = Modifier
) {
    SimpleCalendarExample(
        modifier = modifier,
        viewState = simpleViewModel.viewState.value as SimpleCalendarViewState,
        onHeaderAction = simpleViewModel::onHeaderAction,
        onDayClick = simpleViewModel::onDayClick
    )
}
