package me.bytebeats.charts.desktop.app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 21:04
 * @Version 1.0
 * @Description TO-DO
 */

object ScreenRouter {
    var currentScreen by mutableStateOf(Screen.Home)

    fun navigate(screen: Screen) {
        currentScreen = screen
    }

    fun navigateHome() {
        currentScreen = Screen.Home
    }
}