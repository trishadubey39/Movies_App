package com.example.movies.MovieList

import com.example.movies.Network.ApiService
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