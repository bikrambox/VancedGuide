package com.vanced.faq.repository.categories

import com.vanced.faq.domain.model.categories.CategoryListModel

interface CategoryRepository {

    suspend fun fetch(language: String): CategoryListModel

}