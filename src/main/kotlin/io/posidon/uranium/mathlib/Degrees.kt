package io.posidon.uranium.mathlib

inline fun deg2rad(x: Double): Double = Math.toRadians(x)
inline fun deg2rad(x: Float): Float = Math.toRadians(x.toDouble()).toFloat()

inline fun rad2deg(x: Double): Double = Math.toDegrees(x)
inline fun rad2deg(x: Float): Float = Math.toDegrees(x.toDouble()).toFloat()