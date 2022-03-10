package me.bytebeats.charts.desktop.bar.render

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope
import me.bytebeats.charts.desktop.bar.BarChartData

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 19:31
 * @Version 1.0
 * @Description TO-DO
 */

interface IBarDrawer {
    fun drawBar(drawScope: DrawScope, canvas: Canvas, barArea: Rect, bar: BarChartData.Bar)
}