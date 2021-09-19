package com.zeygame.newsdh.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.zeygame.newsdh.R
import com.zeygame.newsdh.databinding.NewsAdapterLayoutBinding
import com.zeygame.newsdh.model.News
import com.zeygame.newsdh.repository.FavoritesRepository
import com.zeygame.newsdh.util.Constants
import com.zeygame.newsdh.view.ViewPagerFragmentDirections

class NewsAdapter (val context: Context,
                   val list:MutableList<News>) : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    private val favoritesRepository=FavoritesRepository()

    inner class MyViewHolder(val binding: NewsAdapterLayoutBinding) :RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(NewsAdapterLayoutBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currNews = list[position]

        holder.binding.apply {
            txTitleRow.text = currNews.Title
            imgRow.load(currNews.ImageUrl){
                crossfade(true)
                crossfade(1000)
            }
            setImageTurned(imgTurned,currNews)
        }
        if (position>=itemCount-1){
            if (Constants.showProgress.value == false){
                Constants.showProgress.postValue(true)
            }
        }

        holder.itemView.setOnClickListener {
            val direction=ViewPagerFragmentDirections
                .actionViewPagerFragmentToWebViewFragment(currNews.Url)
            it.findNavController().navigate(direction)
        }

    }

    override fun getItemCount(): Int = list.size

    fun addNews(news:News){
        list.add(news)
        notifyItemInserted(itemCount-1)
    }
    fun setImageTurned(imgTurned: ImageView,news:News){
        if (news.IsFavorite) imgTurned.load(R.drawable.ic_turned_in)
        else imgTurned.load(R.drawable.ic_turned_in_not)

        imgTurned.setOnClickListener {
            if (news.IsFavorite){
                deleteFromRealm(news)
                imgTurned.load(R.drawable.ic_turned_in_not)
            }
            else {
                news.IsFavorite=true
                favoritesRepository.save(news)
                imgTurned.load(R.drawable.ic_turned_in)
            }
        }
    }
    private fun deleteFromRealm(currNews: News){
        Constants.deleteListener?.onDelete(currNews)
        favoritesRepository.delete(currNews.Id)
    }
}