package com.training.movieapp.data.model

class MovieResponse {
    var results: List<MovieModel> = ArrayList()
    var page: Int = 0
    var total_results: Int = 0
    var total_pages: Int = 0
}

class MovieModel {
    var popularity: Double = 0.0
    var vote_count: Int = 0
    var video: Boolean = false
    var poster_path: String = ""
    var id : Int = 0
    var adult: Boolean = false
    var backdrop_path: String = ""
    var original_language: String = ""
    var original_title: String = ""
    var genre_ids: List<Int> = ArrayList()
    var title: String = ""
    var vote_average: Double = 0.0
    var overview: String = ""
    var release_date: String = ""
}