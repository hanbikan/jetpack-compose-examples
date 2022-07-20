package com.example.stopwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

@Composable
fun MainScreen(
    second: Int,
    millisecond: Int,
    isRunning: Boolean,
    lapTimes: List<String>,
    onReset: () -> Unit,
    onToggle: (Boolean) -> Unit,
    onLapTime: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("StopWatch") })
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text("$second", fontSize = 100.sp)
                Text("$millisecond")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                lapTimes.forEach { lapTime ->
                    Text(lapTime)
                }
            }

            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                FloatingActionButton(
                    onClick = onReset,
                    backgroundColor = Color.Red
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_refresh_24),
                        contentDescription = "reset"
                    )
                }

                FloatingActionButton(
                    onClick = { onToggle(isRunning) },
                    backgroundColor = Color.Green
                ) {
                    Image(
                        painter = painterResource(
                            id = if(isRunning) R.drawable.ic_baseline_pause_24
                            else R.drawable.ic_baseline_play_arrow_24
                        ),
                        contentDescription = "toggle"
                    )
                }

                Button(onClick = onLapTime) {
                    Text("랩 타임")
                }
            }
        }
    }
}