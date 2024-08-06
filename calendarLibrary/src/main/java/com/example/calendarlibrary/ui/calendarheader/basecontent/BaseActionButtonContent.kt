package com.example.calendarlibrary.ui.calendarheader.basecontent

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
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
    paddingValues: PaddingValues = PaddingValues(6.dp),
    iconSize: Dp = 20.dp,
    onClick: () -> Unit
) {
    Icon(
        modifier = modifier
            .clip(CircleShape)
            .clickable { onClick() }
            .padding(paddingValues)
            .size(iconSize),
        painter = painterResource(id = iconId),
        contentDescription = contentDescription,
        tint = iconTint
    )
}
