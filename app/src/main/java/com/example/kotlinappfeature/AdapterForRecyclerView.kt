package com.example.kotlinappfeature

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AdapterForRecyclerView(private val myList: ArrayList<DataClassForRecyclerView>) : RecyclerView.Adapter<AdapterForRecyclerView.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val recyclerViewChildLayout = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_child, parent, false)
        return ViewHolder(recyclerViewChildLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = myList[position].title
        holder.subTitle.text = myList[position].subTitle
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.recycler_view_child_title_tv)
        val subTitle: TextView = itemView.findViewById(R.id.recycler_view_child_sub_title_tv)
    }

}