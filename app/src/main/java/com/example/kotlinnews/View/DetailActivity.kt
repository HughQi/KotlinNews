package com.example.kotlinnews.View

import android.os.Bundle
import com.example.kotlinnews.R
import com.example.kotlinnews.View.RecycleView.MyAdapter.Companion.CHILDREN_TEXT
import com.example.kotlinnews.View.RecycleView.MyAdapter.Companion.CHILDREN_THUMBNAIL
import com.example.kotlinnews.View.RecycleView.MyAdapter.Companion.CHILDREN_TITLE
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detail_view.*

class DetailActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_view)

        val childrenThumbnail = intent.getStringExtra(CHILDREN_THUMBNAIL)
        val childrenTitle = intent.getStringExtra(CHILDREN_TITLE)
        val childrenText = intent.getStringExtra(CHILDREN_TEXT)
            ?: throw IllegalStateException("field $CHILDREN_TEXT missing in Intent")

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.title = childrenTitle

        if (childrenThumbnail != "") {
            Picasso.get().load(childrenThumbnail).into(thumbnail)
        }
        text.text = childrenText
    }
}