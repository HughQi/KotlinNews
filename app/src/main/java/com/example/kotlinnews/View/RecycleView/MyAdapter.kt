package com.example.kotlinnews.View.RecycleView

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.example.kotlinnews.Model.ChildrenData
import com.example.kotlinnews.R
import com.example.kotlinnews.View.DetailActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.my_text_view.view.*

class MyAdapter(private val dataList: MutableList<ChildrenData>?): RecyclerView.Adapter<MyViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        context = parent.context
        return MyViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.my_text_view, parent, false)
        )
    }

    companion object {
        const val CHILDREN_TEXT = "CHILDREN_TEXT"
        const val CHILDREN_THUMBNAIL = "CHILDREN_THUMBNAIL"
        const val CHILDREN_TITLE = "CHILDREN_TITLE"
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = dataList!![position].data
        val thumbnail = holder.itemView.thumbnail
        val title = holder.itemView.title
        val text = holder.itemView.text

        title.text = data.title
        text.text = data.selftext
        if (data.thumbnail != "") {
            Picasso.get().load(data.thumbnail).into(thumbnail)
        }

        holder.itemView.setOnClickListener{
            Toast.makeText(context,"123" , Toast.LENGTH_LONG).show()
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(CHILDREN_TEXT, data.selftext)
            intent.putExtra(CHILDREN_THUMBNAIL, data.thumbnail)
            intent.putExtra(CHILDREN_TITLE, data.title)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = dataList!!.size
}