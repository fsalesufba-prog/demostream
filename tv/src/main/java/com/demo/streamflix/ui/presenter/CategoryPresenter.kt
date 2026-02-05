package com.demo.streamflix.ui.presenter

import android.view.ViewGroup
import androidx.leanback.widget.Presenter
import android.widget.TextView
import com.demo.streamflix.R

class CategoryPresenter : Presenter() {
    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val view = TextView(parent.context)
        view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        view.isFocusable = true
        view.isFocusableInTouchMode = true
        view.setBackgroundResource(R.drawable.bg_category_chip)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        (viewHolder.view as TextView).text = item as String
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        // No-op
    }
}