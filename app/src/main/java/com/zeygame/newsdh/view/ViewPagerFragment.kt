package com.zeygame.newsdh.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.zeygame.newsdh.R
import com.zeygame.newsdh.adapters.MyViewPagerAdapter
import com.zeygame.newsdh.databinding.FragmentViewPagerBinding


class ViewPagerFragment : Fragment(R.layout.fragment_view_pager) {
    private  var _binding:FragmentViewPagerBinding?=null
    private val binding get() = _binding!!
    private lateinit var pagerAdapter: MyViewPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        _binding= FragmentViewPagerBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
    }

    private fun setupAdapter() {

        pagerAdapter = MyViewPagerAdapter(parentFragmentManager, lifecycle)
        binding.viewPager.adapter = pagerAdapter

        TabLayoutMediator(binding.tabLayout,binding.viewPager){
                tab,pos->
            when(pos){
                0->{tab.text="NEWS"}
                1->{tab.text="FAVORITES"}
            }
        }.attach()
    }

}