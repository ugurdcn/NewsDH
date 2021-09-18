package com.zeygame.newsdh.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zeygame.newsdh.view.FavoritesFragment
import com.zeygame.newsdh.view.NewsFragment

class MyViewPagerAdapter(manager:FragmentManager,lifecycle : Lifecycle)
    : FragmentStateAdapter(manager,lifecycle) {
    override fun getItemCount(): Int =2
    override fun createFragment(position: Int): Fragment{
        return when(position){
            0->{
                NewsFragment()
            }
            1->{
                FavoritesFragment()
            }
            else ->{
                Fragment()
            }
        }
    }
}