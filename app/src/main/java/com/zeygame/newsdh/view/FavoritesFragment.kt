package com.zeygame.newsdh.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.zeygame.newsdh.R
import com.zeygame.newsdh.adapters.NewsAdapter
import com.zeygame.newsdh.databinding.FragmentFavoritesBinding
import com.zeygame.newsdh.model.News
import com.zeygame.newsdh.util.Constants
import com.zeygame.newsdh.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment  : Fragment(R.layout.fragment_favorites)  {
    private var _binding : FragmentFavoritesBinding?=null
    private val binding get() = _binding!!

    val viewModel: FavoriteViewModel by viewModels()
    lateinit var adapterFavorites: NewsAdapter
     val mutableList : MutableList<News> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFavoritesBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()

    }

    private fun initRecycler() {
        adapterFavorites = NewsAdapter(this.requireContext(),mutableList)
        binding.recylerFavorites.apply {
            setHasFixedSize(true)
            this.adapter=adapterFavorites
        }
        getFavorites()
    }

    private fun getFavorites() {
        viewModel.favoritesResponse.observe(viewLifecycleOwner,{
            mutableList.clear()
            mutableList.addAll(it)
            adapterFavorites.notifyDataSetChanged()
        })
    }


}