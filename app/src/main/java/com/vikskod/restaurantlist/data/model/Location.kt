package com.vikskod.abbostsfordrestaurant.data.model


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("address")
    val address: String
)