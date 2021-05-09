package com.vanced.faq.di

import com.vanced.faq.network.model.categories.CategoryListDtoMapper
import com.vanced.faq.network.model.guide.GuideJsonDtoMapper
import com.vanced.faq.network.service.categories.CategoryService
import com.vanced.faq.network.service.guide.GuideService
import com.vanced.faq.repository.categories.CategoryRepository
import com.vanced.faq.repository.categories.CategoryRepositoryImpl
import com.vanced.faq.repository.guide.GuideRepository
import com.vanced.faq.repository.guide.GuideRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    fun provideGuideRepository(
        service: GuideService,
        mapper: GuideJsonDtoMapper
    ): GuideRepository {
        return GuideRepositoryImpl(
            service = service,
            mapper = mapper
        )
    }

    fun provideCategoryRepository(
        service: CategoryService,
        mapper: CategoryListDtoMapper
    ): CategoryRepository {
        return CategoryRepositoryImpl(
            service = service,
            mapper = mapper
        )
    }

    single { provideGuideRepository(get(), get()) }
    single { provideCategoryRepository(get(), get()) }

}