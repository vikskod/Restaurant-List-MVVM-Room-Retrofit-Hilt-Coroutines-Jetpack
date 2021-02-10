package com.vikskod.restaurantlist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vikskod.abbostsfordrestaurant.data.model.RestaurantX
import com.vikskod.restaurantlist.utils.Config.DB_VERSION

@Database(entities = [RestaurantX::class], version = DB_VERSION, exportSchema = false)
@TypeConverters(RoomConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun restaurantDao(): RestaurantDao
}