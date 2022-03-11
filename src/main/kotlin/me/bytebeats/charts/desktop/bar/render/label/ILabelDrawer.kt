package me.bytebeats.charts.desktop.bar.render.label

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 19:33
 * @Version 1.0
 * @Description TO-DO
 */

interface ILabelDrawer {
    fun requiredXAxisHeight(drawScope: DrawScope): Float = 0F
    fun requiredAboveBarHeight(drawScope: DrawScope): Float = 0F
    fun drawLabel(
        drawScope: DrawScope,
        canvas: Canvas,
        label: Any?,
        barArea: Rect,
        xAxisArea: Rect
    )
}