package com.example.animelistapptest.domain.repository

import com.example.animelistapptest.domain.model.AnimeData

interface KitsuRepository {
    suspend fun getTrendingAnime(): List<AnimeData>
    suspend fun getAnime(id: Int): AnimeData?
}