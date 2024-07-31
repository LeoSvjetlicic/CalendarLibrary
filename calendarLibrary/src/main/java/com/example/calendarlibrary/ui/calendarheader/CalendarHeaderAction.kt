package com.example.calendarlibrary.ui.calendarheader

sealed class CalendarHeaderAction

data object FirstLeadingAction : CalendarHeaderAction()
data object SecondLeadingAction : CalendarHeaderAction()
data object ContentAction : CalendarHeaderAction()
data object FirstTrailingAction : CalendarHeaderAction()
data object SecondTrailingAction : CalendarHeaderAction()
