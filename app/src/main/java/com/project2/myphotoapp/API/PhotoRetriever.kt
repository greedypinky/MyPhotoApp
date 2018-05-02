package com.project2.myphotoapp.API

import com.project2.myphotoapp.models.PhotoList
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PhotoRetriever {

    private val service:PhotoAPI

    // initialize the service
    init {
        // https://pixabay.com/api/docs/
        val retrofit = Retrofit.Builder().baseUrl("https://pixabay.com/api/")
                .addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(PhotoAPI::class.java)
    }

    fun getPhotos(callback: Callback<PhotoList>) {
        val call = service.getPhotos()
        // to add the callback
        call.enqueue(callback)

    }
}