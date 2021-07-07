package com.example.reddit_popular_list.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.reddit_popular_list.R
import com.example.reddit_popular_list.model.repo.Body

class PageAdapter(context: Context) :
    PagingDataAdapter<Body, PageViewHolder>(BodyDiffItemCallback) {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        return PageViewHolder(layoutInflater.inflate(R.layout.item_list, parent, false))
    }
}

class PageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var title: TextView? = null
    var message: TextView? = null
    var like: TextView? = null

    init {
        message = itemView.findViewById(R.id.main_message_rv)
        title = itemView.findViewById(R.id.main_title_rv)
        like = itemView.findViewById(R.id.main_like_rv)
    }

    fun bind(body: Body?) {
        title?.text = body?.title
        message?.text = body?.numComments.toString()
        like?.text = body?.totalAwardsReceived.toString()

    }
}

private object BodyDiffItemCallback : DiffUtil.ItemCallback<Body>() {
    override fun areItemsTheSame(oldItem: Body, newItem: Body): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Body, newItem: Body): Boolean {
        return oldItem.title == newItem.title && oldItem.numComments == newItem.numComments &&
                oldItem.totalAwardsReceived == newItem.totalAwardsReceived
    }

}