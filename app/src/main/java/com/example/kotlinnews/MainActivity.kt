package com.example.kotlinnews

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import com.example.kotlinnews.Model.ChildrenData
import com.example.kotlinnews.View.BaseActivity
import com.example.kotlinnews.View.RecycleView.MyAdapter
import com.example.kotlinnews.ViewModel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    private var dataList: MutableLiveData<List<ChildrenData>>? = MutableLiveData()
    private lateinit var myAdapter: MyAdapter
    private var mViewModel: MyViewModel = MyViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel.init()
        dataList = mViewModel.getList()

        mViewModel.getList()?.observe(this, Observer {
            myAdapter = MyAdapter(dataList?.value)
            my_recycler_view.layoutManager = LinearLayoutManager(this)
            my_recycler_view.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))
            my_recycler_view.adapter = myAdapter
            myAdapter.notifyDataSetChanged()
        })
    }
}