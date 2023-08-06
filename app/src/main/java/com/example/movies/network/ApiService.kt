package com.example.movies.network

import com.example.movies.movieList.MovieListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("movies/{page}")
    suspend fun getMoviesList(@Path("page") page: Int): Response<List<MovieListModel>>
}