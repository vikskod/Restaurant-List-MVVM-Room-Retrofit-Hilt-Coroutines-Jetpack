package com.vikskod.restaurantlist.di

import com.vikskod.abbostsfordrestaurant.data.model.RestaurantX
import com.vikskod.restaurantlist.data.local.RestaurantDao
import com.vikskod.restaurantlist.data.remote.RestaurantRemoteDataSource
import com.vikskod.restaurantlist.repository.RestaurantRepository
import com.vikskod.restaurantlist.ui.adapter.RestaurantAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.ArrayList
import javax.inject.Singleton


/**
 * Created by Vikash Parajuli on 10/02/2021.
 * vparajuli819@gmail.com
 */

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRepository(
        remoteDataSource: RestaurantRemoteDataSource,
        restaurantDao: RestaurantDao
    ) = RestaurantRepository(remoteDataSource, restaurantDao)

    @Provides
    fun provideRestaurantAdapter(): RestaurantAdapter = RestaurantAdapter()
}