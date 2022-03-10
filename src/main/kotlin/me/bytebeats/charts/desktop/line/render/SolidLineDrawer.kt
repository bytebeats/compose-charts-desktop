package me.bytebeats.charts.desktop.line.render

import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 20:39
 * @Version 1.0
 * @Description TO-DO
 */

class SolidLineDrawer(val thickness: Dp = 3.dp, val color: Color = Color.Cyan) : ILineDrawer {
    private val mPaint by lazy {
        Paint().apply {
            color = this@SolidLineDrawer.color
            style = PaintingStyle.Stroke
            isAntiAlias = true
        }
    }

    override fun drawLine(drawScope: DrawScope, canvas: Canvas, linePath: Path) {
        val lineThickness = with(drawScope) {
            thickness.toPx()
        }
        canvas.drawPath(path = linePath, paint = mPaint.apply { strokeWidth = lineThickness })
    }
}