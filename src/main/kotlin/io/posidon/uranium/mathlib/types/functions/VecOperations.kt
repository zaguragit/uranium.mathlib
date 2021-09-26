package io.posidon.uranium.mathlib.types.functions

import io.posidon.uranium.mathlib.types.*
import kotlin.math.*

inline val Vec2f.length get() = sqrt(x * x + y * y)
inline val Vec2i.length get() = sqrt(x.toDouble() * x + y * y)
inline val Vec3f.length get() = sqrt(x * x + y * y + (z * z).toDouble()).toFloat()
inline val Vec3i.length get() = sqrt(x * x + y * y + (z * z).toDouble()).toFloat()
inline val Vec4f.length get() = sqrt(x * x + y * y + (z * z).toDouble()).toFloat()

inline val Vec2f.isZero get() = x == 0f && y == 0f
inline val Vec2i.isZero get() = x == 0 && y == 0
inline val Vec3f.isZero get() = x == 0f && y == 0f && z == 0f
inline val Vec3i.isZero get() = x == 0 && y == 0 && z == 0
inline val Vec4f.isZero get() = x == 0f && y == 0f && z == 0f && w == 0f

inline operator fun Vec2f.plus(v: Vec2f) = v2(x + v.x, y + v.y)
inline operator fun Vec2i.plus(v: Vec2i) = v2(x + v.x, y + v.y)
inline operator fun Vec3f.plus(v: Vec3f) = v3(x + v.x, y + v.y, z + v.z)
inline operator fun Vec3i.plus(v: Vec3i) = v3(x + v.x, y + v.y, z + v.z)
inline operator fun Vec4f.plus(v: Vec4f) = Vec4f(x + v.x, y + v.y, z + v.z, w + v.w)

inline operator fun Vec2f.minus(v: Vec2f) = v2(x - v.x, y - v.y)
inline operator fun Vec2i.minus(v: Vec2i) = v2(x - v.x, y - v.y)
inline operator fun Vec3f.minus(v: Vec3f) = v3(x - v.x, y - v.y, z - v.z)
inline operator fun Vec3i.minus(v: Vec3i) = v3(x - v.x, y - v.y, z - v.z)
inline operator fun Vec4f.minus(v: Vec4f) = Vec4f(x - v.x, y - v.y, z - v.z, w - v.w)

inline operator fun Vec2f.times(v: Vec2f) = v2(x * v.x, y * v.y)
inline operator fun Vec2i.times(v: Vec2i) = v2(x * v.x, y * v.y)
inline operator fun Vec3f.times(v: Vec3f) = v3(x * v.x, y * v.y, z * v.z)
inline operator fun Vec3f.times(v: Vec3i) = v3(x * v.x, y * v.y, z * v.z)
inline operator fun Vec4f.times(v: Vec4f) = Vec4f(x * v.x, y * v.y, z * v.z, w * v.w)

inline operator fun Vec2f.times(v: Float) = v2(x * v, y * v)
inline operator fun Vec2i.times(v: Int) = v2(x * v, y * v)
inline operator fun Vec3f.times(v: Float) = v3(x * v, y * v, z * v)
inline operator fun Vec3f.times(v: Int) = v3(x * v, y * v, z * v)
inline operator fun Vec3i.times(v: Vec3f) = v3(x * v.x, y * v.y, z * v.z)
inline operator fun Vec3i.times(v: Vec3i) = v3(x * v.x, y * v.y, z * v.z)
inline operator fun Vec3i.times(v: Float) = v3(x * v, y * v, z * v)
inline operator fun Vec3i.times(v: Int) = v3(x * v, y * v, z * v)
inline operator fun Vec4f.times(v: Float) = Vec4f(x * v, y * v, z * v, w * v)
inline operator fun Vec4f.times(v: Int) = Vec4f(x * v, y * v, z * v, w * v)

