package me.bytebeats.charts.desktop.line.render.point

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 20:42
 * @Version 1.0
 * @Description TO-DO
 */

class FilledCircularPointDrawer(val diameter: Dp = 8.dp, val color: Color = Color.Blue) :
        IPointDrawer {

    private val mPaint by lazy {
        Paint().apply {
            color = this@FilledCircularPointDrawer.color
            style = PaintingStyle.Fill
            isAntiAlias = true
        }
    }

    override fun drawPoint(drawScope: DrawScope, canvas: Canvas, center: Offset) {
        with(drawScope as Density) {
            canvas.drawCircle(center, diameter.toPx() / 2F, paint = mPaint)
        }
    }
}