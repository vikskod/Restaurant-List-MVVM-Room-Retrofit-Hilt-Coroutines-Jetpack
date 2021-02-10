package com.vikskod.restaurantlist.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.vikskod.restaurantlist.data.remote.ApiService
import com.vikskod.restaurantlist.data.remote.RestaurantRemoteDataSource
import com.vikskod.restaurantlist.utils.Config.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * Created by Vikash Parajuli on 10/02/2021.
 * vparajuli819@gmail.com
 */

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideRestaurantRemoteDataSource(apiService: ApiService) =
        RestaurantRemoteDataSource(apiService)
}