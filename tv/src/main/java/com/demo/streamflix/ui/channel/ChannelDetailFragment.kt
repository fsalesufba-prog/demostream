package com.demo.streamflix.ui.channel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.demo.streamflix.databinding.FragmentChannelDetailBinding

class ChannelDetailFragment : Fragment() {

    private var _binding: FragmentChannelDetailBinding? = null
    private val binding get() = _binding!!
    private val args: ChannelDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChannelDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val channel = args.channel

        binding.tvChannelName.text = channel.name
        binding.tvChannelDescription.text = channel.description

        Glide.with(this)
            .load(channel.logo)
            .into(binding.ivChannelLogo)

        binding.btnWatchNow.setOnClickListener {
            val action = ChannelDetailFragmentDirections.actionChannelDetailFragmentToPlayerFragment(channel)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}