inline operator fun Vec2f.div(v: Vec2f) = v2(x / v.x, y / v.y)
inline operator fun Vec2i.div(v: Vec2i) = v2(x / v.x, y / v.y)
inline operator fun Vec2i.div(v: Vec2f) = v2(x / v.x, y / v.y)
inline operator fun Vec3f.div(v: Vec3f) = v3(x / v.x, y / v.y, z / v.z)
inline operator fun Vec3f.div(v: Vec3i) = v3(x / v.x, y / v.y, z / v.z)
inline operator fun Vec3i.div(v: Vec3f) = v3(x / v.x, y / v.y, z / v.z)
inline operator fun Vec3i.div(v: Vec3i) = v3(x / v.x, y / v.y, z / v.z)

inline operator fun Vec2f.div(v: Float) = v2(x / v, y / v)
inline operator fun Vec2f.div(v: Int) = v2(x / v, y / v)
inline operator fun Vec2i.div(v: Float) = v2(x / v, y / v)
inline operator fun Vec2i.div(v: Int) = v2(x / v, y / v)
inline operator fun Vec3f.div(v: Float) = v3(x / v, y / v, z / v)
inline operator fun Vec3f.div(v: Int) = v3(x / v, y / v, z / v)
inline operator fun Vec3i.div(v: Float) = v3(x / v, y / v, z / v)
inline operator fun Vec3i.div(v: Int) = v3(x / v, y / v, z / v)
inline operator fun Vec4f.div(v: Vec4f) = Vec4f(x / v.x, y / v.y, z / v.z, w / v.w)
inline operator fun Vec4f.div(v: Float) = Vec4f(x / v, y / v, z / v, w / v)

inline operator fun Vec2f.rem(v: Int) = v2(x % v, y % v)
inline operator fun Vec2i.rem(v: Int) = v2(x % v, y % v)
inline operator fun Vec3f.rem(v: Int) = v3(x % v, y % v, z % v)
inline operator fun Vec3i.rem(v: Int) = v3(x % v, y % v, z % v)

inline operator fun Vec2f.unaryMinus() = v2(-x, -y)
inline operator fun Vec2i.unaryMinus() = v2(-x, -y)
inline operator fun Vec3f.unaryMinus() = v3(-x, -y, -z)
inline operator fun Vec3i.unaryMinus() = v3(-x, -y, -z)

inline fun Vec2f.normalized() = if (isZero) v2(0f) else this / length
inline fun Vec3f.normalized() = if (isZero) v3(0f) else this / length
inline fun Vec4f.normalized() = if (isZero) v4(0f) else this / length

inline infix fun Vec2f.dot(v: Vec2f) = x * v.x + y * v.y
inline infix fun Vec2i.dot(v: Vec2i) = x * v.x + y * v.y
inline infix fun Vec3f.dot(v: Vec3f) = x * v.x + y * v.y + z * v.z
inline infix fun Vec3i.dot(v: Vec3i) = x * v.x + y * v.y + z * v.z
inline infix fun Vec4f.dot(v: Vec4f) = x * v.x + y * v.y + z * v.z + w * v.w

inline infix fun Vec3f.cross(v: Vec3f) = v3(y * v.z - z * v.y, z * v.x - x * v.z, x * v.y - y * v.x)
inline infix fun Vec3i.cross(v: Vec3i) = v3(y * v.z - z * v.y, z * v.x - x * v.z, x * v.y - y * v.x)






inline fun Vec2i.selfAdd(v: Vec2i) = set(x + v.x, y + v.y).let { this }
inline fun Vec2i.selfSubtract(v: Vec2i) = set(x - v.x, y - v.y).let { this }

inline fun Vec2i.selfMultiply(v: Vec2i) = set(x * v.x, y * v.y).let { this }
inline fun Vec2i.selfMultiply(v: Int) = set(x * v, y * v).let { this }

inline fun Vec2i.selfDivide(v: Vec2i) = set(x / v.x, y / v.y).let { this }
inline fun Vec2i.selfDivide(v: Int) = set(x / v, y / v).let { this }


inline fun Vec2f.selfAdd(v: Vec2f) = set(x + v.x, y + v.y).let { this }
inline fun Vec2f.selfSubtract(v: Vec2f) = set(x - v.x, y - v.y).let { this }

