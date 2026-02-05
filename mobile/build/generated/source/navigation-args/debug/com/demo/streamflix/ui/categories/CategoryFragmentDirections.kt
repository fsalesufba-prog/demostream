package com.demo.streamflix.ui.categories

import androidx.navigation.NavDirections
import com.demo.streamflix.NavGraphDirections
import com.demo.streamflix.`data`.model.Channel

public class CategoryFragmentDirections private constructor() {
  public companion object {
    public fun actionGlobalChannelDetailFragment(channel: Channel): NavDirections =
        NavGraphDirections.actionGlobalChannelDetailFragment(channel)
  }
}
