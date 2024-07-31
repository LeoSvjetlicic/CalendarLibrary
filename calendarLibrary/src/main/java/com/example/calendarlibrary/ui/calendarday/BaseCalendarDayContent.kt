package com.example.calendarlibrary.ui.calendarday

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.unit.dp
import com.example.calendarlibrary.ui.colors.Indigo


@Composable
fun BaseCalendarDayContent(
    viewState: CalendarDayViewState,
    modifier: Modifier = Modifier,
    selectedBackgroundColor: Color = Indigo,
    unselectedBackgroundColor: Color = Transparent,
    content: @Composable BoxScope.() -> Unit = {
        DefaultCalendarDayTextContent(
            viewState = viewState,
        )
    },
    indicator: @Composable BoxScope.() -> Unit = {
        DefaultCalendarDayIndicator()
    },
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .then(
                if (viewState.currentMonth) {
                    Modifier.clickable { onClick() }
                } else {
                    Modifier
                }
            )
            .background(
                if (viewState.isSelected) {
                    selectedBackgroundColor
                } else {
                    unselectedBackgroundColor
                }
            )
            .padding(10.dp)
    ) {
        content()
        if (viewState.isToday) {
            indicator()
        }
    }
}


@Composable
internal fun BoxScope.DefaultCalendarDayTextContent(
    viewState: CalendarDayViewState,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit = {
        BaseCalendarDayTextContent(viewState, modifier)
    }
) {
    content()
}

@Composable
internal fun BoxScope.DefaultCalendarDayIndicator(
    modifier: Modifier = Modifier,
    indicator: @Composable BoxScope.() -> Unit = {
        BaseCalendarDayIndicator(modifier)
    }
) {
    indicator()
}
