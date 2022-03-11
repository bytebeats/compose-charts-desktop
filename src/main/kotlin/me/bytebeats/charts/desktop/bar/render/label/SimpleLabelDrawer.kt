package me.bytebeats.charts.desktop.bar.render.label

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import org.jetbrains.skia.Font
import org.jetbrains.skia.Paint
import org.jetbrains.skia.TextLine

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 19:34
 * @Version 1.0
 * @Description TO-DO
 */

class SimpleLabelDrawer(
    val drawLocation: DrawLocation = DrawLocation.Inside,
    val labelTextSize: TextUnit = 12.sp,
    val labelTextColor: Color = Color.Black
) : ILabelDrawer {
    private val mLabelTextArea: Float? = null
    private val mPaint by lazy {
        Paint().apply {
            color = labelTextColor.toArgb()
        }
    }
    private val mFont by lazy {
        Font()
    }

    override fun requiredAboveBarHeight(drawScope: DrawScope): Float = when (drawLocation) {
        DrawLocation.Outside -> 3F / 2F * labelTextHeight(drawScope)
        else -> 0F
    }

    override fun requiredXAxisHeight(drawScope: DrawScope): Float = when (drawLocation) {
        DrawLocation.XAxis -> labelTextHeight(drawScope)
        else -> 0F
    }

    override fun drawLabel(
        drawScope: DrawScope,
        canvas: Canvas,
        label: String,
        barArea: Rect,
        xAxisArea: Rect
    ) {
        with(drawScope) {
            val textLine = TextLine.make(label, font(drawScope))
            val xCenter = barArea.left + barArea.width / 2 - textLine.width / 2
            val yCenter = when (drawLocation) {
                DrawLocation.Inside -> (barArea.top + barArea.bottom) / 2
                DrawLocation.Outside -> barArea.top - labelTextSize.toPx() / 2
                DrawLocation.XAxis -> barArea.bottom + labelTextHeight(drawScope)
            }
            canvas.nativeCanvas.drawTextLine(textLine, xCenter, yCenter, mPaint)
        }
    }

    private fun labelTextHeight(drawScope: DrawScope): Float = with(drawScope) {
        mLabelTextArea ?: (1.5F * labelTextSize.toPx())
    }

    private fun font(drawScope: DrawScope): Font = with(drawScope) {
        mFont.apply {
            size = labelTextSize.toPx()
        }
    }

    enum class DrawLocation {
        Inside, Outside, XAxis;
    }
}