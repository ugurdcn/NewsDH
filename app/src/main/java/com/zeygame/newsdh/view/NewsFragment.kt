package com.zeygame.newsdh.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.zeygame.newsdh.R
import com.zeygame.newsdh.adapters.NewsAdapter
import com.zeygame.newsdh.databinding.FragmentNewsBinding
import com.zeygame.newsdh.model.Data
import com.zeygame.newsdh.util.Constants
import com.zeygame.newsdh.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment(R.layout.fragment_news) {
    private  var _binding : FragmentNewsBinding?=null
    val binding get() = _binding!!

    private val viewModel : NewsViewModel by viewModels()
    private lateinit var adapterNews: NewsAdapter
    val mDataList:MutableList<Data> = ArrayList()

    var pageIndex =0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()
    }

    /*
         ProgressBar görünürlüğü için  ayarlamalar yapılıyor
    */


    private fun initRecycler(){
        adapterNews= NewsAdapter(mDataList)
        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter=adapterNews
        }
        getNews()
    }

    private fun setProgresBar() {
        Constants.showProgress.observe(viewLifecycleOwner,{
            if (it) {
                binding.progressNews.visibility=View.VISIBLE
                pageIndex++
                viewModel.getNews(pageIndex,15)
            }
            else {
                binding.progressNews.visibility = View.GONE
            }
        })
    }

    private fun getNews(){
        setProgresBar()
        viewModel.newsResponse.observe(viewLifecycleOwner,{
            it?.let {
                for (item in it.Data){
                    adapterNews.addNews(item)
                }
            }
        })

    }
}