package com.vanced.faq.domain.model.guide

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GuideSingleJsonModel(
    val title: String,
    val description: String? = null,
    val fields: List<GuideFieldModel>? = null
): Parcelable
