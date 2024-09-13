package cromega.studio.library

import kotlin.math.sqrt

/**
 * Simple utility function used to calculate the height of the equilateral triangles
 *
 * @param triangleSideSize [Float] value that represent the length of the sides of the triangle
 *
 * @return [Double] value that represent the height of the equilateral triangle
 */
fun calculateEquilateralTriangleHeight(
    triangleSideSize: Float
) : Double =
    ((sqrt(3.0) * triangleSideSize) / 2)