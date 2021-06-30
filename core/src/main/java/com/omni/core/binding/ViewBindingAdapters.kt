package com.omni.core.binding

import android.view.View
import android.widget.Button
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["isGone"])
fun View.isGone(isGone: Boolean) {
    this.visibility = if (isGone) View.GONE else View.VISIBLE
}

@BindingAdapter(value = ["isVisible"])
fun View.isVisible(isVisible: Boolean) {
    this.visibility = if (isVisible) View.VISIBLE else View.GONE
}

private const val DIMMED_ALPHA = 0.3f
private const val FULL_ALPHA = 1.0f

@BindingAdapter(value = ["isDimmed"])
fun View.isDimmed(isDimmed: Boolean) {
    this.alpha = if (isDimmed) DIMMED_ALPHA else FULL_ALPHA
}

@BindingAdapter(value = ["isNotClickable"])
fun Button.isNotClickable(isClickable: Boolean) {
    this.isClickable = isClickable.not()
}

