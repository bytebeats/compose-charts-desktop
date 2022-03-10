package me.bytebeats.charts.desktop.bar

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import me.bytebeats.charts.desktop.bar.render.IBarDrawer
import me.bytebeats.charts.desktop.bar.render.SimpleBarDrawer
import me.bytebeats.charts.desktop.bar.render.label.ILabelDrawer
import me.bytebeats.charts.desktop.bar.render.label.SimpleLabelDrawer
import me.bytebeats.charts.desktop.bar.render.xaxis.IXAxisDrawer
import me.bytebeats.charts.desktop.bar.render.xaxis.SimpleXAxisDrawer
import me.bytebeats.charts.desktop.bar.render.yaxis.IYAxisDrawer
import me.bytebeats.charts.desktop.bar.render.yaxis.SimpleYAxisDrawer
import me.bytebeats.charts.desktop.simpleChartAnimation

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 20:23
 * @Version 1.0
 * @Description TO-DO
 */

@Composable
fun BarChar(
    barChartData: BarChartData,
    modifier: Modifier = Modifier,
    animation: AnimationSpec<Float> = simpleChartAnimation(),
    barDrawer: IBarDrawer = SimpleBarDrawer(),
    xAxisDrawer: IXAxisDrawer = SimpleXAxisDrawer(),
    yAxisDrawer: IYAxisDrawer = SimpleYAxisDrawer(),
    labelDrawer: ILabelDrawer = SimpleLabelDrawer()
) {
    val transitionAnimation = remember(barChartData.bars) { Animatable(initialValue = 0F) }

    LaunchedEffect(barChartData.bars) {
        transitionAnimation.animateTo(1F, animationSpec = animation)
    }

    val progress = transitionAnimation.value
    Canvas(modifier = modifier.fillMaxSize().drawBehind {
        drawIntoCanvas { canvas ->
            val (xAxisArea, yAxisArea) = axisAreas(
                drawScope = this,
                totalSize = size,
                xAxisDrawer = xAxisDrawer,
                labelDrawer = labelDrawer
            )

            val barDrawableArea = barDrawableArea(xAxisArea)

            yAxisDrawer.drawAxisLine(drawScope = this, canvas = canvas, drawableArea = yAxisArea)

            xAxisDrawer.drawXAxisLine(drawScope = this, canvas = canvas, drawableArea = xAxisArea)

            barChartData.forEachWithArea(
                this,
                barDrawableArea,
                progress,
                labelDrawer
            ) { barArea, bar ->
                barDrawer.drawBar(drawScope = this, canvas, barArea, bar)
            }
        }
    }) {

        drawIntoCanvas { canvas ->
            val (xAxisArea, yAxisArea) = axisAreas(
                drawScope = this,
                totalSize = size,
                xAxisDrawer = xAxisDrawer,
                labelDrawer = labelDrawer
            )
            val barDrawableArea = barDrawableArea(xAxisArea)

            barChartData.forEachWithArea(
                this,
                barDrawableArea,
                progress,
                labelDrawer
            ) { barArea, bar ->
                labelDrawer.drawLabel(
                    drawScope = this,
                    canvas = canvas,
                    label = bar.label,
                    barArea = barArea,
                    xAxisArea = xAxisArea
                )
            }

            yAxisDrawer.drawAxisLabels(
                drawScope = this,
                canvas = canvas,
                minValue = barChartData.minY,
                maxValue = barChartData.maxY,
                drawableArea = yAxisArea
            )
        }
    }
}