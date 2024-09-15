package com.example.calendarlibrary.ui.calendarheader

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.calendarlibrary.R
import com.example.calendarlibrary.ui.calendarheader.basecontent.BaseActionButtonContent
import com.example.calendarlibrary.ui.calendarheader.basecontent.BaseCalendarHeaderContent

/**
 * Composable function that creates the base structure for a calendar header.
 * It allows customization of leading/trailing buttons and the central content
 * (typically the current month or date) using composable lambdas.
 *
 * @param viewState The view state that contains the current date information to be displayed.
 * @param modifier An optional modifier to apply customizations such as padding or size.
 * @param onAction A lambda function that handles user actions, triggering different types of
 *                 `CalendarHeaderAction` (e.g., FirstLeadingAction, SecondLeadingAction).
 * @param firstLeadingContent Composable content for the first leading action button, by default it shows a button
 *                            with a double left arrow icon, triggering `FirstLeadingAction`.
 * @param secondLeadingContent Composable content for the second leading action button, by default it shows a button
 *                             with a single left arrow icon, triggering `SecondLeadingAction`.
 * @param firstTrailingContent Composable content for the first trailing action button, by default it shows a button
 *                             with a single right arrow icon, triggering `FirstTrailingAction`.
 * @param secondTrailingContent Composable content for the second trailing action button, by default it shows a button
 *                              with a double right arrow icon, triggering `SecondTrailingAction`.
 * @param content A composable lambda that defines the central content of the header,
 *                by default it renders the `DefaultCalendarHeaderContent`.
 */
@Composable
fun BaseCalendarHeader(
    viewState: CalendarHeaderViewState,
    modifier: Modifier = Modifier,
    onAction: (CalendarHeaderAction) -> Unit,
    firstLeadingContent: @Composable () -> Unit = {
        DefaultCalendarHeaderActionButtonContent(
            iconId = R.drawable.ic_left_double,
            onClick = { onAction(FirstLeadingAction) })
    },
    secondLeadingContent: @Composable () -> Unit = {
        DefaultCalendarHeaderActionButtonContent(
            iconId = R.drawable.ic_left_single,
            onClick = { onAction(SecondLeadingAction) })
    },
    firstTrailingContent: @Composable () -> Unit = {
        DefaultCalendarHeaderActionButtonContent(
            iconId = R.drawable.ic_right_single,
            onClick = { onAction(FirstTrailingAction) })
    },
    secondTrailingContent: @Composable () -> Unit = {
        DefaultCalendarHeaderActionButtonContent(
            iconId = R.drawable.ic_right_double,
            onClick = { onAction(SecondTrailingAction) })
    },
    content: @Composable RowScope.() -> Unit = {
        DefaultCalendarHeaderContent(viewState = viewState, onAction = onAction)
    }
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            firstLeadingContent()
            secondLeadingContent()
        }
        content()
        Row {
            firstTrailingContent()
            secondTrailingContent()
        }
    }
}

@Composable
internal fun DefaultCalendarHeaderContent(
    viewState: CalendarHeaderViewState,
    onAction: (ContentAction) -> Unit
) {
    BaseCalendarHeaderContent(viewState = viewState, onAction = onAction)
}

@Composable
internal fun DefaultCalendarHeaderActionButtonContent(
    iconId: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    BaseActionButtonContent(
        iconId = iconId,
        modifier = modifier,
        onClick = onClick
    )
}
