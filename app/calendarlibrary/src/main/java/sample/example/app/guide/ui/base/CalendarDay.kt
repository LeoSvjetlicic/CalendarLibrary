package sample.example.app.guide.ui.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import sample.example.app.guide.data.CalendarDayViewState
import sample.example.app.guide.ui.ExampleCalendarDay

@Composable
fun CalendarDay(
    viewState: CalendarDayViewState,
    onClick: () -> Unit,
    modifier: Modifier,
    content: @Composable BoxScope.(Modifier) -> Unit = {
        ExampleCalendarDay(viewState = viewState, onClick = onClick)
    },
    leadingElement: @Composable BoxScope.(Modifier) -> Unit = {},
    trailingElement: @Composable BoxScope.(Modifier) -> Unit = {},
    bottomElement: @Composable BoxScope.(Modifier) -> Unit = {},
    topElement: @Composable BoxScope.(Modifier) -> Unit = {},
) {
    Box(modifier) {
        topElement(Modifier.align(Alignment.TopCenter))
        leadingElement(Modifier.align(Alignment.CenterStart))
        content(Modifier.align(Alignment.Center))
        trailingElement(Modifier.align(Alignment.CenterEnd))
        bottomElement(Modifier.align(Alignment.BottomCenter))
    }
}
