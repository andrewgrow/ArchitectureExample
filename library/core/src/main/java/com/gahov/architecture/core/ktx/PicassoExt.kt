package com.gahov.architecture.core.ktx

import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator
import java.io.File

fun ImageView.loadImage(
    url: String?,
    extras: RequestCreator.() -> RequestCreator = { this }
) = Picasso
    .get()
    .load(url)
    .fit()
    .extras()
    .into(this)

fun ImageView.loadImage(
    uri: Uri?,
    extras: RequestCreator.() -> RequestCreator = { this }
) = Picasso
    .get()
    .load(uri)
    .fit()
    .extras()
    .into(this)

fun ImageView.loadImage(
    file: File,
    extras: RequestCreator.() -> RequestCreator = { this }
) = Picasso
    .get()
    .load(file)
    .fit()
    .extras()
    .into(this)

fun ImageView.loadImage(
    @DrawableRes resourceId: Int,
    extras: RequestCreator.() -> RequestCreator = { this }
) = Picasso
    .get()
    .load(resourceId)
    .fit()
    .extras()
    .into(this)