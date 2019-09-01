package com.mburcak.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mburcak.R
import com.mburcak.model.UserModel
import com.mburcak.ui.holder.UserViewHolder

class UserAdapter(val userList: List<UserModel>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder?.txtTitle?.text = userList[position].title
        holder?.txtStory?.text = userList[position].body
    }

    override fun onCreateViewHolder(parentView: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(parentView?.context).inflate(R.layout.cardview_layout, parentView, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtTitle = itemView.findViewById<TextView>(R.id.filmTitleTV)
        val txtStory = itemView.findViewById<TextView>(R.id.filmStoryTV)
    }

}