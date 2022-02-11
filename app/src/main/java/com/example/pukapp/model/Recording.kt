package com.example.pukapp.model

import com.google.gson.annotations.SerializedName

data class Recording(
    var id: Int,
    var audioURL: String,
    var createdAt: String,
    var updatedAt: String
)
