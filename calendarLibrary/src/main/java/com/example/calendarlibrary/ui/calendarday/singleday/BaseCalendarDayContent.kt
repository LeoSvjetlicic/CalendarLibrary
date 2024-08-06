package com.example.calendarlibrary.ui.calendarday.singleday

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.calendarlibrary.ui.colors.LightPurple


@Composable
fun BaseCalendarDayContent(
    viewState: ICalendarDay,
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    paddingValues: PaddingValues = PaddingValues(6.dp),
    selectedBackgroundColor: Color = LightPurple,
    unselectedBackgroundColor: Color = Transparent,
    content: @Composable BoxScope.() -> Unit = {
        DefaultCalendarDayContent(
            modifier = Modifier,
            viewState = viewState,
        )
    },
    indicator: @Composable BoxScope.() -> Unit = {
        DefaultCalendarDayIndicator()
    },
    onClick: (Int) -> Unit
) {
    var width by remember { mutableIntStateOf(0) }
    var height by remember { mutableIntStateOf(0) }
    val density = LocalDensity.current
    Box(
        modifier = modifier
            .onSizeChanged {
                width = it.width
                height = it.height
            }
            .heightIn(min = with(density) {
                if (height < width) {
                    width.toDp()
                } else {
                    height.toDp()
                }
            })
            .widthIn(min = with(density) {
                if (width < height) {
                    height.toDp()
                } else {
                    width.toDp()
                }
            })
            .clip(shape)
            .then(
                if (viewState.isCurrentMonth) {
                    Modifier
                        .clickable {
                            onClick(viewState.value)
                        }
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
            .padding(paddingValues),
    ) {
        content()
        if (viewState.isToday) {
            indicator()
        }
    }
}


@Composable
internal fun BoxScope.DefaultCalendarDayContent(
    viewState: ICalendarDay,
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
