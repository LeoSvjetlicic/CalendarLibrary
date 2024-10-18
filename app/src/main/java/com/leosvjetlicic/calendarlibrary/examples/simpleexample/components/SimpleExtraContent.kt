package com.leosvjetlicic.calendarlibrary.examples.simpleexample.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun SimpleExtraContent(
    today: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Today's date: ",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = today,
            fontSize = 16.sp,
        )
    }
}
