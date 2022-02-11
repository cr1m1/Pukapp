package com.example.pukapp.model

data class Result(
    var data: Data,
    var pagination: Pagination
)

data class Recording(
    var id: Int,
    var audioURL: String,
    var createdAt: String,
    var updatedAt: String
)

data class Pagination(
    var next: String,
    var back: String
)

data class Data(
    var puks: List<Recording>
)
