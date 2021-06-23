package io.posidon.uranium.mathlib

fun deg2rad(x: Double): Double = Math.toRadians(x)
fun deg2rad(x: Float): Float = Math.toRadians(x.toDouble()).toFloat()

fun rad2deg(x: Double): Double = Math.toDegrees(x)
fun rad2deg(x: Float): Float = Math.toDegrees(x.toDouble()).toFloat()