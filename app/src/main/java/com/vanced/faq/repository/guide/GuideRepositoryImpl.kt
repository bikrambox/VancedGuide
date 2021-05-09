package com.vanced.faq.repository.guide

import com.vanced.faq.domain.model.guide.GuideJsonModel
import com.vanced.faq.network.model.guide.GuideJsonDtoMapper
import com.vanced.faq.network.service.guide.GuideService

class GuideRepositoryImpl(
    private val service: GuideService,
    private val mapper: GuideJsonDtoMapper
) : GuideRepository {

    override suspend fun fetch(language: String, jsonName: String): GuideJsonModel {
        return mapper.mapToModel(service.get(language, jsonName))
    }

}