package com.vanced.faq.network.service.guide

import com.vanced.faq.network.model.guide.GuideJsonDto
import retrofit2.http.GET
import retrofit2.http.Path

interface GuideService {

    @GET("{language}/{json}")
    suspend fun get(
        @Path("language") language: String,
        @Path("json") json: String
    ): GuideJsonDto

}