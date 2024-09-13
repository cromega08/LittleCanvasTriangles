package cromega.studio.little.canvas.triangles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cromega.studio.library.drawTriangle
import cromega.studio.library.drawTriangleDownwards
import cromega.studio.library.drawTriangleLeftwards
import cromega.studio.library.drawTriangleRightwards
import cromega.studio.library.drawTriangleUpwards
import cromega.studio.little.canvas.triangles.ui.theme.LittleCanvasTrianglesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LittleCanvasTrianglesTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding -> TestingCanvas(paddingValues = innerPadding) }
            }
        }
    }
}

@Composable
fun TestingCanvas(
    modifier: Modifier = Modifier,
    paddingValues:  PaddingValues = PaddingValues()
) =
    Canvas(
        modifier = modifier.fillMaxSize().padding(paddingValues = paddingValues)
    ) {
        val triangleSideSize: Float = 100.dp.toPx()

        drawTriangleRightwards(triangleSideSize = triangleSideSize)

        drawTriangleDownwards(
            triangleSideSize = triangleSideSize,
            startX = (size.width - triangleSideSize)
        )

        drawTriangleLeftwards(
            triangleSideSize = triangleSideSize,
            startX = size.width,
            startY = (size.height - triangleSideSize)
        )

        drawTriangleUpwards(
            triangleSideSize = triangleSideSize,
            startY = size.height
        )

        drawTriangle(
            startingPoint = ((size.width / 2) - (triangleSideSize / 2)) to ((size.height / 2) + (triangleSideSize / 2)),
            secondPoint = ((size.width / 2) + triangleSideSize) to ((size.height / 2) + (triangleSideSize / 3)),
            thirdPoint = (size.width / 2) to (size.height / 2)
        )
    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() { LittleCanvasTrianglesTheme { TestingCanvas() } }