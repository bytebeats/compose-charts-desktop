package me.bytebeats.charts.desktop.pie

import androidx.compose.ui.graphics.Color

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 20:58
 * @Version 1.0
 * @Description TO-DO
 */

data class PieChartData(val slices: List<Slice>) {
    internal val totalLength: Float
        get() {
            return slices.map { it.value }.sum()
        }

    data class Slice(val value: Float, val color: Color)
}