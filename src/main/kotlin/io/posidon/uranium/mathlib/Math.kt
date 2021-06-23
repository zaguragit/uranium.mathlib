package io.posidon.uranium.mathlib

import io.posidon.uranium.mathlib.types.Vec2f
import io.posidon.uranium.mathlib.types.Vec3f
import io.posidon.uranium.mathlib.types.Vec4f

/**
 * @return 1 / sqrt(x) (less precise)
 */
inline fun invSqrt(x: Float): Float {
    val xhalf = 0.5f * x
    var i = x.toRawBits()
    i = 0x5f3759df - (i shr 1)
    var y = Float.fromBits(i)
    y *= 1.5f - xhalf * y * y
    return y
}

inline fun fastSqrt(x: Float): Float = invSqrt(x) * x

fun mix(a: Vec4f, b: Vec4f, ratio: Float): Vec4f {
    val inverseRatio = 1f - ratio
    val x = a.x * inverseRatio + b.x * ratio
    val y = a.y * inverseRatio + b.y * ratio
    val z = a.z * inverseRatio + b.z * ratio
    val w = a.w * inverseRatio + b.w * ratio
    return Vec4f(x, y, z, w)
}

fun mix(a: Vec3f, b: Vec3f, ratio: Float): Vec3f {
    val inverseRatio = 1f - ratio
    val x = a.x * inverseRatio + b.x * ratio
    val y = a.y * inverseRatio + b.y * ratio
    val z = a.z * inverseRatio + b.z * ratio
    return Vec3f(x, y, z)
}

fun mix(a: Vec2f, b: Vec2f, ratio: Float): Vec2f {
    val inverseRatio = 1f - ratio
    val x = a.x * inverseRatio + b.x * ratio
    val y = a.y * inverseRatio + b.y * ratio
    return Vec2f(x, y)
}

fun mix(a: Float, b: Float, ratio: Float): Float {
    val inverseRatio = 1f - ratio
    return a * inverseRatio + b * ratio
}

fun mix(a: Double, b: Double, ratio: Double): Double {
    val inverseRatio = 1f - ratio
    return a * inverseRatio + b * ratio
}

fun clamp(x: Float, min: Float, max: Float): Float = when {
    x < min -> min
    x > max -> max
    else -> x
}

fun clamp(x: Double, min: Double, max: Double): Double = when {
    x < min -> min
    x > max -> max
    else -> x
}