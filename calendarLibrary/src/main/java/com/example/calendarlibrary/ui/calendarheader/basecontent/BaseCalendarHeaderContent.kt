package com.example.calendarlibrary.ui.calendarheader.basecontent

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.calendarlibrary.ui.calendarheader.CalendarHeaderViewState
import com.example.calendarlibrary.ui.calendarheader.ContentAction

@Composable
fun BaseCalendarHeaderContent(
    viewState: CalendarHeaderViewState,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle.Default.copy(color = White),
    onAction: (ContentAction) -> Unit
) {
    Text(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                onAction(ContentAction)
            }
            .padding(vertical = 8.dp, horizontal = 16.dp),
        text = viewState.currentDate,
        textAlign = TextAlign.Center,
        style = textStyle
    )
}
