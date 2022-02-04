package com.example.mvpfood.api

import com.example.mvpfood.model.ResponseGetFood
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("getMakanan")
    fun getFood() : Call<ResponseGetFood>
}