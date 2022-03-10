package me.bytebeats.charts.desktop.line.render

import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 20:36
 * @Version 1.0
 * @Description TO-DO
 */

interface ILineShader {
    fun fillLine(drawScope: DrawScope, canvas: Canvas, fillPath: Path)
}