inline fun Vec2f.selfMultiply(v: Vec2f) = set(x * v.x, y * v.y).let { this }
inline fun Vec2f.selfMultiply(v: Vec2i) = set(x * v.x, y * v.y).let { this }
inline fun Vec2f.selfMultiply(v: Float) = set(x * v, y * v).let { this }
inline fun Vec2f.selfMultiply(v: Int) = set(x * v, y * v).let { this }

inline fun Vec2f.selfDivide(v: Vec2f) = set(x / v.x, y / v.y).let { this }
inline fun Vec2f.selfDivide(v: Float) = set(x / v, y / v).let { this }

inline fun Vec2f.selfNormalize() = if (isZero) set(0f, 0f) else selfDivide(length)

inline fun Vec2f.selfMix(v: Vec2f, ratio: Float): Vec2f {
    val inverseRatio = 1f - ratio
    x = x * inverseRatio + v.x * ratio
    y = y * inverseRatio + v.y * ratio
    return this
}

inline fun Vec3f.selfAdd(v: Vec3f) = set(x + v.x, y + v.y, z + v.z).let { this }
inline fun Vec3f.selfSubtract(v: Vec3f) = set(x - v.x, y - v.y, z - v.z).let { this }

inline fun Vec3f.selfMultiply(v: Vec3f) = set(x * v.x, y * v.y, z * v.z).let { this }
inline fun Vec3f.selfMultiply(v: Vec3i) = set(x * v.x, y * v.y, z * v.z).let { this }
inline fun Vec3f.selfMultiply(v: Float) = set(x * v, y * v, z * v).let { this }
inline fun Vec3f.selfMultiply(v: Int) = set(x * v, y * v, z * v).let { this }

inline fun Vec3f.selfDivide(v: Vec3f) = set(x / v.x, y / v.y, z / v.z).let { this }
inline fun Vec3f.selfDivide(v: Vec3i) = set(x / v.x, y / v.y, z / v.z).let { this }
inline fun Vec3f.selfDivide(v: Float) = set(x / v, y / v, z / v).let { this }
inline fun Vec3f.selfDivide(v: Int) = set(x / v, y / v, z / v).let { this }

inline fun Vec3f.selfNormalize() = if (isZero) set(0f, 0f, 0f) else selfDivide(length)
inline fun Vec3f.selfNegate() = set(-x, -y, -z).let { this }

inline fun Vec3f.selfMix(v: Vec3f, ratio: Float): Vec3f {
    val inverseRatio = 1f - ratio
    this.x = this.x * inverseRatio + v.x * ratio
    y = y * inverseRatio + v.y * ratio
    z = z * inverseRatio + v.z * ratio
    return this
}

inline fun Vec3i.selfAdd(v: Vec3i) = set(x + v.x, y + v.y, z + v.z).let { this }
inline fun Vec3i.selfSubtract(v: Vec3i) = set(x - v.x, y - v.y, z - v.z).let { this }

inline fun Vec3i.selfMultiply(v: Vec3i) = set(x * v.x, y * v.y, z * v.z).let { this }
inline fun Vec3i.selfMultiply(v: Int) = set(x * v, y * v, z * v).let { this }

inline fun Vec3i.selfDivide(v: Vec3i) = set(x / v.x, y / v.y, z / v.z).let { this }
inline fun Vec3i.selfDivide(v: Int) = set(x / v, y / v, z / v).let { this }


inline fun Vec4f.selfAdd(v: Vec4f) = set(x + v.x, y + v.y, z + v.z, w + v.w)
inline fun Vec4f.selfSubtract(v: Vec4f) = set(x - v.x, y - v.y, z - v.z, w - v.w)

inline fun Vec4f.selfMultiply(v: Vec4f) = set(x * v.x, y * v.y, z * v.z, w * v.w)
inline fun Vec4f.selfMultiply(v: Float) = set(x * v, y * v, z * v, w * v)

inline fun Vec4f.selfDivide(v: Vec4f) = set(x / v.x, y / v.y, z / v.z, w / v.w)
inline fun Vec4f.selfDivide(v: Float) = set(x / v, y / v, z / v, w / v)

inline fun Vec4f.selfNormalize() = if (isZero) set(0f, 0f, 0f, 0f) else selfDivide(length)