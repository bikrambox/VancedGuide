package com.vanced.faq

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vanced.faq.repository.categories.CategoryRepository
import com.vanced.faq.repository.guide.GuideRepository
import com.vanced.faq.ui.model.GuideCategory
import kotlinx.coroutines.launch

class MainViewModel(
    private val guideRepository: GuideRepository,
    private val categoryRepository: CategoryRepository
) : ViewModel() {

    val categories = mutableStateOf<List<GuideCategory>?>(emptyList())

    var isFetching by mutableStateOf(false)

    fun fetch(
        language: String = "en"
    ) {
        viewModelScope.launch {
            isFetching = true
            categories.value = try {
                categoryRepository.fetch(language).categories.map {
                    GuideCategory(
                        categoryName = it.category,
                        data = guideRepository.fetch(language, it.json)
                    )
                }
            } catch (e: Exception) {
                Log.d("MainViewModel", "failed to fetch: $e")
                null
            }
            isFetching = false
        }
    }

    init {
        fetch()
    }

}