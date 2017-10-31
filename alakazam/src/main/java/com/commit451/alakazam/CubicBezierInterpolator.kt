package com.commit451.alakazam

import android.graphics.PointF
import android.view.animation.Interpolator

/**
 * Cubic bezier interpolator.
 * Derived from: https://github.com/rdallasgray/bez
 */
open class CubicBezierInterpolator constructor(protected var start: PointF, protected var end: PointF) : Interpolator {
    protected var a = PointF()
    protected var b = PointF()
    protected var c = PointF()

    init {
        if (start.x < 0 || start.x > 1) {
            throw IllegalArgumentException("startX value must be in the range [0, 1]")
        }
        if (end.x < 0 || end.x > 1) {
            throw IllegalArgumentException("endX value must be in the range [0, 1]")
        }
    }

    constructor(startX: Float, startY: Float, endX: Float, endY: Float) : this(PointF(startX, startY), PointF(endX, endY)) {}

    constructor(startX: Double, startY: Double, endX: Double, endY: Double) : this(startX.toFloat(), startY.toFloat(), endX.toFloat(), endY.toFloat()) {}

    override fun getInterpolation(time: Float): Float {
        return getBezierCoordinateY(getXForTime(time))
    }

    protected fun getBezierCoordinateY(time: Float): Float {
        c.y = 3 * start.y
        b.y = 3 * (end.y - start.y) - c.y
        a.y = 1f - c.y - b.y
        return time * (c.y + time * (b.y + time * a.y))
    }

    protected fun getXForTime(time: Float): Float {
        var x = time
        var z: Float
        for (i in 1..13) {
            z = getBezierCoordinateX(x) - time
            if (Math.abs(z) < 1e-3) {
                break
            }
            x -= z / getXDerivate(x)
        }
        return x
    }

    private fun getXDerivate(t: Float): Float {
        return c.x + t * (2 * b.x + 3f * a.x * t)
    }

    private fun getBezierCoordinateX(time: Float): Float {
        c.x = 3 * start.x
        b.x = 3 * (end.x - start.x) - c.x
        a.x = 1f - c.x - b.x
        return time * (c.x + time * (b.x + time * a.x))
    }
}
