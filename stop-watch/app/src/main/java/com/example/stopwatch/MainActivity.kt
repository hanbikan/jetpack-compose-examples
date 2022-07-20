package com.example.stopwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.stopwatch.ui.theme.StopWatchTheme
import java.util.*
import kotlin.concurrent.timer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

class MainViewModel: ViewModel() {
    private var time = 0
    private var timerTask: Timer? = null

    private val _isRunning = mutableStateOf(false)
    val isRunning: State<Boolean> = _isRunning

    private val _second = mutableStateOf(0)
    val second: State<Int> = _second

    private val _millisecond = mutableStateOf(0)
    val millisecond: State<Int> = _millisecond

    private val _lapTimes = mutableStateOf(mutableListOf<String>())
    val lapTimes: State<List<String>> = _lapTimes

    private var lapCount = 1

    fun start() {
        _isRunning.value = true

        timerTask = timer(period = 10) {
            time++
            _second.value = time / 1000
            _millisecond.value = time % 1000
        }
    }

    fun pause() {
        _isRunning.value = false
        timerTask?.cancel()
    }

    fun reset() {
        timerTask?.cancel()

        time = 0
        _isRunning.value = false
        _second.value = 0
        _millisecond.value = 0

        _lapTimes.value.clear()
        lapCount = 1
    }

    fun recordLapTime() {
        _lapTimes.value.add(0, "$lapCount LAP : ${second.value}.${millisecond.value}")
        lapCount++
    }
}