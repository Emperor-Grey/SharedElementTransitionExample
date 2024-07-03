package com.example.animelistapptest.ui.screens.trending_anime

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animelistapptest.domain.model.AnimeData
import com.example.animelistapptest.domain.repository.KitsuRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingAnimeViewModel @Inject constructor(
    private val kitsuRepository: KitsuRepository
) : ViewModel() {

    private val _animeData = MutableStateFlow<List<AnimeData>>(emptyList())
    val animeData = _animeData

    init {
        viewModelScope.launch {
            _animeData.update { kitsuRepository.getTrendingAnime() }
        }
    }

}