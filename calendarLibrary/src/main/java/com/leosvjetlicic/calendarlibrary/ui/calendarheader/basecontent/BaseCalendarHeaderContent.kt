package com.leosvjetlicic.calendarlibrary.ui.calendarheader.basecontent

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.CalendarHeaderViewState
import com.leosvjetlicic.calendarlibrary.ui.calendarheader.ContentAction

/**
 * Composable function that displays the content of the calendar header.
 *
 * This function renders a clickable header with customizable text style, shape, and padding.
 * It takes a [CalendarHeaderViewState] to display the current date and triggers an action
 * when the header is clicked.
 *
 * @param viewState The state object containing the current date to be displayed in the header.
 * @param modifier A [Modifier] to apply customization such as padding, size, or clipping to the header.
 * @param textStyle The style applied to the header text, which can be customized for color, size, etc.
 *                  The default is black text. Changing this will affect the appearance of the header text.
 * @param shape The shape of the header. By default, it uses a rounded corner shape with 8.dp radius.
 *              Adjusting this alters the visual presentation of the header (e.g., square or custom shape).
 * @param paddingValues The padding around the header text. By default, it provides 8.dp vertical
 *                      and 16.dp horizontal padding. Changing this adjusts the space around the text.
 * @param onAction A lambda function triggered when the header is clicked.
 *                 Typically used to handle user interaction when they click on the header.
 */
@Composable
fun BaseCalendarHeaderContent(
    viewState: CalendarHeaderViewState,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle.Default.copy(color = Black),
    shape: Shape = RoundedCornerShape(8.dp),
    paddingValues: PaddingValues = PaddingValues(8.dp, 16.dp),
    onAction: (ContentAction) -> Unit
) {
    Text(
        modifier = modifier
            .clip(shape)
            .clickable {
                onAction(ContentAction)
            }
            .padding(paddingValues),
        text = viewState.currentDate,
        textAlign = TextAlign.Center,
        style = textStyle
    )
}
