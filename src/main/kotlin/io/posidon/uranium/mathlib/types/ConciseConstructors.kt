package io.posidon.uranium.mathlib.types

inline fun v4(x: Float, y: Float, z: Float, w: Float) = Vec4f(x, y, z, w)
inline fun v4(all: Float) = Vec4f(all, all, all, all)
inline fun v4(xy: Vec2f, zw: Vec2f) = Vec4f(xy.x, xy.y, zw.x, zw.y)
inline fun v4(xy: Vec2i, zw: Vec2i) = Vec4f(xy.x.toFloat(), xy.y.toFloat(), zw.x.toFloat(), zw.y.toFloat())
inline fun v4(xyz: Vec3f, w: Float) = Vec4f(xyz.x, xyz.y, xyz.z, w)
inline fun v4(xyz: Vec3i, w: Float) = Vec4f(xyz.x.toFloat(), xyz.y.toFloat(), xyz.z.toFloat(), w)

inline fun v3(x: Float, y: Float, z: Float) = Vec3f(x, y, z)
inline fun v3(all: Float) = Vec3f(all, all, all)
inline fun v3(xy: Vec2f, z: Float) = Vec3f(xy.x, xy.y, z)
inline fun v3(xy: Vec2i, z: Float) = Vec3f(xy.x.toFloat(), xy.y.toFloat(), z)

inline fun v3(x: Int, y: Int, z: Int) = Vec3i(x, y, z)
inline fun v3(all: Int) = Vec3i(all, all, all)
inline fun v3(xy: Vec2i, z: Int) = Vec3i(xy.x, xy.y, z)

inline fun v2(x: Float, y: Float) = Vec2f(x, y)
inline fun v2(all: Float) = Vec2f(all, all)

inline fun v2(x: Int, y: Int) = Vec2i(x, y)
inline fun v2(all: Int) = Vec2i(all, all)