package me.bytebeats.charts.desktop.line.render.yaxis

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 20:48
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