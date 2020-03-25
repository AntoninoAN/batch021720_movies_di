package com.example.walmart2019movies.model

import android.content.Context
import android.content.Intent
import android.util.Log
import retrofit2.Retrofit
import javax.inject.Inject

class MoviesRemote @Inject constructor(var applicationContext : Context,
                                       var retrofit: Retrofit) {

    fun getMoviesApi() : MoviesInterface{
        return retrofit.create(MoviesInterface::class.java)
    }

    fun initPreLoadIntentService(){
        Log.d(TAG, "initPreLoadIntentService")
        val intent = Intent(applicationContext, PreLoadIntentService::class.java)

        applicationContext.startService(intent)
    }
    companion object{
        const val TAG = "MoviesRemote"
    }
}