package com.example.library

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.library.ui.theme.LibraryTheme
import com.example.library.ui.theme.Pink40
import sample.example.app.guide.ui.DefaultCalendarDay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LibraryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        DefaultCalendarDay(
                            value = 13,
                            isSelected = false,
                            hasIndicator = true,
                            backgroundColor = Color.Yellow,
                            indicatorModifier = Modifier
                                .width(10.dp)
                                .height(3.dp)
                                .clip(
                                    RoundedCornerShape(10.dp)
                                )
                                .background(Pink40)
                        ) {}
                    }
                }
            }
        }
    }
}
