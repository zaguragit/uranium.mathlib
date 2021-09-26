package io.posidon.uranium.mathlib.types

data class Vec4f(var x: Float, var y: Float, var z: Float, var w: Float) {

    inline fun set(v: Vec4f) = set(v.x, v.y, v.z, v.w)
    inline fun set(x: Float, y: Float, z: Float, w: Float) {
        this.x = x
        this.y = y
        this.z = z
        this.w = w
    }

    override fun toString() = "v4($x, $y, $z, $w)"

    companion object {
        inline fun zero() = v4(0f)
    }

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
        var result = x.toRawBits()
        result = 31 * result + y.toRawBits()
        result = 31 * result + z.toRawBits()
        result = 31 * result + w.toRawBits()
        return result
    }
}