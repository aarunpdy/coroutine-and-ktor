package com.training.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.training.coroutinektor.R
import com.training.movieapp.ui.NowPlayingFragment

class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        supportFragmentManager.beginTransaction().add(R.id.container, NowPlayingFragment.newInstance()).commit()
    }
}
