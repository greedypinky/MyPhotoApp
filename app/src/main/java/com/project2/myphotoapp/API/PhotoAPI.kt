package com.project2.myphotoapp.API

import com.project2.myphotoapp.models.PhotoList
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by ritalaw on 2018-04-04.
 */
interface PhotoAPI {
     @GET("?key=8593952-6333a3b18b0e37cc7a649d50a&q=nature&image_type=photo")
    fun getPhotos(): Call<PhotoList>
}