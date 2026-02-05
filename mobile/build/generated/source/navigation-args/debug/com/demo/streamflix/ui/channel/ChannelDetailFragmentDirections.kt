package com.demo.streamflix.ui.channel

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.demo.streamflix.`data`.model.Channel
import com.demo.streamflix.mobile.NavGraphDirections
import com.demo.streamflix.mobile.R
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class ChannelDetailFragmentDirections private constructor() {
  private data class ActionChannelDetailFragmentToPlayerFragment(
    public val channel: Channel,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_channelDetailFragment_to_playerFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(Channel::class.java)) {
          result.putParcelable("channel", this.channel as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(Channel::class.java)) {
          result.putSerializable("channel", this.channel as Serializable)
        } else {
          throw UnsupportedOperationException(Channel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionChannelDetailFragmentToPlayerFragment(channel: Channel): NavDirections =
        ActionChannelDetailFragmentToPlayerFragment(channel)

    public fun actionGlobalChannelDetailFragment(channel: Channel): NavDirections =
        NavGraphDirections.actionGlobalChannelDetailFragment(channel)
  }
}
