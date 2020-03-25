package com.example.walmart2019movies.di

import com.example.walmart2019movies.model.MoviesRemote
import com.example.walmart2019movies.viewmodel.MoviesViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MoviesViewModelModule() {

    @Provides
    fun providesViewModelFactory(moviesRemote: MoviesRemote)
        = MoviesViewModelFactory(moviesRemote)
}




