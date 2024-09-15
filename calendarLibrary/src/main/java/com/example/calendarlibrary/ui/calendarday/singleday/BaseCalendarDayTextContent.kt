package com.example.calendarlibrary.ui.calendarday.singleday

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

/**
 * Composable function that renders the text content of a calendar day within a [BoxScope].
 *
 * This function displays the day number in a calendar cell with customizable text attributes
 * and styling based on the state of the day (e.g., whether it's selected, part of the current month, etc.).
 *
 * @param viewState An instance of [ICalendarDay] representing the state of the calendar day. This includes
 *                  details such as the date, selection status, and whether it is part of the current month.
 *                  Changing this parameter will affect the displayed day number and its associated styling.
 * @param modifier A [Modifier] to apply customizations such as padding, size, or other layout adjustments
 *                 to the text content. Changing this parameter allows for alterations in the text's visual
 *                 presentation and positioning.
 * @param selectedTextColor The color of the text when the day is selected. Defaults to [White]. Changing this
 *                          parameter will modify the text color for selected days.
 * @param unselectedTextColor The color of the text when the day is not selected. Defaults to [Black]. Modifying
 *                            this parameter changes the text color for unselected days.
 * @param notCurrentMonthTextColor The color of the text for days that are not part of the current month. Defaults
 *                                 to [Transparent]. Changing this parameter adjusts the text color for days
 *                                 outside the current month.
 * @param textPadding The padding around the text content. Defaults to [4.dp]. Changing this parameter will
 *                    adjust the spacing around the text, affecting its positioning within the cell.
 * @param fontSize The size of the text. Defaults to [TextUnit.Unspecified], which means the default text size
 *                 is used. Modifying this parameter changes the size of the text displayed.
 * @param fontStyle The style of the text (e.g., italic). Defaults to `null`, meaning no specific style is applied.
 *                  Changing this parameter applies the specified font style to the text.
 * @param fontWeight The weight of the text (e.g., bold). Defaults to `null`, meaning no specific weight is applied.
 *                   Changing this parameter alters the thickness of the text.
 * @param fontFamily The font family of the text. Defaults to `null`, meaning the default font family is used.
 *                   Changing this parameter applies the specified font family to the text.
 * @param minWidth The minimum width of the text component. Defaults to [0.dp]. Changing this parameter adjusts the
 *              minimum width of the text area, ensuring it meets a specified minimum width.
 */
@Composable
fun BoxScope.BaseCalendarDayTextContent(
    viewState: ICalendarDay,
    modifier: Modifier = Modifier,
    selectedTextColor: Color = White,
    unselectedTextColor: Color = Black,
    notCurrentMonthTextColor: Color = Transparent,
    textPadding: Dp = 4.dp,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    minWidth: Dp = 0.dp
) {
    Text(
        modifier = modifier
            .widthIn(min = minWidth)
            .padding(textPadding)
            .align(
                alignment = Alignment.Center
            ),
        textAlign = TextAlign.Center,
        text = viewState.value.dayOfMonth.toString(),
        color = if (viewState.isCurrentMonth) {
            if (viewState.isSelected) {
                selectedTextColor
            } else {
                unselectedTextColor
            }
        } else {
            notCurrentMonthTextColor
        },
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontFamily = fontFamily,
        fontWeight = fontWeight
    )
}
