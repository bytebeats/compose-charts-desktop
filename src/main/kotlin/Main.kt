// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import me.bytebeats.charts.desktop.app.ComposeCharts
import java.awt.FileDialog
import java.awt.Frame

@Composable
@Preview
fun App() {
    MaterialTheme {
        ComposeCharts()
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Compose Charts for Desktop",
        state = rememberWindowState(width = 400.dp, height = 600.dp)
    ) {
        var isFileChooserOpen by remember { mutableStateOf(true) }
        MenuBar {
            Menu("File") {
                Item("New Window") { }
                Item("New Tab") { }
                Separator()
                Item("Close Window") { }
                Item("Close Tab") { }
                Separator()
                Item("Quit") { }
            }
            Menu("Settings") {
                Item("Active Tool Window") { }
                Item("Editor Tabs") { }
                Item("Notifications") { }
                Item("Background Tasks") { }
                Separator()
                Item("Choose File") {
//                    if (isFileChooserOpen) {
//                        FileDialog(onCloseRequest = {
//                            isFileChooserOpen = false
//                            println("Chosen $it")
//                        })
//                    }
                }
            }
        }
        App()
    }
}

@Composable
private fun FileDialog(parent: Frame? = null, onCloseRequest: (result: String?) -> Unit) =
    AwtWindow(create = {
        object : FileDialog(parent, "Choose a File", LOAD) {
            override fun setVisible(b: Boolean) {
                super.setVisible(b)
                if (b) {
                    onCloseRequest(file)
                }
            }
        }
    }, dispose = FileDialog::dispose)
