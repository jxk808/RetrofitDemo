package com.example.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit:Retrofit = Retrofit.Builder()
        .baseUrl("https://aip.github.com/")
        .build()
        val service = retrofit.create(GitHubService::class.java)

        val repos: Call<List<Repo>> = service.listRepos("octocat")

        repos.enqueue(object :Callback<List<Repo>?>{
            override fun onResponse(call: Call<List<Repo>?>, response: Response<List<Repo>?>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<List<Repo>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
}