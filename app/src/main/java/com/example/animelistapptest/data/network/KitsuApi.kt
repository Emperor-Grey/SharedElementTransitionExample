package com.example.animelistapptest.data.network

import com.example.animelistapptest.data.network.dto.AnimeResponseDto
import com.example.animelistapptest.data.network.dto.TrendingAnimeListDto
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface KitsuApi {
    @GET("trending/anime")
    suspend fun getTrendingAnimeList(): ApiResponse<TrendingAnimeListDto>

    @GET("anime/{id}")
    suspend fun getAnime(
        @Path("id") id: Int
    ): ApiResponse<AnimeResponseDto>

    companion object {
        const val BASE_URL = "https://kitsu.io/api/edge/"
    }
}