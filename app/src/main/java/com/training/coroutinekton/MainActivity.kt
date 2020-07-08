package com.training.coroutinekton

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.training.coroutinekton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinder: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinder.root)
    }

}
