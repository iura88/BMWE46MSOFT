package com.e46.boardlauncher.ui

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable

object ThemeHelper {

    fun createSelectableCardBackground(
        accentColor: Int,
        cornerRadiusPx: Float,
        strokeWidthPx: Int
    ): StateListDrawable {
        val normal = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = cornerRadiusPx
            setColor(0xFF16181B.toInt())
            setStroke(strokeWidthPx, 0xFF262A2E.toInt())
        }

        val pressed = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = cornerRadiusPx
            setColor(withAlpha(accentColor, 42))
            setStroke(strokeWidthPx * 2, accentColor)
        }

        return StateListDrawable().apply {
            addState(intArrayOf(android.R.attr.state_pressed), pressed)
            addState(intArrayOf(android.R.attr.state_selected), pressed)
            addState(intArrayOf(android.R.attr.state_focused), pressed)
            addState(intArrayOf(), normal)
        }
    }

    fun createDockButtonBackground(
        accentColor: Int,
        cornerRadiusPx: Float,
        strokeWidthPx: Int
    ): StateListDrawable {
        val normal = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = cornerRadiusPx
            setColor(0xFF181B1F.toInt())
            setStroke(strokeWidthPx, 0xFF282C31.toInt())
        }

        val active = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = cornerRadiusPx
            setColor(withAlpha(accentColor, 54))
            setStroke(strokeWidthPx * 2, accentColor)
        }

        return StateListDrawable().apply {
            addState(intArrayOf(android.R.attr.state_pressed), active)
            addState(intArrayOf(android.R.attr.state_selected), active)
            addState(intArrayOf(), normal)
        }
    }

    fun createSwatchDrawable(color: Int, selected: Boolean, ringColor: Int, strokePx: Int): GradientDrawable {
        return GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = strokePx * 4f
            setColor(color)
            if (selected) {
                setStroke(strokePx * 2, ringColor)
            } else {
                setStroke(strokePx, 0xFF343940.toInt())
            }
        }
    }

    fun withAlpha(color: Int, alpha: Int): Int {
        return Color.argb(
            alpha.coerceIn(0, 255),
            Color.red(color),
            Color.green(color),
            Color.blue(color)
        )
    }

    fun createIconTintList(accentColor: Int): ColorStateList {
        return ColorStateList(
            arrayOf(
                intArrayOf(android.R.attr.state_selected),
                intArrayOf(android.R.attr.state_pressed),
                intArrayOf()
            ),
            intArrayOf(
                accentColor,
                accentColor,
                0xFFF2F4F7.toInt()
            )
        )
    }
}
