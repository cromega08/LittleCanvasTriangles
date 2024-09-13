package cromega.studio.library

import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * Extension member function used to create a custom triangle inside a [Canvas] with the coordinates given.
 * All the [Pair] params receive the coordinates with (x, y) configuration inside the [Canvas], knowing that
 * [Canvas] coordinates increase to RIGHT(x) and BELOW(y).
 *
 * @param startingPoint [Pair]<[Float], [Float]> argument that represents the coordinates (x, y) of the starting
 * and closing point of the triangle.
 *
 * @param secondPoint [Pair]<[Float], [Float]> argument that represents the coordinates (x, y) of the
 * second denoted point of the triangle.
 *
 * @param thirdPoint [Pair]<[Float], [Float]> argument that represents the coordinates (x, y) of the
 * last denoted point before returning to the [startingPoint] and closing the triangle.
 *
 * @param color [Color] argument used to determine the color to fill the triangle.
 */
fun DrawScope.drawTriangle(
    startingPoint: Pair<Float, Float>,
    secondPoint: Pair<Float, Float>,
    thirdPoint: Pair<Float, Float>,
    color: Color = Color.Black
) {
    drawPath(
        path =
        Path()
            .apply {
                moveTo(startingPoint.first, startingPoint.second)
                lineTo(secondPoint.first, secondPoint.second)
                lineTo(thirdPoint.first, thirdPoint.second)
                close()
            },
        color = color
    )
}

/**
 * Extension member function used to draw an equilateral triangle inside a [Canvas] pointing upwards.
 * Knowing that [Canvas] coordinates increase to RIGHT(x) and BELOW(y), the triangle is drawn to the RIGHT(x)
 * and UP(y), so it is important to have enough the space UPSIDE(y) from the [startY] coordinate.
 *
 * @param triangleSideSize [Float] value that the represent the size of all the sides of the equilateral triangle.
 *
 * @param startX [Float] value that represents the starting point for drawing the triangle in the (x) coordinate.
 * The triangle is going to be draw rightwards from this coordinate.
 *
 * @param startY [Float] value that represents the starting point for drawing the triangle in the (y) coordinate.
 * The triangle is going to be draw upwards from this coordinate.
 *
 * @param color [Color] argument used to determine the color to fill the triangle.
 */
fun DrawScope.drawTriangleUpwards(triangleSideSize: Float, startX: Float = 0f, startY: Float = 0f, color: Color = Color.Black)
{
    val triangleHeight = calculateEquilateralTriangleHeight(triangleSideSize)

    drawTriangle(
        startingPoint = startX to startY,
        secondPoint = (startX + triangleSideSize) to startY,
        thirdPoint = (startX + (triangleSideSize / 2)) to (startY - triangleHeight).toFloat(),
        color = color
    )
}

/**
 * Extension member function used to draw an equilateral triangle inside a [Canvas] pointing downwards.
 * Knowing that [Canvas] coordinates increase to RIGHT(x) and BELOW(y), the triangle is drawn to the RIGHT(x)
 * and DOWN(y), following the [Canvas] increasing direction.
 *
 * @param triangleSideSize [Float] value that the represent the size of all the sides of the equilateral triangle.
 *
 * @param startX [Float] value that represents the starting point for drawing the triangle in the (x) coordinate.
 * The triangle is going to be draw rightwards from this coordinate.
 *
 * @param startY [Float] value that represents the starting point for drawing the triangle in the (y) coordinate.
 * The triangle is going to be draw downwards from this coordinate.
 *
 * @param color [Color] argument used to determine the color to fill the triangle.
 */
fun DrawScope.drawTriangleDownwards(triangleSideSize: Float, startX: Float = 0f, startY: Float = 0f, color: Color = Color.Black)
{
    val triangleHeight = calculateEquilateralTriangleHeight(triangleSideSize)

    drawTriangle(
        startingPoint = startX to startY,
        secondPoint = (startX + triangleSideSize) to startY,
        thirdPoint = (startX + (triangleSideSize / 2)) to (startY + triangleHeight).toFloat(),
        color = color
    )
}

/**
 * Extension member function used to draw an equilateral triangle inside a [Canvas] pointing leftwards.
 * Knowing that [Canvas] coordinates increase to RIGHT(x) and BELOW(y), the triangle is drawn to the LEFT(x)
 * and BELOW(y), so it is important to have enough the space at the LEFT(x) from the [startX] and BELOW(y) from the [startY] coordinates.
 *
 * @param triangleSideSize [Float] value that the represent the size of all the sides of the equilateral triangle.
 *
 * @param startX [Float] value that represents the starting point for drawing the triangle in the (x) coordinate.
 * The triangle is going to be draw leftwards from this coordinate.
 *
 * @param startY [Float] value that represents the starting point for drawing the triangle in the (y) coordinate.
 * The triangle is going to be draw downwards from this coordinate.
 *
 * @param color [Color] argument used to determine the color to fill the triangle.
 */
fun DrawScope.drawTriangleLeftwards(triangleSideSize: Float, startX: Float = 0f, startY: Float = 0f, color: Color = Color.Black)
{
    val triangleHeight = calculateEquilateralTriangleHeight(triangleSideSize)

    drawTriangle(
        startingPoint = startX to startY,
        secondPoint = startX to (startY + triangleSideSize),
        thirdPoint = (startX - triangleHeight).toFloat() to (startY + (triangleSideSize / 2)),
        color = color
    )
}

/**
 * Extension member function used to draw an equilateral triangle inside a [Canvas] pointing rightwards.
 * Knowing that [Canvas] coordinates increase to RIGHT(x) and BELOW(y), the triangle is drawn to the RIGHT(x)
 * and BELOW(y), following the [Canvas] increasing direction.
 *
 * @param triangleSideSize [Float] value that the represent the size of all the sides of the equilateral triangle.
 *
 * @param startX [Float] value that represents the starting point for drawing the triangle in the (x) coordinate.
 * The triangle is going to be draw rightwards from this coordinate.
 *
 * @param startY [Float] value that represents the starting point for drawing the triangle in the (y) coordinate.
 * The triangle is going to be draw downwards from this coordinate.
 *
 * @param color [Color] argument used to determine the color to fill the triangle.
 */
fun DrawScope.drawTriangleRightwards(triangleSideSize: Float, startX: Float = 0f, startY: Float = 0f, color: Color = Color.Black)
{
    val triangleHeight = calculateEquilateralTriangleHeight(triangleSideSize)

    drawTriangle(
        startingPoint = startX to startY,
        secondPoint = startX to (startY + triangleSideSize),
        thirdPoint = (startX + triangleHeight).toFloat() to (startY + (triangleSideSize / 2)),
        color = color
    )
}
