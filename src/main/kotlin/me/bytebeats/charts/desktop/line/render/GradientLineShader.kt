package me.bytebeats.charts.desktop.line.render

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 20:38
 * @Version 1.0
 * @Description TO-DO
 */

data class GradientLineShader(val colors: List<Color> = listOf(Color.Blue, Color.Transparent)) :
        ILineShader {

    private val mBrush = Brush.verticalGradient(colors)

    override fun fillLine(drawScope: DrawScope, canvas: Canvas, fillPath: Path) {
        drawScope.drawPath(path = fillPath, brush = mBrush)
    }
}