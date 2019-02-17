package com.example.task_taras_filipovych

import retrofit2.Call
import retrofit2.http.GET

interface InterfaceService {
    @GET("/albums")
fun chooseAllAlbums(): Call<List<Album>>
}