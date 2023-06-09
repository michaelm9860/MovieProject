package com.example.finalproject

import android.app.Application
import com.example.finalproject.data.AppDatabase
import com.example.finalproject.data.repository.MovieRepository

class TMDBApp : Application() {
    override fun onCreate() {
        super.onCreate()
        app = this
        db = AppDatabase.create(this)
        movieRepository = MovieRepository(db.movieDao())
    }

    companion object{
       lateinit var app: TMDBApp
       lateinit var db: AppDatabase
       lateinit var movieRepository: MovieRepository
    }
}