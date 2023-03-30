package com.example.finalproject.ui.home

import android.app.Application
import androidx.lifecycle.*
import com.example.finalproject.TMDBApp
import com.example.finalproject.data.AppDatabase
import com.example.finalproject.data.models.Movie
import com.example.finalproject.data.repository.MovieRepository
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    val movies: LiveData<List<Movie>> = TMDBApp.db.movieDao().getMovies()

    init {
        viewModelScope.launch {
            TMDBApp.movieRepository.refreshMovies()
        }
    }
}