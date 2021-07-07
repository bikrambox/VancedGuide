package com.vanced.faq.ui.model

import androidx.annotation.DrawableRes

data class LinkModel(
    val name: String,
    val url: String,
    @DrawableRes val icon: Int,
)
