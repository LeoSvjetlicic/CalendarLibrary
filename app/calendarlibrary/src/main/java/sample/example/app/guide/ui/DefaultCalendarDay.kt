package sample.example.app.guide.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DefaultCalendarDay(
    value: Int,
    modifier: Modifier = Modifier,
    indicatorModifier: Modifier = Modifier,
    clickable: Boolean = true,
    isSelected: Boolean = false,
    hasIndicator: Boolean = false,
    textColor: Color = Color.Black,
    backgroundColor: Color = Color.Cyan,
    onClick: () -> Unit
) {
    Box(modifier = modifier
        .then(
            if (clickable) {
                Modifier
                    .clickable { onClick() }
            } else {
                Modifier
            }
        )
        .then(
            if (isSelected) {
                Modifier.background(backgroundColor)
            } else {
                Modifier
            }
        )
        .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .wrapContentSize()
        ) {
            Text(
                modifier = Modifier,
                text = value.toString(),
                color = textColor
            )
            if (hasIndicator) {
                Box(modifier = indicatorModifier)
            }
        }
    }
}

@Composable
fun CalendarDay(
    value: Int,
    onClick: () -> Unit,
    container: @Composable (@Composable ColumnScope.() -> Unit) -> Unit,
    content: @Composable (Int) -> Unit = {
        DefaultCalendarDay(value = value, onClick = onClick)
    },
    leadingElement: @Composable () -> Unit = {},
    trailingElement: @Composable () -> Unit = {},
    bottomElement: @Composable () -> Unit = {},
    topElement: @Composable () -> Unit = {},
) {
    container {
        topElement()
        Row {
            leadingElement()
            content(value)
            trailingElement()
        }
        bottomElement()
    }
}
