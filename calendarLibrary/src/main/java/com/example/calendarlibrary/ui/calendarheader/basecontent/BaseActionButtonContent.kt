package com.example.calendarlibrary.ui.calendarheader.basecontent

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BaseActionButtonContent(
    @DrawableRes iconId: Int,
    modifier: Modifier = Modifier,
    contentDescription: String = "",
    iconTint: Color = Black,
    iconSize: Dp = 24.dp,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier
            .clip(CircleShape),
        onClick = { onClick() }) {
        Icon(
            modifier = Modifier.size(iconSize),
            painter = painterResource(id = iconId),
            contentDescription = contentDescription,
            tint = iconTint
        )
    }
}
