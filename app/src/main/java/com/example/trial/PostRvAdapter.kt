package com.example.trial

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class PostRvAdapter (var context: Context,var postList: List<Post>): RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.post_list_item, parent, false)

        return PostViewHolder(itemView)


    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var currentPost = postList.get(position)
        holder.tvuserId.text = currentPost.userId.toString()
        holder.tvid.text = currentPost.id.toString()
        holder.tvtitle.text = currentPost.title
        holder.tvbody.text = currentPost.body
      holder.cvPost.setOnClickListener {
          var intent=Intent(context,viewPostActivity::class.java)
          intent.putExtra("POST_ID",currentPost.id)
          intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
          context.startActivity(intent)
      }


        }








    override fun getItemCount(): Int {
        return postList.size

    }
}
class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var tvuserId=itemView.findViewById<TextView>(R.id.tvuserId)
    var tvid=itemView.findViewById<TextView>(R.id.tvid)
    var tvtitle=itemView.findViewById<TextView>(R.id.tvtitle)
    var tvbody=itemView.findViewById<TextView>(R.id.tvbody)
    var cvPost=itemView.findViewById<CardView>(R.id.cvPost)
}


