package com.example.task_taras_filipovych

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        val api = retrofit.create(PhotoInterfaceService::class.java)
        val clickID = intent.getIntExtra(AlbumsAdapter.ViewHolder.Album_ID, 1)
        api.chooseAllPhotos(clickID).enqueue(object : Callback<List<Photo>> {

            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                showData(response.body()!!)

            }


            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
            }
        })
    }
    private fun showData(photos: List<Photo>) {

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@SecondActivity)
            adapter = PhotoAdapter(photos)
            recyclerView.addItemDecoration(DividerItemDecoration(this@SecondActivity, DividerItemDecoration.VERTICAL))

        }
    }
}