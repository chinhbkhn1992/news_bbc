package com.chinh.news.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.chinh.news.databinding.ItemNewsBinding
import com.chinh.news.repository.model.NewsModel

class NewsListAdapter(val onclick:(item:NewsModel)->Unit) : RecyclerView.Adapter<NewsListViewHolder>() {
    private val items = arrayListOf<NewsModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(inflater, parent, false)
        return NewsListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.setData(items[position])
        holder.binding.root.setOnClickListener {
            onclick.invoke(items[holder.bindingAdapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    fun setItems(items: List<NewsModel>) {
        val diffCallback = NewsDiffCallback(this.items, items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.items.clear()
        this.items.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }
}


class NewsListViewHolder(val binding: ItemNewsBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun setData(item: NewsModel) {
        binding.item = item
    }
}