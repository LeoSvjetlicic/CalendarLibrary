# Calendar Library

A calendar library with fully customizable UI and helper for generating the calendar data in Android projects using Kotlin and Jetpack Compose.

**With this library you will be able to create a calendar Ui to your liking and with the exact features you want**

![plot](./videos/Default.gif)
![plot](./videos/DefaultRange.gif)

## Features
* **Customizable** UI components for calendars
* Easy handling of date selection and range selection
* Easily extend functionality with custom features
* Helper functions for **generating calendar data**
* Integrates seamlessly with **Jetpack Compose ViewModel**


## Sample project
The GIFs above showcase some examples provided in the sample app, you can download [here](https://github.com/LeoSvjetlicic/CalendarLibrary/archive/refs/heads/main.zip).

To run the project:
* Unzip the file.
* Open the project in Android Studio.
* Sync the Gradle files.
* Run the app on an emulator or device.

View the library's source code [here](https://github.com/LeoSvjetlicic/CalendarLibrary/tree/main/calendarLibrary)

## Setup
To be able to use the library you need to add the following dependency to your project:

```gradle
dependencies {
    implementation("io.github.leosvjetlicic:calendar-library:1.1.0")
}
```

## Usage

The library is separated into **3 main parts**:
* **ViewState**: Defines what the UI will render and what data the helper should output.
* **Helper**: Creates data for the calendar.
* **UI**: Renders the calendar and handles click events.

You can find how to use the library in the documentation links below.

### Examples

* **[Default Calendar Example](https://github.com/LeoSvjetlicic/CalendarLibrary/tree/main/docs/defaultcalendar)**
    * [ViewState](https://github.com/LeoSvjetlicic/CalendarLibrary/tree/main/docs/defaultcalendar/DefaultViewState.md)
    * [Helper](https://github.com/LeoSvjetlicic/CalendarLibrary/tree/main/docs/defaultcalendar/DefaultHelper.md)
    * [UI](https://github.com/LeoSvjetlicic/CalendarLibrary/tree/main/docs/defaultcalendar/DefaultUI.md)
    * [ViewModel](https://github.com/LeoSvjetlicic/CalendarLibrary/tree/main/docs/defaultcalendar/DefaultViewModel.md)

* **[Simple Calendar Example](https://github.com/LeoSvjetlicic/CalendarLibrary/tree/main/docs/simplecalendar)**
    * [ViewState](https://github.com/LeoSvjetlicic/CalendarLibrary/tree/main/docs/simplecalendar/SimpleViewState.md)
    * [Helper](https://github.com/LeoSvjetlicic/CalendarLibrary/tree/main/docs/simplecalendar/SimpleHelper.md)
    * [UI](https://github.com/LeoSvjetlicic/CalendarLibrary/tree/main/docs/simplecalendar/SimpleUI.md)
    * [ViewModel](https://github.com/LeoSvjetlicic/CalendarLibrary/tree/main/docs/simplecalendar/SimpleViewModel.md)
  
* **[Range Calendar Example](https://github.com/LeoSvjetlicic/CalendarLibrary/tree/main/docs/rangecalendar)**
    * [ViewState](https://github.com/LeoSvjetlicic/CalendarLibrary/tree/main/docs/rangecalendar/RangeViewState.md)
    * [Helper](https://github.com/LeoSvjetlicic/CalendarLibrary/tree/main/docs/rangecalendar/RangeHelper.md)
    * [UI](https://github.com/LeoSvjetlicic/CalendarLibrary/tree/main/docs/rangecalendar/RangeUI.md)
    * [ViewModel](https://github.com/LeoSvjetlicic/CalendarLibrary/tree/main/docs/rangecalendar/RangeViewModel.md)

* **[Default Range Calendar Example](https://github.com/LeoSvjetlicic/CalendarLibrary/tree/main/docs/defaultrangecalendar)**
    * [ViewState](https://github.com/LeoSvjetlicic/CalendarLibrary/tree/main/docs/defaultrangecalendar/DefaultRangeViewState.md)
    * [Helper](https://github.com/LeoSvjetlicic/CalendarLibrary/tree/main/docs/defaultrangecalendar/DefaultRangeHelper.md)
    * [UI](https://github.com/LeoSvjetlicic/CalendarLibrary/tree/main/docs/defaultrangecalendar/DefaultRangeUI.md)
    * [ViewModel](https://github.com/LeoSvjetlicic/CalendarLibrary/tree/main/docs/defaultrangecalendar/DefaultRangeViewModel.md)

[//]: # (* **[ViewStateTree]&#40;https://github.com/LeoSvjetlicic/CalendarLibrary/tree/main/docs/viewstates/ViewStateTree.md&#41;**)

## Contribute
If you have any ideas or maybe you found a bug, feel free to send a pull request or [open a issue](https://github.com/LeoSvjetlicic/CalendarLibrary/issues)

## Licence
Calendar library is distributed under the MIT licence. See [LICENCE](https://github.com/LeoSvjetlicic/CalendarLibrary/blob/main/LICENSE) for more.
