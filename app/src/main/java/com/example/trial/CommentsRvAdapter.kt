package com.example.trial

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Comment

class CommentsRvAdapter(var context: Context, var commentList: List<Post>): RecyclerView.Adapter<CommentsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.comments_list_item, parent, false)

        return CommentsViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentComment = commentList.get(position)
        holder.tvName.text = currentComment.name
        holder.tvEmail.text = currentComment.email
        holder.tvBody.text = currentComment.body
        holder.cvComment.setOnClickListener {
            var intent= Intent(context,viewPostActivity::class.java)
            intent.putExtra("POST_COMMENT",currentComment.commentBody)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
             }
    }

    override fun getItemCount(): Int {
        return commentList.size


         }
}
class CommentsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var tvName=itemView.findViewById<TextView>(R.id.tvName)
    var tvEmail=itemView.findViewById<TextView>(R.id.tvEmail)
    var tvBody=itemView.findViewById<TextView>(R.id.tvBody)
    var cvComment=itemView.findViewById<CardView>(R.id.cvComment)
}