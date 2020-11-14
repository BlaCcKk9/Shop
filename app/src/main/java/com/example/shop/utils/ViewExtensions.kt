package com.example.shop.utils

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.shop.R

fun ImageView.setImage(url: String?, @DrawableRes placeholder: Int = R.drawable.ic_placeholder) {
    Glide.with(context)
        .load(url)
        .apply(RequestOptions.placeholderOf(placeholder).error(placeholder))
        .into(this)


}
