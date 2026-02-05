package com.demo.streamflix.ui.player

import androidx.navigation.NavDirections
import com.demo.streamflix.`data`.model.Channel
import com.demo.streamflix.mobile.NavGraphDirections

public class PlayerFragmentDirections private constructor() {
  public companion object {
    public fun actionGlobalChannelDetailFragment(channel: Channel): NavDirections =
        NavGraphDirections.actionGlobalChannelDetailFragment(channel)
  }
}
