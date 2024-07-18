package sample.example.app.guide.ui

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable

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
