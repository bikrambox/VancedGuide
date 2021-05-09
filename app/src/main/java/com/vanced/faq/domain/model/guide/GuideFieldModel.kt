package com.vanced.faq.domain.model.guide

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GuideFieldModel(
    val title: String,
    val content: String
): Parcelable
