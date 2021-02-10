package com.vikskod.restaurantlist.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vikskod.abbostsfordrestaurant.data.model.Location

class RoomConverters {

    // for converting the json object or String into Pojo or DTO class
    @TypeConverter
    fun toLocation(value: String?): Location {
        return Gson().fromJson(
            value,
            object : TypeToken<Location?>() {}.type
        )
    }

    @TypeConverter
    fun fromLocation(data: Location?): String {
        return Gson().toJson(data)

    }
}