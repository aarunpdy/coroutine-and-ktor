package com.training.movieapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.training.movieapp.data.model.MovieResponse
import com.training.movieapp.data.remote.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NowPlayingViewModel : ViewModel() {
    private var _moviesLiveData = MutableLiveData<MovieResponse>()
    val moviesLiveData: LiveData<MovieResponse>
        get() = _moviesLiveData
    var dataLoaded = false

    fun fetchNowPlaying() {
        CoroutineScope(Dispatchers.IO).launch {
            val movieResponse = ApiService.fetchNowPlaying()
            _moviesLiveData.postValue(movieResponse)
            dataLoaded = true
        }
    }
}