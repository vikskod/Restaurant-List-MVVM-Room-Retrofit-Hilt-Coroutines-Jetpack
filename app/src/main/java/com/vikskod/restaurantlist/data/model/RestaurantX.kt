package com.vikskod.abbostsfordrestaurant.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tbl_restaurant")
data class RestaurantX(
    @PrimaryKey
    @SerializedName("id")
    val id: String,

    @SerializedName("featured_image")
    val featuredImage: String,

    @SerializedName("location")
    val location: Location,

    @SerializedName("name")
    val name: String,

    var isFavourite : Boolean
)