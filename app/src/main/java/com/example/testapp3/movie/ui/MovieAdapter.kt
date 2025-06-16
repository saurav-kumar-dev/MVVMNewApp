package com.example.testapp3.movie.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp3.databinding.MovieItemBinding
import com.example.testapp3.movie.domain.model.MovieData

class MovieAdapter(
    private val onItemClick: (MovieData) -> Unit,
) : ListAdapter<MovieData, MovieAdapter.ViewHolder>(DiffUtilCallBack()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent ,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            data = getItem(position)
            executePendingBindings()
        }
    }

    inner class ViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)

    class DiffUtilCallBack : DiffUtil.ItemCallback<MovieData>() {
        override fun areItemsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
            return oldItem == newItem
        }
    }
}