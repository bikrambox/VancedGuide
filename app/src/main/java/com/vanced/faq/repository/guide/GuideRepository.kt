package com.vanced.faq.repository.guide

import com.vanced.faq.domain.model.guide.GuideJsonModel

interface GuideRepository {

    suspend fun fetch(language: String, jsonName: String): GuideJsonModel

}