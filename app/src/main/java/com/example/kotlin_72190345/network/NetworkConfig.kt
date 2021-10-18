package com.example.kotlin_72190345.network

import com.example.kotlin_72190345.model.DataItem
import com.example.kotlin_72190345.model.ResponseAddPetani
import com.example.kotlin_72190345.model.ResponsePetani
import com.example.kotlin_72190345.model.ResponseUsersItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

class NetworkConfig {
    fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return okHttpClient
    }
    fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
//        .baseUrl("https://jsonplaceholder.typicode.com/")
           .baseUrl("http://192.168.3.253/aplikasi-slim/public/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getService() = getRetrofit().create(Users::class.java)
}
interface Users {
    @GET("users")
    fun getUsers(): Call<List<ResponseUsersItem>>
    @GET("petani/")
    fun getPetaniAll(): Call<ResponsePetani>
    @POST("petani/")
    fun addPetani(@Body req : DataItem) : Call<ResponseAddPetani>
    @PUT("petani/{id}")
    fun updatePetani(@Path("id") id : Int, @Body req : DataItem) : Call<ResponseAddPetani>
    @DELETE("petani/{id}")
    fun deletePetani(@Path("id") id : Int) : Call<ResponseAddPetani>
}