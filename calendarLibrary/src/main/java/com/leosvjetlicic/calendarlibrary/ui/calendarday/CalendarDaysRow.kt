package com.leosvjetlicic.calendarlibrary.ui.calendarday

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.leosvjetlicic.calendarlibrary.ui.calendarday.singleday.CalendarDay
import com.leosvjetlicic.calendarlibrary.ui.calendarday.singleday.ICalendarDay
import java.time.LocalDate

/**
 * Composable function that renders a row of calendar days.
 *
 * This function creates a horizontal row of calendar days using the provided view state.
 * Each day can be customized and is displayed in a row with adjustable alignment, arrangement, and click behavior.
 *
 * @param viewState A list of [ICalendarDay] representing the days to be displayed in the row.
 *                  Each item in the list corresponds to a single day and provides the data needed
 *                  to render that day in the calendar view.
 * @param modifier A [Modifier] to apply customizations such as padding, size, or other layout adjustments
 *                 to the entire row of days.
 * @param alignment The vertical alignment of the days within the row. Defaults to [Alignment.CenterVertically],
 *                  which centers the days vertically within the row.
 * @param arrangement The horizontal arrangement of the days within the row. Defaults to [Arrangement.SpaceEvenly],
 *                    which evenly distributes the days across the row with equal spacing.
 * @param onClick A lambda function that is triggered when a day is clicked. It receives a [LocalDate]
 *                 representing the clicked day. The default is an empty lambda, meaning no action occurs
 *                 if not explicitly provided.
 * @param day A composable function to render each individual day. It defaults to [DefaultSingleCalendarDay],
 *            which uses the provided day view state and click handler to display each day in the row.
 */
@Composable
fun CalendarDaysRow(
    viewState: List<ICalendarDay>,
    modifier: Modifier = Modifier,
    alignment: Alignment.Vertical = Alignment.CenterVertically,
    arrangement: Arrangement.Horizontal = Arrangement.SpaceEvenly,
    onClick: (LocalDate) -> Unit = {},
    day: @Composable RowScope.(ICalendarDay) -> Unit = {
        DefaultSingleCalendarDay(
            modifier = Modifier.weight(1f),
            viewState = it,
            onClick = onClick
        )
    }
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = alignment,
        horizontalArrangement = arrangement
    ) {
        viewState.forEach {
            day(it)
        }
    }
}

@Composable
internal fun DefaultSingleCalendarDay(
    viewState: ICalendarDay,
    modifier: Modifier = Modifier,
    onClick: (LocalDate) -> Unit
) {
    CalendarDay(viewState = viewState, modifier = modifier, onClick = onClick)
}
