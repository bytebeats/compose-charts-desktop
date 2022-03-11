package me.bytebeats.charts.desktop.app.screen.bar

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.bytebeats.charts.desktop.app.ScreenRouter
import me.bytebeats.charts.desktop.app.theme.Margins
import me.bytebeats.charts.desktop.app.theme.Purple500
import me.bytebeats.charts.desktop.bar.BarChar
import me.bytebeats.charts.desktop.bar.render.label.SimpleLabelDrawer
import me.bytebeats.charts.desktop.bar.render.xaxis.SimpleXAxisDrawer
import me.bytebeats.charts.desktop.bar.render.yaxis.SimpleYAxisDrawer

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 21:14
 * @Version 1.0
 * @Description TO-DO
 */

@Composable
fun BarChartScreen() {
    Scaffold(topBar = {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = { ScreenRouter.navigateHome() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Go back home"
                    )
                }
            },
            title = { Text(text = "Bar Chart") },
            backgroundColor = Purple500
        )
    }) {
        BarChartContent()
    }
}

@Composable
private fun BarChartContent() {
    val barChartDataModel = BarChartDataModel()
    Column(
        modifier = Modifier.padding(
            horizontal = Margins.horizontal,
            vertical = Margins.vertical
        )
    ) {
        BarChartRow(barChartDataModel = barChartDataModel)
        DrawLabelLocation(
            barChartDataModel = barChartDataModel,
            newLocation = { barChartDataModel.labelLocation = it })
        AddOrRemoveBar(barChartDataModel = barChartDataModel)
    }
}

@Composable
private fun BarChartRow(barChartDataModel: BarChartDataModel) {
    val labelTextColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .padding(vertical = Margins.verticalLarge)
    ) {
        BarChar(
            barChartData = barChartDataModel.barChartData,
            labelDrawer = barChartDataModel.labelDrawer,
            xAxisDrawer = SimpleXAxisDrawer(axisLineColor = labelTextColor),
            yAxisDrawer = SimpleYAxisDrawer(labelTextColor = labelTextColor, axisLineColor = labelTextColor)
        )
    }
}

@Composable
private fun DrawLabelLocation(
    barChartDataModel: BarChartDataModel,
    newLocation: (SimpleLabelDrawer.DrawLocation) -> Unit
) {
    val labelDrawLocation = remember(barChartDataModel.labelDrawer) {
        barChartDataModel.labelLocation
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = Margins.verticalLarge),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Margins.horizontal, vertical = Margins.vertical)
                .align(Alignment.CenterVertically),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            for (location in SimpleLabelDrawer.DrawLocation.values()) {
                OutlinedButton(
                    onClick = { newLocation(location) },
                    border = ButtonDefaults.outlinedBorder.takeIf { labelDrawLocation == location },
                ) {
                    Text(text = location.name)
                }
            }
        }
    }
}

@Composable
private fun AddOrRemoveBar(barChartDataModel: BarChartDataModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Margins.vertical),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Button(
            onClick = { barChartDataModel.removeBar() },
            enabled = barChartDataModel.bars.size > 1,
            shape = CircleShape
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Remove bar from BarChart"
            )
        }

        Row(
            modifier = Modifier.padding(
                horizontal = Margins.horizontal,
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Bars: ")
            Text(
                text = barChartDataModel.bars.size.toString(),
                style = TextStyle(fontWeight = FontWeight.ExtraBold, fontSize = 18.sp)
            )
        }

        Button(
            onClick = { barChartDataModel.addBar() },
            enabled = barChartDataModel.bars.size < 7,
            shape = CircleShape
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add bar into BarChart"
            )
        }
    }
}