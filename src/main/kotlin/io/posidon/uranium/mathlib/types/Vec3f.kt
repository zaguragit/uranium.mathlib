package io.posidon.uranium.mathlib.types

data class Vec3f(var x: Float, var y: Float, var z: Float) {

    inline fun set(v: Vec3i) = set(v.x.toFloat(), v.y.toFloat(), v.z.toFloat())
    inline fun set(v: Vec3f) = set(v.x, v.y, v.z)
    inline fun set(x: Float, y: Float, z: Float): Vec3f {
        this.x = x
        this.y = y
        this.z = z
        return this
    }

    override fun toString() = "v3($x, $y, $z)"

    companion object {
        inline fun zero() = v3(0f)
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
        var result = x.toRawBits()
        result = 31 * result + y.toRawBits()
        result = 31 * result + z.toRawBits()
        return result
    }
}