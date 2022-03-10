package me.bytebeats.charts.desktop.bar.render.yaxis

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.bytebeats.charts.desktop.LabelFormatter
import org.jetbrains.skia.Font
import kotlin.math.roundToInt

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 20:12
 * @Version 1.0
 * @Description TO-DO
 */

class SimpleYAxisDrawer(
    private val labelTextSize: TextUnit = 12.sp,
    private val labelTextColor: Color = Color.Black,
    private val drawLabelEvery: Int = 3,
    private val labelValueFormatter: LabelFormatter = { value ->
        "%.1f".format(value)
    },
    private val axisLineThickness: Dp = 1.dp,
    private val axisLineColor: Color = Color.Black
) : IYAxisDrawer {

    private val mAxisLinePaint by lazy {
        Paint().apply {
            isAntiAlias = true
            color = axisLineColor
            style = PaintingStyle.Stroke
        }
    }

    private val mTextPaint by lazy {
        org.jetbrains.skia.Paint().apply {
            isAntiAlias = true
            color = labelTextColor.toArgb()
        }
    }

    private val mTextFont by lazy { Font() }

    override fun drawAxisLine(drawScope: DrawScope, canvas: Canvas, drawableArea: Rect) {
        with(drawScope) {
            val lineThickness = axisLineThickness.toPx()
            val x = drawableArea.right - lineThickness / 2F
            canvas.drawLine(
                p1 = Offset(x = x, y = drawableArea.top),
                p2 = Offset(x = x, y = drawableArea.bottom),
                paint = mAxisLinePaint.apply { strokeWidth = lineThickness }
            )
        }
    }

    override fun drawAxisLabels(
        drawScope: DrawScope,
        canvas: Canvas,
        drawableArea: Rect,
        minValue: Float,
        maxValue: Float
    ) {
        with(drawScope) {
            val labelPaint = mTextPaint.apply {
//                textAlign = android.graphics.Paint.Align.RIGHT
            }
            val labelFont = mTextFont.apply {
                size = labelTextSize.toPx()
            }
            val minLabelHeight = labelTextSize.toPx() * drawLabelEvery.toFloat()
            val totalHeight = drawableArea.height
            val labelCount = (drawableArea.height / minLabelHeight).roundToInt().coerceAtLeast(2)
            for (i in 0..labelCount) {
                val value = minValue + i * (maxValue - minValue) / labelCount
                val label = labelValueFormatter(value)
                val x = drawableArea.right - axisLineThickness.toPx() - labelTextSize.toPx() / 2F
                val rect = labelFont.measureText(label, labelPaint)
                val y = drawableArea.bottom - i * (totalHeight / labelCount) + rect.height / 2F
                canvas.nativeCanvas.drawString(label, x, y, labelFont, labelPaint)
            }
        }
    }
}