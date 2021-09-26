package io.posidon.uranium.mathlib.types

data class Vec2f(var x: Float, var y: Float) {

    inline fun set(v: Vec2f) = set(v.x, v.y)
    inline fun set(x: Float, y: Float): Vec2f {
        this.x = x
        this.y = y
        return this
    }

    override fun toString() = "v2($x, $y)"

    companion object {
        inline fun zero() = v2(0f)
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
        var result = x.toRawBits()
        result = 31 * result + y.toRawBits()
        return result
    }
}