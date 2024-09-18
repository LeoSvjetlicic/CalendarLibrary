package com.leosvjetlicic.calendarlibrary.ui.calendarday

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.leosvjetlicic.calendarlibrary.ui.calendarday.singleday.ICalendarDay
import java.time.LocalDate

/**
 * Composable function that renders the days of a calendar month in a vertical column.
 *
 * This function takes a view state containing the days to be displayed and renders each week as a row
 * of days. It allows for customization of how each row of days is displayed and handles click events
 * for individual days.
 *
 * @param viewState The state object containing the days to be displayed in the calendar. It should be
 *                  an instance of [CalendarDaysViewState], which includes a list of weeks where each
 *                  week is represented as a list of [ICalendarHelper.kt] objects.
 * @param modifier A [Modifier] to apply customizations such as padding, size, or other layout adjustments
 *                 to the entire column of days.
 * @param onClick A lambda function triggered when a day is clicked. It receives a [LocalDate] representing
 *                 the clicked day. The default is an empty lambda, meaning no action occurs if not explicitly provided.
 * @param dayContent A composable function to render each row of days. It defaults to [DefaultCalendarDaysRow],
 *                   which uses the provided view state and click handler to display each row. The function
 *                   takes a list of [ICalendarHelper.kt] for each week and renders it accordingly.
 */
@Composable
fun CalendarDays(
    viewState: CalendarDaysViewState,
    modifier: Modifier = Modifier,
    onClick: (LocalDate) -> Unit = {},
    dayContent: @Composable (List<ICalendarDay>) -> Unit = {
        DefaultCalendarDaysRow(viewState = it, onClick = onClick)
    }
) {
    Column(modifier = modifier) {
        for (week in viewState.days) {
            dayContent(week)
        }
    }
}

@Composable
internal fun DefaultCalendarDaysRow(
    viewState: List<ICalendarDay>,
    modifier: Modifier = Modifier,
    onClick: (LocalDate) -> Unit
) {
    CalendarDaysRow(
        viewState = viewState,
        modifier = modifier,
        onClick = onClick
    )
}
