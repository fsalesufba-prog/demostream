package com.demo.streamflix.ui.main

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.demo.streamflix.`data`.model.Channel
import com.demo.streamflix.mobile.NavGraphDirections
import com.demo.streamflix.mobile.R

public class SplashFragmentDirections private constructor() {
  public companion object {
    public fun actionSplashFragmentToLoginFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_splashFragment_to_loginFragment)

    public fun actionSplashFragmentToHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_splashFragment_to_homeFragment)

    public fun actionGlobalChannelDetailFragment(channel: Channel): NavDirections =
        NavGraphDirections.actionGlobalChannelDetailFragment(channel)
  }
}
