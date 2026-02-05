package com.demo.streamflix.ui.about

import androidx.navigation.NavDirections
import com.demo.streamflix.NavGraphDirections
import com.demo.streamflix.`data`.model.Channel

public class AboutFragmentDirections private constructor() {
  public companion object {
    public fun actionGlobalChannelDetailFragment(channel: Channel): NavDirections =
        NavGraphDirections.actionGlobalChannelDetailFragment(channel)
  }
}
