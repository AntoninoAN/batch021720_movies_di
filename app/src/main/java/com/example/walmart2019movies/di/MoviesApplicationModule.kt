package com.example.walmart2019movies.di

import android.content.Context
import com.example.walmart2019movies.utils.MoviesApplication
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class MoviesApplicationModule(var moviesApplication:
                              MoviesApplication) {

    @Provides
    fun providesMoviesApplication() : Context{
        return moviesApplication.applicationContext
    }
}