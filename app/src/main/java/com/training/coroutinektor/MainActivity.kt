package com.training.coroutinektor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.training.coroutinektor.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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
