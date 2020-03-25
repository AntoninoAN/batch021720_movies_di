package com.example.walmart2019movies.viewmodel

import androidx.lifecycle.ViewModel
import com.example.walmart2019movies.model.MoviesRemote

class MoviesViewModel(var moviesRepository: MoviesRemote) : ViewModel() {


    fun initPreloadMovies() {

        moviesRepository.initPreLoadIntentService()
    }
}