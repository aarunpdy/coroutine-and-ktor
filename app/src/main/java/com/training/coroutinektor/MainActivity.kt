package com.training.coroutinektor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.training.coroutinektor.databinding.ActivityMainBinding
import io.ktor.http.HeadersBuilder
import io.ktor.http.HttpMessageBuilder
import io.ktor.http.HttpMethod
import io.ktor.http.URLBuilder
import kotlinx.coroutines.*
import java.util.jar.Attributes

class MainActivity : AppCompatActivity() {

    private val mainScope = MainScope()
    private lateinit var viewBinder: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinder.root)

        doSomething()

        viewBinder.coroutineLaunch.setOnClickListener {
        }
    }

    private fun doSomething() {
        repeat(10) { i ->
            mainScope.launch {
                delay((i + 1) * 200L)
                println("Coroutine $i is done")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }
}


    interface HttpRequestBuilder : HttpMessageBuilder {
        var method: HttpMethod
        val url: URLBuilder
        fun url(block: URLBuilder.(URLBuilder) -> Unit)
        override val headers: HeadersBuilder
        fun header(key: String, value: String)
        fun headers(block: HeadersBuilder.() -> Unit)
        var body: Any
        val executionContext: CompletableDeferred<Unit>
        fun setAttributes(block: Attributes.() -> Unit)
        fun takeFrom(builder: HttpRequestBuilder): HttpRequestBuilder
    }
