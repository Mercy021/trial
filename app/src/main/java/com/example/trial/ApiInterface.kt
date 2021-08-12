package com.example.trial

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("post")
    fun getPosts(): Call<List<Post>>

    @GET("post/{id}")
    fun getPostById ( @Path("id")postId:Int):Call<Post>//defined an endpoint
// to get a single point
    @GET("post/comments")
    fun getComments( @Path("comments")postComments:Int):Call<Post>
}
