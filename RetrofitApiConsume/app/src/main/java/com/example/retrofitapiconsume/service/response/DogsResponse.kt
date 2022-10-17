package com.example.retrofitapiconsume.service.response

import com.google.gson.annotations.SerializedName

data class DogsResponse(
    @SerializedName("message")
    val photoUrls: List<String>,
    @SerializedName("status")
    val status: String
)