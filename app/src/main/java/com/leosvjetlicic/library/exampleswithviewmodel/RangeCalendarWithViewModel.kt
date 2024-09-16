package com.leosvjetlicic.library.exampleswithviewmodel

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.leosvjetlicic.library.examples.rangeexample.RangeCalendarExample
import com.leosvjetlicic.library.exampleswithviewmodel.viewmodels.RangeViewModel

/**
 * This composable function renders a range calendar using a RangeViewModel.
 *
 * @param rangeViewModel The RangeViewModel instance managing the range calendar's state.
 * @param modifier (Optional) A modifier to style the overall calendar layout.
 */
@Composable
fun RangeCalendarWithViewModel(
    rangeViewModel: RangeViewModel,
    modifier: Modifier = Modifier
) {
    RangeCalendarExample(
        modifier = modifier,
        viewState = rangeViewModel.viewState.value,
        onHeaderAction = rangeViewModel::onHeaderAction,
        onDayClick = rangeViewModel::onDayClick
    )
}
