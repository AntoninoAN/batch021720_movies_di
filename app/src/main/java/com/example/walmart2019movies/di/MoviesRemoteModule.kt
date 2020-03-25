package com.example.walmart2019movies.di

import android.content.Context
import com.example.walmart2019movies.model.MoviesRemote
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class MoviesRemoteModule(val BASE_URL : String) {

    @Provides
    fun provideRetrofitObject() :Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    @Provides
    fun provideMoviesRemote(applicationContext: Context,
                            retrofit: Retrofit) : MoviesRemote{
        return MoviesRemote(applicationContext, retrofit)
    }
}