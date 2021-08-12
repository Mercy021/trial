package com.example.trial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var rvpost: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchpost()
        //viewbiding
    }
    fun fetchpost(){
        val retrofit = ApiClient.buildService(ApiInterface::class.java)
        val request = retrofit.getPosts()
        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    var postslist = response.body()!!
                    //if (postlist!-null){var postAdapter=PostAdapter

                    // sure you already assigned a value if the variable is null the app will crash null assertion operator
                    rvpost=findViewById(R.id.rvPost)
                    rvpost.layoutManager= LinearLayoutManager(baseContext)
                    val postAdapter=PostRvAdapter(baseContext,postslist)
                    rvpost.adapter=postAdapter
                    //Toast.makeText(baseContext,postslist!!.size.toString(),Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()

            }


        })


    }

}