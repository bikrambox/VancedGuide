package com.vanced.faq.domain.model.guide

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GuideJsonModel(
    val data: List<GuideSingleJsonModel>
): Parcelable
