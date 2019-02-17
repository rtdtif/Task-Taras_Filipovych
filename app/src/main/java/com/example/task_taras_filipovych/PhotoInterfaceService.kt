package com.example.task_taras_filipovych

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoInterfaceService {
    @GET("/photos")
    fun chooseAllPhotos(@Query("albumId") albumId: Int): Call<List<Photo>>
}
