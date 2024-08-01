package com.example.library

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.calendarlibrary.ui.calendar.Calendar
import com.example.calendarlibrary.ui.calendarday.CalendarDays
import com.example.calendarlibrary.ui.calendarday.CalendarDaysRow
import com.example.calendarlibrary.ui.calendarday.singleday.BaseCalendarDay
import com.example.calendarlibrary.ui.calendarday.singleday.BaseCalendarDayContent
import com.example.calendarlibrary.ui.calendarday.singleday.BaseCalendarDayTextContent
import com.example.calendarlibrary.ui.calendarday.singleday.CalendarDay
import com.example.calendarlibrary.ui.calendarweekdays.CalendarWeekDays
import com.example.calendarlibrary.utils.CalendarHelper
import com.example.library.ui.theme.LibraryTheme
import java.time.DayOfWeek

class MainActivity : ComponentActivity() {
    val helperUS = CalendarHelper(
        listOf(
            DayOfWeek.SUNDAY,
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY,
            DayOfWeek.FRIDAY,
            DayOfWeek.SATURDAY,
        )
    )
    val helperUK = CalendarHelper(
        listOf(
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY,
            DayOfWeek.FRIDAY,
            DayOfWeek.SATURDAY,
            DayOfWeek.SUNDAY
        )
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryTheme {
                LazyColumn {
                    item {
                        val viewState1 = helperUK.generateCalendarViewState()
                        Calendar(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color.DarkGray)
                                .padding(8.dp),
                            viewState = helperUK.generateCalendarViewState(),
                            onHeaderAction = {},
                            weekDays = {
                                Column {
                                    Spacer(
                                        modifier = Modifier
                                            .height(2.dp)
                                            .clip(CircleShape)
                                            .padding(horizontal = 14.dp)
                                            .fillMaxWidth()
                                            .background(Color.Black)
                                    )
                                    CalendarWeekDays(
                                        viewState = viewState1.weekDaysViewState,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 8.dp)
                                    )
                                    Spacer(
                                        modifier = Modifier
                                            .height(2.dp)
                                            .clip(CircleShape)
                                            .padding(horizontal = 14.dp)
                                            .fillMaxWidth()
                                            .background(Color.Black)
                                    )
                                }
                            },
                            onDayClick = {})
                        Spacer(modifier = Modifier.height(30.dp))
                        val viewState2 = helperUS.generateCalendarViewState()
                        Calendar(
                            modifier = Modifier
                                .padding(50.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .fillMaxWidth()
                                .background(Color.Black),
                            viewState = viewState2,
                            days = {
                                CalendarDays(
                                    viewState = viewState2.daysViewState,
                                    modifier = Modifier,
                                    onClick = {},
                                    dayContent = { dayContent ->
                                        CalendarDaysRow(
                                            viewState = dayContent,
                                            onClick = {},
                                            day = { rowsContent ->
                                                CalendarDay(
                                                    viewState = rowsContent,
                                                    onClick = {},
                                                    content = {
                                                        BaseCalendarDay(
                                                            modifier = Modifier.weight(1f),
                                                            viewState = rowsContent,
                                                            content = {
                                                                BaseCalendarDayContent(
                                                                    viewState = rowsContent,
                                                                    onClick = {},
                                                                    content = {
                                                                        BaseCalendarDayTextContent(
                                                                            viewState = rowsContent,
                                                                            notCurrentMonthTextColor = Color.LightGray.copy(
                                                                                alpha = 0.2f
                                                                            ),
                                                                        )
                                                                    }
                                                                )
                                                            },
                                                            onClick = {}
                                                        )
                                                    }
                                                )
                                            }
                                        )
                                    }
                                )
                            },
                            onHeaderAction = {},
                            onDayClick = {})
                    }
                }
            }
        }
    }
}
