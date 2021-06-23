package io.posidon.uranium.mathlib.types

import kotlin.math.sqrt

data class Vec4f(var x: Float, var y: Float, var z: Float, var w: Float) {

    inline fun set(v: Vec4f) = set(v.x, v.y, v.z, v.w)
    inline fun set(x: Float, y: Float, z: Float, w: Float) {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
    }

    override fun toString() = "vec4f($x, $y, $z, $w)"

    companion object {
        inline fun zero() = Vec4f(0f, 0f, 0f, 0f)
    }

    inline val length get() = sqrt(x * x + y * y + (z * z).toDouble()).toFloat()

    inline val isZero get() = x == 0f && y == 0f && z == 0f && w == 0f

    inline operator fun plus(v: Vec4f) = Vec4f(x + v.x, y + v.y, z + v.z, w + v.w)
    inline operator fun minus(v: Vec4f) = Vec4f(x - v.x, y - v.y, z - v.z, w - v.w)

    inline operator fun times(v: Vec4f) = Vec4f(x * v.x, y * v.y, z * v.z, w * v.w)
    inline operator fun times(v: Float) = Vec4f(x * v, y * v, z * v, w * v)

    inline operator fun div(v: Vec4f) = Vec4f(x / v.x, y / v.y, z / v.z, w / v.w)
    inline operator fun div(float: Float) = Vec4f(x / float, y / float, z / float, w / float)

    inline fun normalize() = if (isZero) zero() else this / length
    inline infix fun dot(v: Vec4f) = x * v.x + y * v.y + z * v.z + w * v.w


    inline fun selfAdd(v: Vec4f) = set(x + v.x, y + v.y, z + v.z, w + v.w)
    inline fun selfSubtract(v: Vec4f) = set(x - v.x, y - v.y, z - v.z, w - v.w)

    inline fun selfMultiply(v: Vec4f) = set(x * v.x, y * v.y, z * v.z, w * v.w)
    inline fun selfMultiply(v: Float) = set(x * v, y * v, z * v, w * v)

    inline fun selfDivide(v: Vec4f) = set(x / v.x, y / v.y, z / v.z, w / v.w)
    inline fun selfDivide(v: Float) = set(x / v, y / v, z / v, w / v)

    inline fun selfNormalize() = if (isZero) set(0f, 0f, 0f, 0f) else selfDivide(length)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false
        other as Vec4f
        if (x != other.x) return false
        if (y != other.y) return false
        if (z != other.z) return false
        if (w != other.w) return false
        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        result = 31 * result + w.hashCode()
        return result
    }
}

inline fun Vec4f(x: Float) = Vec4f(x, x, x, x)