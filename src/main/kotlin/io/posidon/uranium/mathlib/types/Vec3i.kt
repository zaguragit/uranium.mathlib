package io.posidon.uranium.mathlib.types

import kotlin.math.sqrt

data class Vec3i(var x: Int, var y: Int, var z: Int) {

    inline fun set(v: Vec3i) = set(v.x, v.y, v.z)
    inline fun set(x: Int, y: Int, z: Int): Vec3i {
        this.x = x
        this.y = y
        this.z = z
        return this
    }

    override fun toString() = "vec3i($x, $y, $z)"

    inline fun toVec3f() = Vec3f(x.toFloat(), y.toFloat(), z.toFloat())

    companion object {
        inline fun zero() = Vec3i(0, 0, 0)
    }

    inline val length get() = sqrt(x * x + y * y + (z * z).toDouble()).toFloat()

    inline val isZero get() = x == 0 && y == 0 && z == 0

    inline operator fun plus(v: Vec3i) = Vec3i(x + v.x, y + v.y, z + v.z)
    inline operator fun minus(v: Vec3i) = Vec3i(x - v.x, y - v.y, z - v.z)

    inline operator fun times(v: Vec3f) = Vec3f(x * v.x, y * v.y, z * v.z)
    inline operator fun times(v: Vec3i) = Vec3i(x * v.x, y * v.y, z * v.z)
    inline operator fun times(v: Float) = Vec3f(x * v, y * v, z * v)
    inline operator fun times(v: Int) = Vec3i(x * v, y * v, z * v)

    inline operator fun div(v: Vec3f) = Vec3f(x / v.x, y / v.y, z / v.z)
    inline operator fun div(v: Vec3i) = Vec3i(x / v.x, y / v.y, z / v.z)
    inline operator fun div(v: Float) = Vec3f(x / v, y / v, z / v)
    inline operator fun div(v: Int) = Vec3i(x / v, y / v, z / v)

    inline operator fun rem(v: Int) = Vec3i(x % v, y % v, z % v)
    inline operator fun unaryMinus() = Vec3i(-x, -y, -z)

    inline infix fun dot(v: Vec3i) = x * v.x + y * v.y + z * v.z
    inline infix fun cross(v: Vec3i) = Vec3i(y * v.z - z * v.y, z * v.x - x * v.z, x * v.y - y * v.x)

    inline fun selfAdd(v: Vec3i) = set(x + v.x, y + v.y, z + v.z).let { this }
    inline fun selfSubtract(v: Vec3i) = set(x - v.x, y - v.y, z - v.z).let { this }

    inline fun selfMultiply(v: Vec3i) = set(x * v.x, y * v.y, z * v.z).let { this }
    inline fun selfMultiply(v: Int) = set(x * v, y * v, z * v).let { this }

    inline fun selfDivide(v: Vec3i) = set(x / v.x, y / v.y, z / v.z).let { this }
    inline fun selfDivide(v: Int) = set(x / v, y / v, z / v).let { this }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false
        other as Vec3i
        if (x != other.x) return false
        if (y != other.y) return false
        if (z != other.z) return false
        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        result = 31 * result + z
        return result
    }
}

inline fun Vec3i(x: Int) = Vec3i(x, x, x)