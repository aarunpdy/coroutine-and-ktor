package com.training.coroutinektor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.training.coroutinektor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinder: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinder.root)

        viewBinder.coroutineLaunch.setOnClickListener {

        }
    }

}
