package com.demo.streamflix.ui.about

import androidx.navigation.NavDirections
import com.demo.streamflix.`data`.model.Channel
import com.demo.streamflix.mobile.NavGraphDirections

public class AboutFragmentDirections private constructor() {
  public companion object {
    public fun actionGlobalChannelDetailFragment(channel: Channel): NavDirections =
        NavGraphDirections.actionGlobalChannelDetailFragment(channel)
  }
}
