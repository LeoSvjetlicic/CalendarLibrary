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
