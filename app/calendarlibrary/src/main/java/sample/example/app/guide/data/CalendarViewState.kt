package sample.example.app.guide.data

data class CalendarViewState(
    val month: String,
    val year: Int,
    val daysOfWeek: List<String>,
    val dates: List<List<CalendarDayViewState>>
)
