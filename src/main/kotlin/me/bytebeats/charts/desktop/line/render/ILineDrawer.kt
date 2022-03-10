package me.bytebeats.charts.desktop.line.render

import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 20:37
 * @Version 1.0
 * @Description TO-DO
 */

interface ILineDrawer {
    fun drawLine(drawScope: DrawScope, canvas: Canvas, linePath: Path)
}