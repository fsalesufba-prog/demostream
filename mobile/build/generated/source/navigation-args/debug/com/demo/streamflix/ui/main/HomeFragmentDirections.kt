package com.demo.streamflix.ui.main

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.demo.streamflix.NavGraphDirections
import com.demo.streamflix.R
import com.demo.streamflix.`data`.model.Channel

public class HomeFragmentDirections private constructor() {
  public companion object {
    public fun actionHomeFragmentToProfileFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_profileFragment)

    public fun actionHomeFragmentToSearchFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_searchFragment)

    public fun actionHomeFragmentToCategoryFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_categoryFragment)

    public fun actionGlobalChannelDetailFragment(channel: Channel): NavDirections =
        NavGraphDirections.actionGlobalChannelDetailFragment(channel)
  }
}
