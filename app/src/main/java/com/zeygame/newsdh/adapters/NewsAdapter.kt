package com.zeygame.newsdh.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.zeygame.newsdh.databinding.NewsAdapterLayoutBinding
import com.zeygame.newsdh.model.Data
import com.zeygame.newsdh.util.Constants
import com.zeygame.newsdh.view.ViewPagerFragmentDirections

class NewsAdapter(val list:MutableList<Data>) : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {


    inner class MyViewHolder(val binding: NewsAdapterLayoutBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(NewsAdapterLayoutBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))
    }

//    private val differCallBack = object:DiffUtil.ItemCallback<Data>(){
//        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
//            return oldItem.Title == newItem.Title
//        }
//        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
//            return oldItem.equals(newItem)
//        }
//    }
//    private val differ =AsyncListDiffer(this,differCallBack)
//    var dataList : List<Data>
//        get() =differ.currentList
//    set(value) {
//        differ.submitList(value)
//    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currNews = list[position]
        holder.binding.apply {
            txTitleRow.text = currNews.Title
            imgRow.load(currNews.Image.Value){
//                placeholder(CircularProgressDrawable(holder.itemView.context).apply {
//                    strokeWidth=8f
//                    centerRadius=50f
//                    start()
//                })
                crossfade(true)
                crossfade(1000)
            }
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

    fun addNews(data:Data){
        list.add(data)
        notifyItemInserted(itemCount-1)
    }
}