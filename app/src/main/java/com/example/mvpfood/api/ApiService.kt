package com.example.mvpfood.api

import com.example.mvpfood.model.ResponseGetFood
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("getMakanan")
    fun getFood() : Call<ResponseGetFood>

    @FormUrlEncoded
    @POST("insertMakanan")
    fun insertFood(
        @Field("name") namaMakanan : String,
        @Field("price") hargaMakanan : String,
        @Field("gambar") gambarMakanan : String,
    ): Call<ResponseGetFood>

    @FormUrlEncoded
    @PUT("update")
    fun updateFood(
        @Field("name") idMakanan : String,
        @Field("name") namaMakanan : String,
        @Field("price") hargaMakanan : String,
        @Field("gambar") gambarMakanan : String,
    ): Call<ResponseGetFood>
}