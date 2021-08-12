package com.example.trial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trial.databinding.ActivityViewPostBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class viewPostActivity : AppCompatActivity() {
    var postId=0
   lateinit var binding:ActivityViewPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding=ActivityViewPostBinding.inflate(layoutInflater)
        postId=intent.getIntExtra("POST_ID",0)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setContentView(binding.root)
        setContentView(R.layout.activity_view_post)
        getPost()
    }
    fun getPost(){
        var retrofit=ApiClient.buildService(ApiInterface::class.java)
        var request=retrofit.getPostById(postId)
        request.enqueue(object :Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
              if (response.isSuccessful){
                  binding.tvPost.text=response.body()?.body
                  binding.tvBody.text=response.body()?.body
              }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {

            }

        } )








}
}

