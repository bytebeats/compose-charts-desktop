# compose-charts-desktop

[![GitHub latest commit](https://badgen.net/github/last-commit/bytebeats/compose-charts-desktop)](https://github.com/bytebeats/compose-charts-desktop/commit/)
[![GitHub contributors](https://img.shields.io/github/contributors/bytebeats/compose-charts-desktop.svg)](https://github.com/bytebeats/compose-charts-desktop/graphs/contributors/)
[![GitHub issues](https://img.shields.io/github/issues/bytebeats/compose-charts-desktop.svg)](https://github.com/bytebeats/compose-charts-desktop/issues/)
[![Open Source? Yes!](https://badgen.net/badge/Open%20Source%20%3F/Yes%21/blue?icon=github)](https://github.com/bytebeats/compose-charts-desktop/)
[![GitHub forks](https://img.shields.io/github/forks/bytebeats/compose-charts-desktop.svg?style=social&label=Fork&maxAge=2592000)](https://github.com/bytebeats/compose-charts-desktop/network/)
[![GitHub stars](https://img.shields.io/github/stars/bytebeats/compose-charts-desktop.svg?style=social&label=Star&maxAge=2592000)](https://github.com/bytebeats/compose-charts-desktop/stargazers/)
[![GitHub watchers](https://img.shields.io/github/watchers/bytebeats/compose-charts-desktop.svg?style=social&label=Watch&maxAge=2592000)](https://github.com/bytebeats/compose-charts-desktop/watchers/)

Simple Compose Charts for multi-platform. Including Android, Web, Desktop.

Compose multiplatform for Android: [compose-charts](https://github.com/bytebeats/compose-charts).

## Graph Effects

<img src="/arts/pie_chart.gif" width="220" height="480"/><img src="/arts/line_chart.gif" width="220" height="480"/><img src="/arts/bar_chart.gif" width="220" height="480"/>

## How to use?

2. show Pie Chart in Compose multiplatform for Desktop:

```
@Composable
fun PieChartView() {
    PieChart(
        pieChartData = PieChartData(
            slices = listOf(
                PieChartData.Slice(
                    randomLength(),
                    randomColor()
                ),
                PieChartData.Slice(randomLength(), randomColor()),
                PieChartData.Slice(randomLength(), randomColor())
            )
        ),
        // Optional properties.
        modifier = Modifier.fillMaxSize(),
        animation = simpleChartAnimation(),
        sliceDrawer = SimpleSliceDrawer()
    )
}
```

3. show Line Chart in Compose multiplatform for Desktop:

```
@Composable
fun LineChartView() {
    LineChart(
        lineChartData = LineChartData(
            points = listOf(
                Point(randomYValue(), "Line 1"),
                Point(randomYValue(), "Line 2"),
                Point(randomYValue(), "Line 3"),
                Point(randomYValue(), "Line 4"),
                Point(randomYValue(), "Line 5"),
                Point(randomYValue(), "Line 6"),
                Point(randomYValue(), "Line 7")
            )
        ),
        // Optional properties.
        modifier = Modifier.fillMaxSize(),
        animation = simpleChartAnimation(),
        pointDrawer = FilledCircularPointDrawer(),
        lineDrawer = SolidLineDrawer(),
        xAxisDrawer = SimpleXAxisDrawer(),
        yAxisDrawer = SimpleYAxisDrawer(),
        horizontalOffset = 5f
    )
}
```

4. show Bar Chart in Compose multiplatform for Desktop:

```
@Composable
fun BarChartView() {
    BarChart(
        barChartData = BarChartData(
            bars = listOf(
                BarChartData.Bar(
                    label = "Bar 1",
                    value = randomValue(),
                    color = randomColor()
                ),
                BarChartData.Bar(
                    label = "Bar 2",
                    value = randomValue(),
                    color = randomColor()
                ),
                BarChartData.Bar(
                    label = "Bar 3",
                    value = randomValue(),
                    color = randomColor()
                ),
                BarChartData.Bar(
                    label = "Bar 4",
                    value = randomValue(),
                    color = randomColor()
                ),
            )
        ),
        // Optional properties.
        modifier = Modifier.fillMaxSize(),
        animation = simpleChartAnimation(),
        barDrawer = SimpleBarDrawer(),
        xAxisDrawer = SimpleXAxisDrawer(),
        yAxisDrawer = SimpleYAxisDrawer(),
        labelDrawer = SimpleLabelDrawer()
    ) 
}
```
## Stargazers over time

[![Stargazers over time](https://starchart.cc/bytebeats/compose-charts-desktop.svg)](https://starchart.cc/bytebeats/compose-charts-desktop)

## Github Stars Sparklines

[![Sparkline](https://stars.medv.io/bytebeats/compose-charts-desktop.svg)](https://stars.medv.io/bytebeats/compose-charts-desktop)

## Contributors

[![Contributors over time](https://contributor-graph-api.apiseven.com/contributors-svg?chart=contributorOverTime&repo=bytebeats/compose-charts-desktop)](https://www.apiseven.com/en/contributor-graph?chart=contributorOverTime&repo=bytebeats/compose-charts-desktop)

## MIT License

    Copyright (c) 2022 Chen Pan

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
