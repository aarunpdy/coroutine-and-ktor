package com.training.movieapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.training.coroutinektor.R
import kotlinx.android.synthetic.main.fragment_now_playing.*

class NowPlayingFragment: Fragment() {
    private val viewModel by lazy { ViewModelProvider(requireActivity())[NowPlayingViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_now_playing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movie_list.layoutManager = GridLayoutManager(requireContext(), 2)

        viewModel.moviesLiveData.observe(viewLifecycleOwner, Observer { response->
            if(response != null) {
                movie_list.adapter = NowPlayingAdapter(requireContext(), response.results)
            } else {
                error_msg.isVisible = true
            }
        })
        if (!viewModel.dataLoaded)
            viewModel.fetchNowPlaying()

    }

    companion object {
        fun newInstance(): NowPlayingFragment {
            return NowPlayingFragment()
        }
    }
}