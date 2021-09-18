package com.zeygame.newsdh.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zeygame.newsdh.R
import com.zeygame.newsdh.databinding.FragmentFavoritesBinding
import com.zeygame.newsdh.model.User
import com.zeygame.newsdh.repository.FavoritesRepository
import com.zeygame.newsdh.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment(R.layout.fragment_favorites) {
    private var _binding : FragmentFavoritesBinding?=null
    private val binding get() = _binding!!

    val viewModel: FavoriteViewModel by viewModels()


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

        viewModel.favoritesResponse.observe(viewLifecycleOwner,{
            binding.txFav.text = it[0].Title
        })


    }

}