package me.bytebeats.charts.desktop.app.screen.line

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.bytebeats.charts.desktop.app.ScreenRouter
import me.bytebeats.charts.desktop.app.theme.Margins
import me.bytebeats.charts.desktop.line.LineChart
import me.bytebeats.charts.desktop.line.render.xaxis.SimpleXAxisDrawer
import me.bytebeats.charts.desktop.line.render.yaxis.SimpleYAxisDrawer

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 21:18
 * @Version 1.0
 * @Description TO-DO
 */

@Composable
fun LineChartScreen() {
    Scaffold(topBar = {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = { ScreenRouter.navigateHome() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Go back home"
                    )
                }
            },
            title = { Text(text = "Line Chart") }
        )
    }) {
        LineChartContent()
    }
}

@Composable
private fun LineChartContent() {
    val lineChartData = LineChartDataModel()

    Column(
        modifier = Modifier.padding(
            horizontal = Margins.horizontal,
            vertical = Margins.vertical
        )
    ) {
        LineChartRow(lineChartDataModel = lineChartData)
        HorizontalOffsetSelector(lineChartDataModel = lineChartData)
        OffsetProgress(lineChartDataModel = lineChartData)
    }
}

@Composable
private fun LineChartRow(lineChartDataModel: LineChartDataModel) {
    val axisLineColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    Box(
        modifier = Modifier
            .height(250.dp)
            .fillMaxSize()
    ) {
        LineChart(
            lineChartData = lineChartDataModel.lineChartData,
            horizontalOffset = lineChartDataModel.horizontalOffset,
            pointDrawer = lineChartDataModel.pointDrawer,
            xAxisDrawer = SimpleXAxisDrawer(labelTextColor = axisLineColor, axisLineColor = axisLineColor),
            yAxisDrawer = SimpleYAxisDrawer(labelTextColor = axisLineColor, axisLineColor = axisLineColor)
        )
    }
}

@Composable
private fun HorizontalOffsetSelector(lineChartDataModel: LineChartDataModel) {
    val pointDrawType = lineChartDataModel.pointDrawerType
    Column(
        modifier = Modifier.padding(horizontal = Margins.horizontal, vertical = Margins.vertical),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Point Drawer")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = Margins.horizontal, vertical = Margins.vertical),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            for (drawerType in PointDrawerType.values()) {
                OutlinedButton(
                    onClick = { lineChartDataModel.pointDrawerType = drawerType },
                    border = ButtonDefaults.outlinedBorder.takeIf { pointDrawType == drawerType },
                ) {
                    Text(text = drawerType.name)
                }
            }
        }
    }
}

@Composable
private fun OffsetProgress(lineChartDataModel: LineChartDataModel) {
    Column(
        modifier = Modifier.padding(horizontal = Margins.horizontal),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Offset")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Margins.horizontal, vertical = Margins.vertical)
                .align(Alignment.CenterHorizontally)
        ) {
            Slider(
                value = lineChartDataModel.horizontalOffset,
                onValueChange = { lineChartDataModel.horizontalOffset = it },
                valueRange = 0F.rangeTo(25F)
            )
        }
    }
}