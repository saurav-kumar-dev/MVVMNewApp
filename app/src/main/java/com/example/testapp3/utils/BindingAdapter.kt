package com.example.testapp3.utils

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("app:bindAdapter")
    fun bindAdapter(recyclerView: RecyclerView, adapter: Adapter<*>?){
        adapter?.let {
            recyclerView.adapter = adapter
        }
    }

    @JvmStatic
    @BindingAdapter("app:isVisible")
    fun isVisible(view: View, isVisible: Boolean) {
        view.isVisible = isVisible
    }
}