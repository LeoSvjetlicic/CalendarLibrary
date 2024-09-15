package com.example.calendarlibrary.ui.calendarday.singleday

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import java.time.LocalDate

/**
 * Composable function that renders a single calendar day.
 *
 * This function displays a single day in the calendar, allowing for customization of its appearance,
 * click behavior, and additional helper content. The day is rendered using the provided view state,
 * with options for customizing how it is displayed and interacted with.
 *
 * @param viewState An instance of [ICalendarDay] representing the state of the calendar day to be displayed.
 *                  This includes details such as the date, selection status, and whether it is today or
 *                  part of the current month. Changing this parameter will affect the displayed information
 *                  for the day, such as its date and status.
 * @param modifier A [Modifier] to apply customizations such as padding, size, or layout adjustments
 *                 to the calendar day. Changing this parameter can alter the visual appearance and layout
 *                 of the day in the calendar view.
 * @param onClick A lambda function that is triggered when the calendar day is clicked. It receives a [LocalDate]
 *                 representing the clicked day. The default is an empty lambda, meaning no action occurs
 *                 if not explicitly provided. Modifying this lambda allows you to specify different actions
 *                 when the day is clicked, such as navigating to details or updating the selected date.
 * @param content A composable function that defines the main content of the calendar day. It defaults to
 *                [DefaultCalendarDay], which renders the day using the provided view state and click handler.
 *                The function takes the [ICalendarDay] as a parameter and displays it according to the provided
 *                view state. Changing this composable function will alter how the day is rendered, allowing for
 *                custom designs or additional information to be shown.
 * @param helperContent A composable function for rendering additional content related to the calendar day,
 *                      such as badges or supplementary information. The default is an empty composable, meaning
 *                      no additional content is shown if not provided. Modifying this parameter allows you to
 *                      include extra details or decorations alongside the main content of the day.
 */
@Composable
fun CalendarDay(
    viewState: ICalendarDay,
    modifier: Modifier = Modifier,
    onClick: (LocalDate) -> Unit = {},
    content: @Composable BoxScope.(ICalendarDay) -> Unit = {
        DefaultCalendarDay(
            modifier = Modifier.align(Alignment.Center),
            viewState = viewState,
            onClick = onClick
        )
    },
    helperContent: @Composable BoxScope.() -> Unit = {}
) {
    Box(
        modifier = modifier
    ) {
        content(viewState)
        helperContent()
    }
}

@Composable
internal fun DefaultCalendarDay(
    viewState: ICalendarDay,
    modifier: Modifier = Modifier,
    onClick: (LocalDate) -> Unit
) {
    BaseCalendarDayContent(
        modifier = modifier,
        viewState = viewState,
        onClick = onClick
    )
}
