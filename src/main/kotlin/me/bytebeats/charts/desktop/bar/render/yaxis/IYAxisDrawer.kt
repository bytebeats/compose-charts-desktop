package me.bytebeats.charts.desktop.bar.render.yaxis

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 20:11
 * @Version 1.0
 * @Description TO-DO
 */

interface IYAxisDrawer {
    fun drawAxisLine(drawScope: DrawScope, canvas: Canvas, drawableArea: Rect)

    fun drawAxisLabels(
        drawScope: DrawScope,
        canvas: Canvas,
        drawableArea: Rect,
        minValue: Float,
        maxValue: Float
    )
}