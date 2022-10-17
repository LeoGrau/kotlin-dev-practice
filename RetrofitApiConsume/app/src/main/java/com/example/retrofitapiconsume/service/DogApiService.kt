package com.example.retrofitapiconsume.service

import com.example.retrofitapiconsume.service.response.DogsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface DogApiService {
    @GET
    suspend fun getDogByBreed(@Url url: String):Response<DogsResponse>
}