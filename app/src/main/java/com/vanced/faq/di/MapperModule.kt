package com.vanced.faq.di

import com.vanced.faq.network.model.categories.CategoryListDtoMapper
import com.vanced.faq.network.model.guide.GuideJsonDtoMapper
import org.koin.dsl.module

val mapperModule = module {

    fun provideGuideDtoMapper(): GuideJsonDtoMapper {
        return GuideJsonDtoMapper()
    }

    fun provideCategoryDtoMapper(): CategoryListDtoMapper {
        return CategoryListDtoMapper()
    }

    single { provideGuideDtoMapper() }
    single { provideCategoryDtoMapper() }
}