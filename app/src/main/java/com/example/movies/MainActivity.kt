package com.example.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.VisibleForTesting
import com.example.movies.databinding.ActivityMainBinding
import com.example.movies.movieList.MovieListViewModel
import com.skydoves.bindables.BindingActivity

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    @get:VisibleForTesting
    internal val viewModel: MovieListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding {
            adapter = PokemonAdapter()
            vm = viewModel
        }
    }
}