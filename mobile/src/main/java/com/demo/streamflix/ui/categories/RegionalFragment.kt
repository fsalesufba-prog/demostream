package com.demo.streamflix.ui.categories

import android.os.Bundle
import android.view.View
import com.demo.streamflix.R
import com.demo.streamflix.ui.categories.CategoryBaseFragment

class RegionalFragment : CategoryBaseFragment() {

    override fun getCategoryId(): Int = 4 // ID da categoria Regional
    override fun getCategoryName(): String = getString(R.string.category_regional)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Carregar canais regionais
        loadChannels()
    }
}