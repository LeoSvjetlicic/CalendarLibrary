package com.example.calendarlibrary.ui.calendarday.singleday

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.calendarlibrary.ui.colors.Orchid

@Composable
fun BoxScope.BaseCalendarDayIndicator(
    modifier: Modifier = Modifier,
    indicatorColor: Color = Orchid,
    indicatorSize: Dp = 4.dp,
) {
    Spacer(
        modifier = modifier
            .align(Alignment.BottomCenter)
            .size(indicatorSize)
            .clip(CircleShape)
            .background(indicatorColor)
    )
}
