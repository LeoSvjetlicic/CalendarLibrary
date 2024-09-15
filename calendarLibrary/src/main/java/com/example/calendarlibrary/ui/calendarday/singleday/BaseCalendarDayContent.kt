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
import java.time.LocalDate

/**
 * Composable function that renders the content of a calendar day, including its background, content, and optional indicator.
 *
 * This function displays a calendar day with customizable appearance, including background color, shape, and content.
 * It also handles click events and adjusts the size of the day cell to be square, ensuring consistent layout.
 *
 * @param viewState An instance of [ICalendarDay] representing the state of the calendar day. This includes details
 *                  such as the date, selection status, whether it is part of the current month, and if it is today.
 *                  Changing this parameter affects the displayed date, background color, and whether the day is
 *                  highlighted or has an indicator.
 * @param modifier A [Modifier] to apply customizations such as size, padding, or other layout adjustments to the
 *                 calendar day cell. Changing this parameter allows for adjustments to the day’s visual presentation
 *                 and positioning.
 * @param shape The shape of the calendar day cell. Defaults to [CircleShape]. Changing this parameter alters the
 *              shape of the cell (e.g., rounded corners, circles, etc.), affecting the overall look of the calendar.
 * @param paddingValues The padding around the content within the calendar day cell. Defaults to [PaddingValues(6.dp)].
 *                      Modifying this parameter adjusts the spacing around the day’s content, affecting its layout
 *                      within the cell.
 * @param selectedBackgroundColor The background color of the day when it is selected. Defaults to [LightPurple].
 *                                Changing this parameter will modify the color of selected days, allowing for
 *                                visual differentiation.
 * @param unselectedBackgroundColor The background color of the day when it is not selected. Defaults to [Transparent].
 *                                  Changing this parameter affects the color of unselected days, which could be useful
 *                                  for visual consistency or highlighting.
 * @param content A composable function defining the main content of the calendar day. Defaults to [DefaultCalendarDayContent],
 *                which renders the day’s content based on the provided view state. Changing this composable alters how
 *                the day’s content is displayed, allowing for customization of the day’s visual representation.
 * @param indicator A composable function that displays an optional indicator (e.g., a dot) for the day if it is today.
 *                  Defaults to [DefaultCalendarDayIndicator]. Changing this parameter allows for different indicators
 *                  or additional visual cues to be shown for the current day.
 * @param onClick A lambda function that is triggered when the calendar day is clicked. It receives a [LocalDate]
 *                 representing the clicked day. The default is an empty lambda, meaning no action occurs if not
 *                 explicitly provided. Modifying this lambda allows you to specify different actions when the day is clicked,
 *                 such as updating the selected date or navigating to a detailed view.
 */
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
    onClick: (LocalDate) -> Unit
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
