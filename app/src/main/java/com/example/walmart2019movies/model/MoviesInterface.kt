package com.example.walmart2019movies.model

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesInterface {
    //https://api.themoviedb.org/
    @GET("3/search/movie")
    fun getListMovies(
        @Query("api_key")keyValue: String,
        @Query("page")pageNumber: Int = 2): Observable<MoviesResponse>

    @GET("3/genre/movie/list")
    fun getGenreTypes(
        @Query("api_key")keyValue: String): Observable<GenreResponse>
}