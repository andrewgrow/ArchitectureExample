package com.gahov.architecture.core.ui.view.ktx

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.gahov.architecture.core.ktx.loadImage
import com.gahov.architecture.core.ui.view.model.IconProvider

@BindingAdapter("setImage")
fun ImageView.setImage(iconProvider: IconProvider?) {
    when (iconProvider) {
        is IconProvider.Drawable -> setImageDrawable(iconProvider.icon)
        is IconProvider.Url -> loadImage(iconProvider.url)
        is IconProvider.ResIcon -> loadImage(iconProvider.icon)
        is IconProvider.ResVectorIcon -> setImageResource(iconProvider.icon)
        else -> setImageDrawable(null)
    }
}