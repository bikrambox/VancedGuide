package com.vanced.faq

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _categories = MutableLiveData<List<GuideCategory>?>()
    val categories: LiveData<List<GuideCategory>?> = _categories

    private val _isFetching = MutableLiveData<Boolean>()
    val isFetching: LiveData<Boolean> = _isFetching

    fun fetch(
        language: String = "en"
    ) {
        viewModelScope.launch {
            _isFetching.value = true
            _categories.value = try {
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
            _isFetching.value = false
        }
    }

    init {
        fetch()
    }

}