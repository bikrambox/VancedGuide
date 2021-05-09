package com.vanced.faq.di

import com.google.gson.GsonBuilder
import com.vanced.faq.network.service.categories.CategoryService
import com.vanced.faq.network.service.guide.GuideService
import com.vanced.faq.network.util.baseGuideUrl
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val serviceModule = module {

    fun provideGuideService(): GuideService {
        return Retrofit.Builder()
            .baseUrl(baseGuideUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(GuideService::class.java)
    }

    fun provideCategoryService(): CategoryService {
        return Retrofit.Builder()
            .baseUrl(baseGuideUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(CategoryService::class.java)
    }

    single { provideGuideService() }
    single { provideCategoryService() }

}