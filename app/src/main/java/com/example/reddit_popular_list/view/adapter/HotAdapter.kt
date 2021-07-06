package com.example.reddit_popular_list.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reddit_popular_list.R
import com.example.reddit_popular_list.model.repo.HotList

class HotAdapter(private val list: HotList) : RecyclerView.Adapter<HotAdapter.HotViewHolder>() {

    inner class HotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView? = null
        var message: TextView? = null
        var like: TextView? = null

        init {
            message = itemView.findViewById(R.id.main_message_rv)
            title = itemView.findViewById(R.id.main_title_rv)
            like = itemView.findViewById(R.id.main_like_rv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotViewHolder {
        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return HotViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HotViewHolder, position: Int) {
        holder.title?.text = list.data.children[position].data.title
        holder.message?.text = list.data.children[position].data.numComments.toString()
        holder.like?.text = list.data.children[position].data.totalAwardsReceived.toString()
    }

    override fun getItemCount(): Int = list.data.children.size
}