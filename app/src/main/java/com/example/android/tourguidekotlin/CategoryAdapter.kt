package com.example.android.tourguidekotlin

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class CategoryAdapter (private val context: Context, fragmentmanager: FragmentManager): FragmentPagerAdapter(fragmentmanager) {
    override fun getItem(position: Int): Fragment {
        when (position){
            0 -> return HotelFragment()
            1 -> return RestaurantFragment()
            2 -> return CasinoFragment()
            3 -> return ClubFragment()
        }
        return Fragment()
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        if (position == 0) {
            return context.getString(R.string.hotel)
        }else if(position == 1) {
            return context.getString(R.string.restaurant)
        }else if(position == 2) {
            return context.getString(R.string.casino)
        }else
            return context.getString(R.string.club)
        }
    }
