package com.example.movies.movieList

import androidx.annotation.MainThread
import androidx.databinding.Bindable
import androidx.lifecycle.ViewModel
import com.example.movies.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel@Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    @get:Bindable
    var isLoading: Boolean by bindingProperty(false)
        private set

    @get:Bindable
    var toastMessage: String? by bindingProperty(null)
        private set

    private val moviesFetchingIndex: MutableStateFlow<Int> = MutableStateFlow(0)
    private val moviesListFlow = moviesFetchingIndex.flatMapLatest { page ->
        mainRepository.fetchMovieList(
            page = page,
            onStart = { isLoading = true },
            onComplete = { isLoading = false },
            onError = { toastMessage = it }
        )
    }

    @get:Bindable
    val moviesList: List<MovieListModel> by moviesListFlow.asBindingProperty(viewModelScope, emptyList())

    init {
        Timber.d("init MainViewModel")
    }

    @MainThread
    fun fetchNextmoviesList() {
        if (!isLoading) {
            moviesFetchingIndex.value++
        }
    }
}