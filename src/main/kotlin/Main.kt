// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import me.bytebeats.charts.desktop.app.ComposeCharts

@Composable
@Preview
fun App() {

    MaterialTheme {
        ComposeCharts()
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Compose Charts for Desktop",
        state = rememberWindowState(width = 400.dp, height = 600.dp)
    ) {
        App()
    }
}
