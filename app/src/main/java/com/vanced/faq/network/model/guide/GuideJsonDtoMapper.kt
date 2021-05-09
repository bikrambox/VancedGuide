package com.vanced.faq.network.model.guide

import com.vanced.faq.domain.model.guide.GuideFieldModel
import com.vanced.faq.domain.model.guide.GuideJsonModel
import com.vanced.faq.domain.model.guide.GuideSingleJsonModel
import domain.util.EntityMapper

class GuideJsonDtoMapper : EntityMapper<GuideJsonDto, GuideJsonModel> {

    override suspend fun mapToModel(entity: GuideJsonDto): GuideJsonModel {
        return with (entity) {
            GuideJsonModel(
                data = data.map { jsonDto ->
                    GuideSingleJsonModel(
                        jsonDto.title,
                        jsonDto.description,
                        jsonDto.fields?.map { fieldDto ->
                            GuideFieldModel(
                                fieldDto.title,
                                fieldDto.content
                            )
                        }
                    )
                }
            )
        }
    }

}