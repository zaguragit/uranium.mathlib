package io.posidon.uranium.mathlib.types

import kotlin.math.sqrt

data class Vec2i(var x: Int, var y: Int) {

    inline fun set(v: Vec2i) = set(v.x, v.y)
    inline fun set(x: Int, y: Int): Vec2i {
        this.x = x
        this.y = y
        return this
    }

    inline fun longUID(): Long = x.toLong() shl 32 or y.toLong()

    override fun toString() = "vec2i($x, $y)"

    inline fun toVec2f() = Vec2f(x.toFloat(), y.toFloat())

    companion object {
        inline fun zero() = Vec2i(0, 0)
    }

    inline val length get() = sqrt(x.toFloat() * x + y * y)

    inline val isZero get() = x == 0 && y == 0

    inline operator fun plus(v: Vec2i) = Vec2i(x + v.x, y + v.y)
    inline operator fun minus(v: Vec2i) = Vec2i(x - v.x, y - v.y)

    inline operator fun times(v: Vec2i) = Vec2i(x * v.x, y * v.y)
    inline operator fun times(v: Int) = Vec2i(x * v, y * v)

    inline operator fun div(v: Vec2i) = Vec2i(x / v.x, y / v.y)
    inline operator fun div(v: Vec2f) = Vec2f(x / v.x, y / v.y)
    inline operator fun div(v: Int) = Vec2i(x / v, y / v)
    inline operator fun div(v: Float) = Vec2f(x / v, y / v)

    inline operator fun rem(v: Int) = Vec2i(x % v, y % v)
    inline operator fun unaryMinus() = Vec2i(-x, -y)

    inline fun dot(v: Vec2i) = x * v.x + y * v.y

    inline fun selfAdd(v: Vec2i) = set(x + v.x, y + v.y).let { this }
    inline fun selfSubtract(v: Vec2i) = set(x - v.x, y - v.y).let { this }

    inline fun selfMultiply(v: Vec2i) = set(x * v.x, y * v.y).let { this }
    inline fun selfMultiply(v: Int) = set(x * v, y * v).let { this }

    inline fun selfDivide(v: Vec2i) = set(x / v.x, y / v.y).let { this }
    inline fun selfDivide(v: Int) = set(x / v, y / v).let { this }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false
        other as Vec2i
        if (x != other.x) return false
        if (y != other.y) return false
        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }
}

inline fun Vec2i(x: Int) = Vec2i(x, x)