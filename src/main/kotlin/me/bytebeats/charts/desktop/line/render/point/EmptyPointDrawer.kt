package me.bytebeats.charts.desktop.line.render.point

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 20:42
 * @Version 1.0
 * @Description TO-DO
 */

object EmptyPointDrawer : IPointDrawer {
    override fun drawPoint(drawScope: DrawScope, canvas: Canvas, center: Offset) {
        //empty point, we do nothing here.
    }
}