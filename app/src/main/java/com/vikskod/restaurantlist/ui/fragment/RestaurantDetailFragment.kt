package com.vikskod.restaurantlist.ui.fragment

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.vikskod.restaurantlist.R
import com.vikskod.restaurantlist.databinding.FragmentRestaurantDetailBinding

class RestaurantDetailFragment : Fragment() {

    private lateinit var binding: FragmentRestaurantDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_restaurant_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRestaurantDetailBinding.bind(view)

        val args: RestaurantDetailFragmentArgs by navArgs()
        val restaurant = args.selectedRestaurant

        Glide.with(requireContext())
            .load(restaurant.featuredImage)
            .into(binding.ivBanner)

        binding.tvTitle.text = restaurant.name
        binding.tvAddress.text = restaurant.location.address
    }
}