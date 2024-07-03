package com.example.animelistapptest.data.di

import com.example.animelistapptest.data.network.KitsuApi
import com.example.animelistapptest.data.repository.KitsuRepositoryImpl
import com.example.animelistapptest.domain.repository.KitsuRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object KitsuModule {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideService(gson: Gson): KitsuApi {
        return Retrofit.Builder().baseUrl(KitsuApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
            .create(KitsuApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(api: KitsuApi): KitsuRepository {
        return KitsuRepositoryImpl(api = api)
    }
}