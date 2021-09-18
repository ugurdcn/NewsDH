package com.zeygame.newsdh.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.zeygame.newsdh.R
import com.zeygame.newsdh.adapters.NewsAdapter
import com.zeygame.newsdh.databinding.FragmentNewsBinding
import com.zeygame.newsdh.model.News
import com.zeygame.newsdh.repository.FavoritesRepository
import com.zeygame.newsdh.util.DeleteListener
import com.zeygame.newsdh.util.Constants
import com.zeygame.newsdh.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.collections.ArrayList

@AndroidEntryPoint
class NewsFragment : Fragment(R.layout.fragment_news)  {
    private  var _binding : FragmentNewsBinding?=null
    val binding get() = _binding!!


    private val viewModel : NewsViewModel by viewModels()
    private lateinit var adapterNews: NewsAdapter
    val mDataList:MutableList<News> = ArrayList()

    private val favoritesRepository=FavoritesRepository()

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
           Recycler görünürlüğü için  ayarlamalar yapılıyor
        */
    private fun initRecycler(){
        adapterNews= NewsAdapter(this.requireContext(),mDataList)
        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter=adapterNews
        }
        getNews()
    }
        /*
         ProgressBar görünürlüğü için  ayarlamalar yapılıyor
        */
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
                for (dataItem in it.Data){
                    adapterNews.addNews(dataItem.converToNews(favoritesRepository.isExist(dataItem.Id)))
                }
            }
        })
    }


    init {
        Constants.deleteListener = object : DeleteListener {
            override fun onDelete(news: News) {
                var i:Int=0
                for (data in mDataList) {
                    if (data.Id==news.Id){
                        data.IsFavorite=false
                        break
                    }
                    i++
                }
                adapterNews.notifyItemChanged(i)
            }
        }
    }
}