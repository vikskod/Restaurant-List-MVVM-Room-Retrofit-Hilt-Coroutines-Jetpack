package com.vikskod.restaurantlist.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.like.LikeButton
import com.like.OnLikeListener
import com.vikskod.abbostsfordrestaurant.data.model.RestaurantX
import com.vikskod.restaurantlist.databinding.RvListRestaurantBinding
import java.util.*

class RestaurantAdapter() :
    RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    // Helper for computing the difference between two lists
    /*private val callback = object : DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.restaurant.id == newItem.restaurant.id
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, callback)*/

    private var finalData = ArrayList<RestaurantX>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding =
            RvListRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = finalData[position]
        holder.bind(restaurant)
    }

    override fun getItemCount(): Int {
        return finalData.size
    }

    fun setAdapter(data: ArrayList<RestaurantX>) {
        finalData.clear()
        finalData = data
        notifyDataSetChanged()
    }

    fun clearAdapter() {
        finalData.clear()
        notifyDataSetChanged()
    }

    inner class RestaurantViewHolder(private val binding: RvListRestaurantBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(restaurantX: RestaurantX) {
            binding.tvTitle.text = restaurantX.name
            binding.tvAddress.text = restaurantX.location.address
            binding.btnLike.isLiked = restaurantX.isFavourite
            binding.btnLike.setOnLikeListener(object : OnLikeListener {
                override fun liked(likeButton: LikeButton) {
                    restaurantX.isFavourite = true

                }

                override fun unLiked(likeButton: LikeButton) {
                    restaurantX.isFavourite = false
                }
            })

            Glide.with(binding.ivBackground.context)
                .load(restaurantX.featuredImage)
                .into(binding.ivBackground)
        }
    }
}