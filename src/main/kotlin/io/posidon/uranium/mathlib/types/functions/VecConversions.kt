package io.posidon.uranium.mathlib.types.functions

import io.posidon.uranium.mathlib.types.*
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.roundToInt
import kotlin.math.truncate

inline fun Vec2f.toVec2i() = v2(x.toInt(), y.toInt())
inline fun Vec2i.toVec2f() = v2(x.toFloat(), y.toFloat())
inline fun Vec3f.toVec3i() = v3(x.toInt(), y.toInt(), z.toInt())
inline fun Vec3i.toVec3f() = v3(x.toFloat(), y.toFloat(), z.toFloat())

inline fun Vec3f.roundToVec3i() = v3(x.roundToInt(), y.roundToInt(), z.roundToInt())
inline fun Vec3f.ceilToVec3i() = v3(ceil(x).toInt(), ceil(y).toInt(), ceil(z).toInt())
inline fun Vec3f.floorToVec3i() = v3(floor(x).toInt(), floor(y).toInt(), floor(z).toInt())
inline fun Vec3f.truncateToVec3i() = v3(truncate(x).toInt(), truncate(y).toInt(), truncate(z).toInt())

inline fun Vec2f.roundToVec3i() = v2(x.roundToInt(), y.roundToInt())
inline fun Vec2f.ceilToVec3i() = v2(ceil(x).toInt(), ceil(y).toInt())
inline fun Vec2f.floorToVec3i() = v2(floor(x).toInt(), floor(y).toInt())
inline fun Vec2f.truncateToVec3i() = v2(truncate(x).toInt(), truncate(y).toInt())

inline fun Vec2f.toRawBits(): Long = x.toRawBits().toLong() shl 32 or y.toRawBits().toLong()
inline fun Vec2i.toRawBits(): Long = x.toLong() shl 32 or y.toLong()