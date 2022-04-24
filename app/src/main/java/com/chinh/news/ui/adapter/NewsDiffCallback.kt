package com.chinh.news.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.chinh.news.repository.model.NewsModel

class NewsDiffCallback(private val oldList: List<NewsModel>, private val newList: List<NewsModel>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].url == newList[newItemPosition].url
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {

        return oldList[oldPosition] == newList[newPosition]
    }
    override fun getChangePayload(oldPosition: Int, newPosition: Int): Any? {
        return super.getChangePayload(oldPosition, newPosition)
    }

}