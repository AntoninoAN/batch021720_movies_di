package com.example.walmart2019movies.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.walmart2019movies.model.MoviesRemote
import javax.inject.Inject
import javax.inject.Named

class MoviesViewModelFactory @Inject constructor(var moviesRepository: MoviesRemote) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(moviesRepository) as T
    }
}