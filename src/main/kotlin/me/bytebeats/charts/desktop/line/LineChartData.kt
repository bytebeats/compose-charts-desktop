package me.bytebeats.charts.desktop.line

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 20:27
 * @Version 1.0
 * @Description TO-DO
 */

data class LineChartData(
    val points: List<Point>,
    val padBy: Float = 20F,//percentage we pad yValue by
    val startAtZero: Boolean = false
) {
    init {
        require(padBy in 0F..100F) {
            "padBy must be between 0F and 100F, included"
        }
    }

    private val yMinMaxValues: Pair<Float, Float>
        get() {
            val minValue = points.minOf { it.value }
            val maxValue = points.maxOf { it.value }
            return minValue to maxValue
        }

    internal val maxY: Float
        get() = yMinMaxValues.second + (yMinMaxValues.second - yMinMaxValues.first) * padBy / 100F
    internal val minY: Float
        get() = if (startAtZero) 0F else yMinMaxValues.first - (yMinMaxValues.second - yMinMaxValues.first) * padBy / 100F

    internal val yRange: Float
        get() = maxY - minY

    data class Point(val value: Float, val label: String)
}