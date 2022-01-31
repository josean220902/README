package com.example.listadepeliculas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listadepeliculas.databinding.FilmOverviewBinding
import javax.inject.Inject

open class FilmViewHolder(val binding: FilmOverviewBinding) : RecyclerView.ViewHolder(binding.root)
class FilmListAdapter @Inject constructor() :
    ListAdapter<FilmOverviewDataView, FilmViewHolder>(diffUtil) {
    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<FilmOverviewDataView>() {
            override fun areItemsTheSame(
                oldItem: FilmOverviewDataView,
                newItem: FilmOverviewDataView
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: FilmOverviewDataView,
                newItem: FilmOverviewDataView
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return object : FilmViewHolder(
            FilmOverviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ) {

        }
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = getItem(position)
        holder.binding.title.text = film.title
        Glide.with(holder.binding.poster).load(film.imageUrl).into(holder.binding.poster)
    }
}