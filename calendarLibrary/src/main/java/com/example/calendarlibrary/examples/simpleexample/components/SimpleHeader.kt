package com.example.calendarlibrary.examples.simpleexample.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calendarlibrary.R
import com.example.calendarlibrary.ui.calendarheader.CalendarHeaderAction
import com.example.calendarlibrary.ui.calendarheader.CalendarHeaderViewState
import com.example.calendarlibrary.ui.calendarheader.ContentAction
import com.example.calendarlibrary.ui.calendarheader.FirstTrailingAction
import com.example.calendarlibrary.ui.calendarheader.SecondLeadingAction
import com.example.calendarlibrary.ui.calendarheader.basecontent.BaseActionButtonContent
import com.example.calendarlibrary.ui.calendarheader.basecontent.BaseCalendarHeaderContent

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
