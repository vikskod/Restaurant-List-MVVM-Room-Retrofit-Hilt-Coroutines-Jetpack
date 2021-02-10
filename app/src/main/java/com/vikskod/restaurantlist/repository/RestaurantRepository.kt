package com.vikskod.restaurantlist.repository

import com.vikskod.abbostsfordrestaurant.data.model.RestaurantX
import com.vikskod.abbostsfordrestaurant.utils.performGetOperation
import com.vikskod.restaurantlist.BuildConfig
import com.vikskod.restaurantlist.data.local.RestaurantDao
import com.vikskod.restaurantlist.data.remote.RestaurantRemoteDataSource
import javax.inject.Inject


/**
 * Created by Vikash Parajuli on 10/02/2021.
 * vparajuli819@gmail.com
 */
class RestaurantRepository @Inject constructor(
    private val remoteDataSource: RestaurantRemoteDataSource,
    private val restaurantDao: RestaurantDao
) {

    fun getAllRestaurant() = performGetOperation(
        databaseQuery = { restaurantDao.getAllRestaurant() },
        networkCall = {
            remoteDataSource.getRestaurant(
                BuildConfig.API_KEY,
                "259",            //Id of city -> 259 for Melbourne
                "subzone",    // area type
                "Abbotsford",        //suburb name
                "10",            // get total result
                "rating",         // sort data by rating
                "desc"          // sorting order
            )
        },
        saveCallResult = {
            // Unwanted JsonObject is added on api response
            val finalData = ArrayList<RestaurantX>()
            for (item in it.restaurants)
                finalData.add(item.restaurant)
            restaurantDao.insertAll(finalData)
        }
    )

    fun getFavouriteRestaurant() = restaurantDao.getFavouriteRestaurant()

    suspend fun setFavouriteRestaurant(restaurant: RestaurantX) = restaurantDao.update(restaurant)
}