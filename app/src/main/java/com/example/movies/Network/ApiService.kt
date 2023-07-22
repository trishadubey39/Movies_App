package com.example.movies.Network

import com.example.movies.MovieList.MovieListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("movies/{page}")
    suspend fun getMoviesList(@Path("page") page: Int): Response<List<MovieListModel>>
}