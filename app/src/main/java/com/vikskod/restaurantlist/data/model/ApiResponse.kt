package com.vikskod.abbostsfordrestaurant.data.model


import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("restaurants")
    val restaurants: List<Restaurant>
)