package com.demo.streamflix.mobile

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.demo.streamflix.`data`.model.Channel
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class NavGraphDirections private constructor() {
  private data class ActionGlobalChannelDetailFragment(
    public val channel: Channel,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_global_channelDetailFragment

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
    public fun actionGlobalChannelDetailFragment(channel: Channel): NavDirections =
        ActionGlobalChannelDetailFragment(channel)
  }
}
