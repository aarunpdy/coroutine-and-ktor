package com.training.movieapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.training.coroutinektor.R
import com.training.movieapp.data.model.MovieModel

class NowPlayingAdapter(private val context: Context, private val movieList: List<MovieModel>) : RecyclerView.Adapter<NowPlayingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movieList[position]
        holder.apply {
            title.text = movie.title
            Glide.with(imageView).load("http://image.tmdb.org/t/p/w300/${movie.poster_path}")
                .into(imageView)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.image)
        val title: TextView = view.findViewById(R.id.title)
    }
}