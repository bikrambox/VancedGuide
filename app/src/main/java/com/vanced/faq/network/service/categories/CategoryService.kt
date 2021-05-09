package com.vanced.faq.network.service.categories

import com.vanced.faq.network.model.categories.CategoryListDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CategoryService {

    @GET("{language}/categories.json")
    suspend fun get(@Path("language") language: String): CategoryListDto

}