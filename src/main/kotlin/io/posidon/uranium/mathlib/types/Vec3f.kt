package io.posidon.uranium.mathlib.types

import kotlin.math.*

data class Vec3f(var x: Float, var y: Float, var z: Float) {

    inline fun set(v: Vec3i) = set(v.x.toFloat(), v.y.toFloat(), v.z.toFloat())
    inline fun set(v: Vec3f) = set(v.x, v.y, v.z)
    inline fun set(x: Float, y: Float, z: Float): Vec3f {
        this.x = x
        this.y = y
        this.z = z
        return this
    }

    override fun toString() = "vec3f($x, $y, $z)"

    inline fun toVec3i() = Vec3i(x.toInt(), y.toInt(), z.toInt())
    inline fun roundToVec3i() = Vec3i(x.roundToInt(), y.roundToInt(), z.roundToInt())
    inline fun ceilToVec3i() = Vec3i(ceil(x).toInt(), ceil(y).toInt(), ceil(z).toInt())
    inline fun floorToVec3i() = Vec3i(floor(x).toInt(), floor(y).toInt(), floor(z).toInt())
    inline fun truncateToVec3i() = Vec3i(truncate(x).toInt(), truncate(y).toInt(), truncate(z).toInt())

    companion object {
        inline fun zero() = Vec3f(0f, 0f, 0f)
    }

    inline val length get() = sqrt(x * x + y * y + (z * z).toDouble()).toFloat()

    inline val isZero get() = x == 0f && y == 0f && z == 0f

    inline operator fun plus(v: Vec3f) = Vec3f(x + v.x, y + v.y, z + v.z)
    inline operator fun minus(v: Vec3f) = Vec3f(x - v.x, y - v.y, z - v.z)

    inline operator fun times(v: Vec3f) = Vec3f(x * v.x, y * v.y, z * v.z)
    inline operator fun times(v: Vec3i) = Vec3f(x * v.x, y * v.y, z * v.z)
    inline operator fun times(v: Float) = Vec3f(x * v, y * v, z * v)
    inline operator fun times(v: Int) = Vec3f(x * v, y * v, z * v)

    inline operator fun div(v: Vec3f) = Vec3f(x / v.x, y / v.y, z / v.z)
    inline operator fun div(v: Vec3i) = Vec3f(x / v.x, y / v.y, z / v.z)
    inline operator fun div(v: Float) = Vec3f(x / v, y / v, z / v)
    inline operator fun div(v: Int) = Vec3f(x / v, y / v, z / v)

    inline operator fun rem(v: Int) = Vec3f(x % v, y % v, z % v)
    inline operator fun unaryMinus() = Vec3f(-x, -y, -z)

    inline infix fun dot(x: Vec3f) = this.x * x.x + y * x.y + z * x.z
    inline infix fun cross(x: Vec3f) = Vec3f(y * x.z - z * x.y, z * x.x - this.x * x.z, this.x * x.y - y * x.x)

    inline fun normalized() = if (isZero) zero() else this / length

    inline fun selfAdd(v: Vec3f) = set(x + v.x, y + v.y, z + v.z).let { this }
    inline fun selfSubtract(v: Vec3f) = set(x - v.x, y - v.y, z - v.z).let { this }

    inline fun selfMultiply(v: Vec3f) = set(x * v.x, y * v.y, z * v.z).let { this }
    inline fun selfMultiply(v: Vec3i) = set(x * v.x, y * v.y, z * v.z).let { this }
    inline fun selfMultiply(v: Float) = set(x * v, y * v, z * v).let { this }
    inline fun selfMultiply(v: Int) = set(x * v, y * v, z * v).let { this }

    inline fun selfDivide(v: Vec3f) = set(x / v.x, y / v.y, z / v.z).let { this }
    inline fun selfDivide(v: Vec3i) = set(x / v.x, y / v.y, z / v.z).let { this }
    inline fun selfDivide(v: Float) = set(x / v, y / v, z / v).let { this }
    inline fun selfDivide(v: Int) = set(x / v, y / v, z / v).let { this }

    inline fun selfNormalize() = if (isZero) set(0f, 0f, 0f) else selfDivide(length)
    inline fun selfNegate() = set(-x, -y, -z).let { this }

    inline fun selfMix(v: Vec3f, ratio: Float): Vec3f {
        val inverseRatio = 1f - ratio
        this.x = this.x * inverseRatio + v.x * ratio
        y = y * inverseRatio + v.y * ratio
        z = z * inverseRatio + v.z * ratio
        return this
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false
        other as Vec3f
        if (x != other.x) return false
        if (y != other.y) return false
        if (z != other.z) return false
        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        return result
    }
}

inline fun Vec3f(x: Float) = Vec3f(x, x, x)