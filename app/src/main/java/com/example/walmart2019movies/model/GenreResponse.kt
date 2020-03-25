package com.example.walmart2019movies.model

data class GenreResponse(
    var genres: List<GenreDetail>
)

data class GenreDetail(
    var id: Int,
    var name: String
)
