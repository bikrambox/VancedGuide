package com.vanced.faq.ui.model

import com.vanced.faq.domain.model.guide.GuideJsonModel

data class GuideCategory(
    val categoryName: String,
    val data: GuideJsonModel
)
