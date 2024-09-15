package com.example.calendarlibrary.exampleswithviewmodel

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.calendarlibrary.examples.defaultexample.DefaultCalendarExample
import com.example.calendarlibrary.exampleswithviewmodel.viewmodels.BaseViewModel

/**
 * This composable function renders a default calendar using a BaseViewModel.
 *
 * @param defaultViewModel The BaseViewModel instance managing the calendar's state.
 * @param modifier (Optional) A modifier to style the overall calendar layout.
 */
@Composable
fun DefaultCalendarWithViewModel(
    defaultViewModel: BaseViewModel,
    modifier: Modifier = Modifier
) {
    DefaultCalendarExample(
        modifier = modifier,
        viewState = defaultViewModel.viewState.value,
        onHeaderAction = defaultViewModel::onHeaderAction,
        onDayClick = defaultViewModel::onDayClick
    )
}
