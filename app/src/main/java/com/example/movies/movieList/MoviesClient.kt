package com.example.movies.movieList

import com.example.movies.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class MoviesClient @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun fetchPokemonList(
        page: Int
    ): Response<List<MovieListModel>> =
        apiService.getMoviesList(
            page = page+1,
        )
}