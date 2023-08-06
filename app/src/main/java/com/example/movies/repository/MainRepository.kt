package com.example.movies.repository

import androidx.annotation.WorkerThread
import com.example.movies.movieList.MovieListModel
import kotlinx.coroutines.flow.Flow


interface MainRepository {

    @WorkerThread
    fun fetchPokemonList(
        page: Int,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<List<MovieListModel>>
}