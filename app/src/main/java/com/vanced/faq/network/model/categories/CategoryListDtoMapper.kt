package com.vanced.faq.network.model.categories

import com.vanced.faq.domain.model.categories.CategoryListModel
import com.vanced.faq.domain.model.categories.CategoryModel
import domain.util.EntityMapper

class CategoryListDtoMapper : EntityMapper<CategoryListDto, CategoryListModel>{

    override suspend fun mapToModel(entity: CategoryListDto): CategoryListModel {
        return with(entity) {
            CategoryListModel(
                categories = categories.map {
                    CategoryModel(
                        category = it.category,
                        json = it.json
                    )
                }
            )
        }
    }

}