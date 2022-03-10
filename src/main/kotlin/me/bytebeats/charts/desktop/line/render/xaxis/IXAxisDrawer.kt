package me.bytebeats.charts.desktop.line.render.xaxis

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 20:44
 * @Version 1.0
 * @Description TO-DO
 */

interface IXAxisDrawer {
    fun requireHeight(drawScope: DrawScope): Float

    fun drawXAxisLine(drawScope: DrawScope, canvas: Canvas, drawableArea: Rect)

    fun drawXAxisLabels(
        drawScope: DrawScope,
        canvas: Canvas,
        drawableArea: Rect,
        labels: List<String>
    )
}