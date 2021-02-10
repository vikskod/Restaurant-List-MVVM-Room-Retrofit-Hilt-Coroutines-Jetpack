package com.vikskod.restaurantlist.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.vikskod.abbostsfordrestaurant.data.model.RestaurantX

@Dao
interface RestaurantDao {

    @Query("SELECT * FROM tbl_restaurant")
    fun getAllRestaurant(): LiveData<List<RestaurantX>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(restaurant: List<RestaurantX>)

    @Update
    suspend fun update(restaurant: RestaurantX)

    @Delete
    suspend fun delete(restaurant: RestaurantX)

    @Query("SELECT * FROM tbl_restaurant WHERE isFavourite == :favourite")
    fun getFavouriteRestaurant(favourite: Boolean = true): LiveData<List<RestaurantX>>
}