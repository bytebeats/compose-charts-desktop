package me.bytebeats.charts.desktop.app

import androidx.compose.animation.Crossfade
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import me.bytebeats.charts.desktop.app.screen.HomeScreen
import me.bytebeats.charts.desktop.app.screen.bar.BarChartScreen
import me.bytebeats.charts.desktop.app.screen.line.LineChartScreen
import me.bytebeats.charts.desktop.app.screen.pie.PieChartScreen
import me.bytebeats.charts.desktop.app.theme.ComposeChartsTheme

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 21:21
 * @Version 1.0
 * @Description TO-DO
 */

@Composable
fun ComposeCharts() {
    ComposeChartsTheme {
        ComposeChartsContent()
    }
}

@Composable
private fun ComposeChartsContent() {
    Crossfade(targetState = ScreenRouter.currentScreen) { screen ->
        Surface(color = MaterialTheme.colors.background) {
            when (screen) {
                Screen.Pie -> PieChartScreen()
                Screen.Line -> LineChartScreen()
                Screen.Bar -> BarChartScreen()
                else -> HomeScreen()
            }
        }
    }
}