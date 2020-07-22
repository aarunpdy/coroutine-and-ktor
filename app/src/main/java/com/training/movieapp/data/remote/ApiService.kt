package com.training.movieapp.data.remote

import com.training.movieapp.data.model.MovieResponse
import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get

object ApiService {

    private val client: HttpClient
    private val API_KEY = "260465034a27680187bf3f997beccf9d"

    init {
        client = HttpClient() {
            install(JsonFeature) {
                serializer = GsonSerializer()
            }
        }
    }

    suspend fun fetchNowPlaying() : MovieResponse {
        return client.get("http://api.themoviedb.org/3/movie/now_playing?api_key=$API_KEY")
    }

}