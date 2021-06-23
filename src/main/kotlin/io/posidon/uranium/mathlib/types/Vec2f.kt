package io.posidon.uranium.mathlib.types

import kotlin.math.sqrt

data class Vec2f(var x: Float, var y: Float) {

    inline fun set(v: Vec2f) = set(v.x, v.y)
    inline fun set(x: Float, y: Float): Vec2f {
        this.x = x
        this.y = y
        return this
    }

    inline fun longUID(): Long = x.toRawBits().toLong() shl 32 or y.toRawBits().toLong()

    override fun toString() = "vec2f($x, $y)"

    inline fun toVec2i() = Vec2i(x.toInt(), y.toInt())

    companion object {
        inline fun zero() = Vec2f(0f, 0f)
    }

    inline val length get() = sqrt(x * x + y * y)

    inline val isZero get() = x == 0f && y == 0f

    inline operator fun plus(v: Vec2f) = Vec2f(x + v.x, y + v.y)
    inline operator fun minus(v: Vec2f) = Vec2f(x - v.x, y - v.y)

    inline operator fun times(v: Vec2f) = Vec2f(x * v.x, y * v.y)
    inline operator fun times(v: Float) = Vec2f(x * v, y * v)

    inline operator fun div(v: Vec2f) = Vec2f(x / v.x, y / v.y)
    inline operator fun div(v: Float) = Vec2f(x / v, y / v)
    inline operator fun div(v: Int) = Vec2f(x / v, y / v)

    inline operator fun rem(v: Int) = Vec2f(x % v, y % v)
    inline operator fun unaryMinus() = Vec2f(-x, -y)

    inline fun normalized() = if (isZero) zero() else this / length
    inline fun dot(v: Vec2f) = x * v.x + y * v.y

    inline fun selfAdd(v: Vec2f) = set(x + v.x, y + v.y).let { this }
    inline fun selfSubtract(v: Vec2f) = set(x - v.x, y - v.y).let { this }

    inline fun selfMultiply(v: Vec2f) = set(x * v.x, y * v.y).let { this }
    inline fun selfMultiply(v: Vec2i) = set(x * v.x, y * v.y).let { this }
    inline fun selfMultiply(v: Float) = set(x * v, y * v).let { this }
    inline fun selfMultiply(v: Int) = set(x * v, y * v).let { this }

    inline fun selfDivide(v: Vec2f) = set(x / v.x, y / v.y).let { this }
    inline fun selfDivide(v: Float) = set(x / v, y / v).let { this }

    inline fun selfNormalize() = if (isZero) set(0f, 0f) else selfDivide(length)

    inline fun selfMix(v: Vec2f, ratio: Float): Vec2f {
        val inverseRatio = 1f - ratio
        x = x * inverseRatio + v.x * ratio
        y = y * inverseRatio + v.y * ratio
        return this
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false
        other as Vec2f
        if (x != other.x) return false
        if (y != other.y) return false
        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        return result
    }
}

inline fun Vec2f(x: Float) = Vec2f(x, x)