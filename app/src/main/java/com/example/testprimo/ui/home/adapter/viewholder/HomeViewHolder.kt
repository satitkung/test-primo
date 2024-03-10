package com.example.testprimo.ui.home.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.testprimo.databinding.HomeFeedItemViewBinding
import com.example.testprimo.model.FeedHomePresenter

class HomeViewHolder(
    private val binding: HomeFeedItemViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: FeedHomePresenter, onItemClick: (String) -> Unit) {
        binding.apply {
            this.item = item
            mainLayout.setOnClickListener { onItemClick.invoke(item.title) }
        }
    }
}