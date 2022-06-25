package com.example.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basic.ui.theme.JetpackBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(modifier = Modifier
                .background(color = Color.Green)
                .fillMaxWidth()
                .height(200.dp)
            ) {
                Text(text = "Hello World!")
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Text(text = "Hi")
                }
            }
        }
    }
}
