package io.posidon.uranium.mathlib.types

data class Vec2i(var x: Int, var y: Int) {

    inline fun set(v: Vec2i) = set(v.x, v.y)
    inline fun set(x: Int, y: Int): Vec2i {
        this.x = x
        this.y = y
        return this
    }

    override fun toString() = "v2($x, $y)"

    companion object {
        inline fun zero() = v2( 0)
    }

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