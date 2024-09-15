package com.example.calendarlibrary.ui.calendarheader

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Composable function that renders a calendar header based on the provided view state.
 *
 * @param viewState The view state that contains information to display in the header (e.g., current date).
 * @param modifier An optional modifier to apply customizations to the composable (e.g., padding, size).
 * @param onAction A lambda function that handles user actions triggered from the header,
 *                 which are represented by `CalendarHeaderAction` (e.g., navigating to the next/previous month).
 * @param content A composable lambda that defines the actual content to be displayed in the header.
 *                By default, it renders the `DefaultCalendarHeader` composable.
 */
@Composable
fun CalendarHeader(
    viewState: CalendarHeaderViewState,
    modifier: Modifier = Modifier,
    onAction: (CalendarHeaderAction) -> Unit,
    content: @Composable () -> Unit = {
        DefaultCalendarHeader(viewState = viewState, modifier = modifier, onAction = onAction)
    },
) {
    content()
}

@Composable
internal fun DefaultCalendarHeader(
    viewState: CalendarHeaderViewState,
    modifier: Modifier = Modifier,
    onAction: (CalendarHeaderAction) -> Unit,
) {
    BaseCalendarHeader(
        viewState = viewState,
        modifier = modifier.padding(horizontal = 10.dp),
        onAction = onAction
    )
}
