package com.demo.streamflix.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demo.streamflix.R
import com.demo.streamflix.databinding.ItemSearchResultBinding
import com.demo.streamflix.data.local.entity.ChannelEntity

class SearchAdapter(
    private val onItemClick: (ChannelEntity) -> Unit
) : ListAdapter<ChannelEntity, SearchAdapter.SearchViewHolder>(SearchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = ItemSearchResultBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SearchViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class SearchViewHolder(
        private val binding: ItemSearchResultBinding,
        private val onItemClick: (ChannelEntity) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(channel: ChannelEntity) {
            with(binding) {
                tvChannelName.text = channel.name

                // Load logo
                if (!channel.logoUrl.isNullOrEmpty()) {
                    Glide.with(itemView.context)
                        .load(channel.logoUrl)
                        .placeholder(R.drawable.channel_placeholder)
                        .error(R.drawable.channel_placeholder)
                        .into(ivChannelLogo)
                } else {
                    ivChannelLogo.setImageResource(R.drawable.channel_placeholder)
                }

                // Set click listener
                root.setOnClickListener {
                    onItemClick(channel)
                }
            }
        }
    }
}

class SearchDiffCallback : DiffUtil.ItemCallback<ChannelEntity>() {
    override fun areItemsTheSame(
        oldItem: ChannelEntity,
        newItem: ChannelEntity
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: ChannelEntity,
        newItem: ChannelEntity
    ): Boolean {
        return oldItem == newItem
    }
}