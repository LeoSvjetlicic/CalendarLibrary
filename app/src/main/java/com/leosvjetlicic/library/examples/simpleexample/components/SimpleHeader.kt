package com.leosvjetlicic.library.examples.simpleexample.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.CalendarHeaderAction
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.CalendarHeaderViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.ContentAction
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.FirstTrailingAction
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.SecondLeadingAction
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.basecontent.BaseActionButtonContent
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.basecontent.BaseCalendarHeaderContent
import com.leosvjetlicic.library.R

/**
 * This composable function renders a simple calendar header.
 *
 * @param viewState The view state for the header.
 * @param modifier (Optional) A modifier to style the overall header layout.
 * @param invertedOrder (Optional) Whether to invert the order of the content and actions. Defaults to false.
 * @param onAction A callback function to handle header actions.
 * @param firstIconContent (Optional) A lambda that defines the content for the first icon.
 * @param secondIconContent (Optional) A lambda that defines the content for the second icon.
 * @param content (Optional) A lambda that defines the content to be displayed between the icons.
 */
@Composable
fun SimpleHeader(
    viewState: CalendarHeaderViewState,
    modifier: Modifier = Modifier,
    invertedOrder: Boolean = false,
    onAction: (CalendarHeaderAction) -> Unit,
    firstIconContent: @Composable () -> Unit = {
        SimpleCalendarHeaderActionButtonContent(
            iconId = R.drawable.ic_left_single,
            onClick = { onAction(SecondLeadingAction) })
    },
    secondIconContent: @Composable () -> Unit = {
        SimpleCalendarHeaderActionButtonContent(
            iconId = R.drawable.ic_right_single,
            onClick = { onAction(FirstTrailingAction) })
    },
    content: @Composable RowScope.() -> Unit = {
        SimpleCalendarHeaderActionTextContent(
            viewState = viewState,
            onAction = onAction
        )
    }
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if (!invertedOrder) {
            content()
        }
        Row {
            firstIconContent()
            secondIconContent()
        }
        if (invertedOrder) {
            content()
        }
    }
}

/**
 * This composable function renders a simple action button content for the calendar header.
 *
 * @param iconId The resource ID of the icon to display.
 * @param modifier (Optional) A modifier to style the action button content.
 * @param onClick A callback function to handle clicks on the action button.
 */
@Composable
internal fun SimpleCalendarHeaderActionButtonContent(
    iconId: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    BaseActionButtonContent(
        modifier = modifier,
        iconId = iconId,
        iconSize = 30.dp,
        onClick = onClick
    )
}

/**
 * This composable function renders the text content for a calendar header action.
 *
 * @param viewState The view state for the header.
 * @param onAction A callback function to handle actions triggered by the text content.
 */
@Composable
internal fun SimpleCalendarHeaderActionTextContent(
    viewState: CalendarHeaderViewState,
    onAction: (ContentAction) -> Unit
) {
    BaseCalendarHeaderContent(
        viewState = viewState,
        onAction = onAction,
        textStyle = TextStyle.Default.copy(fontSize = 24.sp)
    )
}
