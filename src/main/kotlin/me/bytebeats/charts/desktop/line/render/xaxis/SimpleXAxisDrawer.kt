package me.bytebeats.charts.desktop.line.render.xaxis

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.bytebeats.charts.desktop.AxisLabelFormatter
import org.jetbrains.skia.TextLine

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 20:45
 * @Version 1.0
 * @Description TO-DO
 */

class SimpleXAxisDrawer(
    val labelTextSize: TextUnit = 12.sp,
    val labelTextColor: Color = Color.Black,
    val drawLabelEvery: Int = 1,// draw label text every $drawLabelEvery, like 1, 2, 3 and so on.
    val axisLineThickness: Dp = 1.dp,
    val axisLineColor: Color = Color.Black,
    val axisLabelFormatter: AxisLabelFormatter = { value -> "$value" }
) : IXAxisDrawer {
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

    private val mTextFont by lazy {
        org.jetbrains.skia.Font()
    }

    override fun requireHeight(drawScope: DrawScope): Float = with(drawScope) {
        1.5F * (labelTextSize.toPx() + axisLineThickness.toPx())
    }

    override fun drawXAxisLine(drawScope: DrawScope, canvas: Canvas, drawableArea: Rect) {
        with(drawScope) {
            val lineThickness = axisLineThickness.toPx()
            val y = drawableArea.top + lineThickness / 2F

            canvas.drawLine(
                p1 = Offset(x = drawableArea.left, y = y),
                p2 = Offset(x = drawableArea.right, y = y),
                paint = mAxisLinePaint.apply { strokeWidth = lineThickness })
        }
    }

    override fun drawXAxisLabels(
        drawScope: DrawScope,
        canvas: Canvas,
        drawableArea: Rect,
        labels: List<*>
    ) {
        with(drawScope) {
            val labelPaint = mTextPaint
            val labelFont = mTextFont.apply {
                size = labelTextSize.toPx()
            }
            val labelIncrements = drawableArea.width / (labels.size - 1)
            labels.forEachIndexed { index, label ->
                if (index.rem(drawLabelEvery) == 0) {
                    val labelValue = axisLabelFormatter(label)
                    val textLine = TextLine.make(labelValue, labelFont)
                    val x = drawableArea.left + labelIncrements * index - textLine.width / 2
                    val y = drawableArea.bottom
                    canvas.nativeCanvas.drawTextLine(textLine, x, y, labelPaint)
                }
            }
        }
    }
}