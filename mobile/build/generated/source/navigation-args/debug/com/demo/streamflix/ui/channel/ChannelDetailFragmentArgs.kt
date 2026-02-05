package com.demo.streamflix.ui.channel

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.demo.streamflix.`data`.model.Channel
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class ChannelDetailFragmentArgs(
  public val channel: Channel,
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Channel::class.java)) {
      result.set("channel", this.channel as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Channel::class.java)) {
      result.set("channel", this.channel as Serializable)
    } else {
      throw UnsupportedOperationException(Channel::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): ChannelDetailFragmentArgs {
      bundle.setClassLoader(ChannelDetailFragmentArgs::class.java.classLoader)
      val __channel : Channel?
      if (bundle.containsKey("channel")) {
        if (Parcelable::class.java.isAssignableFrom(Channel::class.java) ||
            Serializable::class.java.isAssignableFrom(Channel::class.java)) {
          __channel = bundle.get("channel") as Channel?
        } else {
          throw UnsupportedOperationException(Channel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__channel == null) {
          throw IllegalArgumentException("Argument \"channel\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"channel\" is missing and does not have an android:defaultValue")
      }
      return ChannelDetailFragmentArgs(__channel)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): ChannelDetailFragmentArgs {
      val __channel : Channel?
      if (savedStateHandle.contains("channel")) {
        if (Parcelable::class.java.isAssignableFrom(Channel::class.java) ||
            Serializable::class.java.isAssignableFrom(Channel::class.java)) {
          __channel = savedStateHandle.get<Channel?>("channel")
        } else {
          throw UnsupportedOperationException(Channel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__channel == null) {
          throw IllegalArgumentException("Argument \"channel\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"channel\" is missing and does not have an android:defaultValue")
      }
      return ChannelDetailFragmentArgs(__channel)
    }
  }
}
