package com.vikskod.restaurantlist.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.like.LikeButton
import com.like.OnLikeListener
import com.vikskod.abbostsfordrestaurant.data.model.RestaurantX
import com.vikskod.restaurantlist.databinding.RvListRestaurantBinding
import java.util.*

class RestaurantAdapter() : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    // Helper for computing the difference between two lists
    private val callback = object : DiffUtil.ItemCallback<RestaurantX>() {
        override fun areItemsTheSame(oldItem: RestaurantX, newItem: RestaurantX): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RestaurantX, newItem: RestaurantX): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding =
            RvListRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = differ.currentList[position]
        holder.bind(restaurant)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
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
                    onItemClickListener?.let {
                        it(restaurantX, true)
                    }
                }

                override fun unLiked(likeButton: LikeButton) {
                    restaurantX.isFavourite = false
                    onItemClickListener?.let {
                        it(restaurantX, false)
                    }
                }
            })

            Glide.with(binding.ivBanner.context)
                .load(restaurantX.featuredImage)
                .into(binding.ivBanner)

            binding.rlContainer.setOnClickListener {
                onContainerClickListener?.let {
                    it(restaurantX)
                }
            }
        }
    }

    private var onItemClickListener: ((RestaurantX, Boolean) -> Unit)? = null
    fun setOnItemClickListener(listener: (RestaurantX, Boolean) -> Unit) {
        onItemClickListener = listener
    }

    private var onContainerClickListener: ((RestaurantX) -> Unit)? = null
    fun setOnContainerClickListener(listener: (RestaurantX) -> Unit) {
        onContainerClickListener = listener
    }
}