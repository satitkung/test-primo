package com.example.testprimo.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testprimo.R
import com.example.testprimo.model.FeedHomePresenter
import com.example.testprimo.ui.home.adapter.viewholder.HomeViewHolder

class HomeAdapter(
    private val onItemClick: (String) -> Unit
) :
    ListAdapter<FeedHomePresenter, RecyclerView.ViewHolder>(Comparator) {

    object Comparator : DiffUtil.ItemCallback<FeedHomePresenter>() {
        override fun areItemsTheSame(
            oldItem: FeedHomePresenter,
            newItem: FeedHomePresenter
        ): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(
            oldItem: FeedHomePresenter,
            newItem: FeedHomePresenter
        ): Boolean {
            return oldItem.title == newItem.title && oldItem.pubDate == newItem.pubDate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HomeViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.home_feed_item_view,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HomeViewHolder) {
            holder.bind(getItem(position), onItemClick)
        }
    }

}