package com.demo.streamflix.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demo.streamflix.R
import com.demo.streamflix.databinding.ItemChannelBinding
import com.demo.streamflix.data.local.entity.ChannelEntity

class ChannelAdapter(
    private val onItemClick: (ChannelEntity) -> Unit
) : ListAdapter<ChannelEntity, ChannelAdapter.ChannelViewHolder>(ChannelDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelViewHolder {
        val binding = ItemChannelBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ChannelViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ChannelViewHolder(
        private val binding: ItemChannelBinding,
        private val onItemClick: (ChannelEntity) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(channel: ChannelEntity) {
            with(binding) {
                tvChannelName.text = channel.name

                // Mostrar número do canal se disponível
                if (channel.number > 0) {
                    tvChannelNumber.text = channel.number.toString()
                    tvChannelNumber.visibility = View.VISIBLE
                } else {
                    tvChannelNumber.visibility = View.GONE
                }

                // Load logo using Glide
                if (channel.logoUrl.isNotEmpty()) {
                    Glide.with(itemView.context)
                        .load(channel.logoUrl)
                        .placeholder(R.drawable.channel_placeholder)
                        .error(R.drawable.channel_placeholder)
                        .into(ivChannelLogo)
                } else {
                    ivChannelLogo.setImageResource(R.drawable.channel_placeholder)
                }

                // Show HD badge if channel is HD
                tvHdBadge.visibility = if (channel.isHd) View.VISIBLE else View.GONE

                root.setOnClickListener {
                    onItemClick(channel)
                }
            }
        }
    }
}

class ChannelDiffCallback : DiffUtil.ItemCallback<ChannelEntity>() {
    override fun areItemsTheSame(oldItem: ChannelEntity, newItem: ChannelEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ChannelEntity, newItem: ChannelEntity): Boolean {
        return oldItem == newItem
    }
}