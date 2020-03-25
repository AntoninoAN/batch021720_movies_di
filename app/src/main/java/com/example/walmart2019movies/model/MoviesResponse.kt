package com.example.walmart2019movies.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MoviesResponse(
    var page: Int,
    var results: List<MovieDetail>
) : Parcelable

@Parcelize
data class MovieDetail(
    var poster_path : String,
    var overview: String,
    var genre_ids: List<Int>,
    var id: Int,
    var title: String,
    var popularity: Float
) : Parcelable
