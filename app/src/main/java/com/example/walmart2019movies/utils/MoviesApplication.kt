package com.example.walmart2019movies.utils

import android.app.Application
import com.example.walmart2019movies.di.*

class MoviesApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        component = DaggerMoviesComponent.builder()
            .moviesApplicationModule(MoviesApplicationModule(this))
            .moviesRemoteModule(MoviesRemoteModule(BASE_URL))
            .moviesViewModelModule(MoviesViewModelModule())
            .build()

    }

    companion object{
        private var component: MoviesComponent? = null
        private const val BASE_URL = "https://api.themoviedb.org/"

        fun getComponent(): MoviesComponent{
            return component!!
        }
    }

}