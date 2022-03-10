package me.bytebeats.charts.desktop.pie

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 21:00
 * @Version 1.0
 * @Description TO-DO
 */

internal fun calculateAngle(sliceLength: Float, totalLength: Float, progress: Float): Float =
    360F * sliceLength * progress / totalLength