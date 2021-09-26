package io.posidon.uranium.mathlib.types

data class Vec3i(var x: Int, var y: Int, var z: Int) {

    inline fun set(v: Vec3i) = set(v.x, v.y, v.z)
    inline fun set(x: Int, y: Int, z: Int): Vec3i {
        this.x = x
        this.y = y
        this.z = z
        return this
    }

    override fun toString() = "v3($x, $y, $z)"

    companion object {
        inline fun zero() = v3(0)
    }

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