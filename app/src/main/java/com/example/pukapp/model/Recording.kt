package com.example.pukapp.model

data class Recording(
    var id: Int,
    var audioURL: String,
    var createdAt: String,
    var updatedAt: String
)

data class Response(
    val pagination: Pagination,
    val data: Data
)

data class Data(
    val puks: List<Recording>
)

data class Pagination(
    val next: String,
    val back: String
)
