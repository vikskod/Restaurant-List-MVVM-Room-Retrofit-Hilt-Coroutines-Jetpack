package com.vikskod.restaurantlist.data.remote

import javax.inject.Inject

class RestaurantRemoteDataSource @Inject constructor(private val apiService: ApiService) :
    BaseDataSource() {

    suspend fun getRestaurant(
        header: String,
        entityId: String,
        entityType: String,
        searchKey: String,
        maxResults: String,
        sort: String,
        order: String
    ) = getResult {
        apiService.getRestaurantData(
            header,
            entityId,
            entityType,
            searchKey,
            maxResults,
            sort,
            order
        )
    }

}