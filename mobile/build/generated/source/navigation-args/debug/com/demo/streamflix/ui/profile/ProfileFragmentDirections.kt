package com.demo.streamflix.ui.profile

import androidx.navigation.NavDirections
import com.demo.streamflix.NavGraphDirections
import com.demo.streamflix.`data`.model.Channel

public class ProfileFragmentDirections private constructor() {
  public companion object {
    public fun actionGlobalChannelDetailFragment(channel: Channel): NavDirections =
        NavGraphDirections.actionGlobalChannelDetailFragment(channel)
  }
}
