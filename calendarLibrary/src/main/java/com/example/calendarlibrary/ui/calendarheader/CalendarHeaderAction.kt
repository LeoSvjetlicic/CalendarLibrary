package com.example.calendarlibrary.ui.calendarheader

/**
 * Represents a sealed class for different types of actions that can be
 * triggered in the calendar header. Sealed classes allow for a closed set
 * of types, ensuring that only predefined actions can be handled.
 */
sealed class CalendarHeaderAction

/**
 * Represents the first leading action in the calendar header.
 * This could be an action like navigating to the previous month/year.
 */
data object FirstLeadingAction : CalendarHeaderAction()

/**
 * Represents the second leading action in the calendar header.
 * This could be an additional navigation or other leading header action.
 */
data object SecondLeadingAction : CalendarHeaderAction()

/**
 * Represents the content action in the calendar header, which could involve
 * interactions with the displayed date, such as selecting the current month/year.
 */
data object ContentAction : CalendarHeaderAction()

/**
 * Represents the first trailing action in the calendar header.
 * This could be an action like navigating to the next month/year.
 */
data object FirstTrailingAction : CalendarHeaderAction()

/**
 * Represents the second trailing action in the calendar header.
 * This could be an additional navigation or other trailing header action.
 */
data object SecondTrailingAction : CalendarHeaderAction()
