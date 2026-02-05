package com.demo.streamflix.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.demo.streamflix.databinding.FragmentCategoryBinding

class CategoryFragment : CategoryBaseFragment() {

    override fun getCategoryId(): Int {
        return arguments?.getLong("categoryId")?.toInt() ?: 0
    }

    override fun getCategoryName(): String {
        return arguments?.getString("categoryName") ?: "Categoría"
    }
}