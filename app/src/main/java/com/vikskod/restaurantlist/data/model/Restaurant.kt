package com.vikskod.abbostsfordrestaurant.data.model


import com.google.gson.annotations.SerializedName

data class Restaurant(
    @SerializedName("restaurant")
    val restaurant: RestaurantX
)