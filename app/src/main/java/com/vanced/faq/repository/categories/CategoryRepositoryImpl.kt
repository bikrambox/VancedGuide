package com.vanced.faq.repository.categories

import com.vanced.faq.domain.model.categories.CategoryListModel
import com.vanced.faq.network.model.categories.CategoryListDtoMapper
import com.vanced.faq.network.service.categories.CategoryService

class CategoryRepositoryImpl(
    private val service: CategoryService,
    private val mapper: CategoryListDtoMapper
) : CategoryRepository {

    override suspend fun fetch(language: String): CategoryListModel {
        return mapper.mapToModel(service.get(language))
    }

}