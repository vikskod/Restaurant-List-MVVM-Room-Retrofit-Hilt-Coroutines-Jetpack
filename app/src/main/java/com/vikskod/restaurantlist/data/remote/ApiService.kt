package com.vikskod.restaurantlist.data.remote

import com.vikskod.abbostsfordrestaurant.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


/**
 * Created by Vikash Parajuli on 10/02/2021.
 * vparajuli819@gmail.com
 */
interface ApiService {
    @GET("search")
    suspend fun getRestaurantData(
        @Header("user-key") header: String,
        @Query("entity_id") entityId: String,
        @Query("entity_type") entityType: String,
        @Query("q") searchKey: String,
        @Query("count") maxResults: String,
        @Query("sort") sort: String,
        @Query("order") order: String,
    ): Response<ApiResponse>
}