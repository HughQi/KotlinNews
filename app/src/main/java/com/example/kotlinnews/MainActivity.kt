package com.example.kotlinnews

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.widget.Toast
import com.example.kotlinnews.Model.ChildrenData
import com.example.kotlinnews.Model.News
import com.example.kotlinnews.Service.GetChildrenService
import com.example.kotlinnews.Service.RetrofitClientInstance
import com.example.kotlinnews.View.BaseActivity
import com.example.kotlinnews.View.RecycleView.MyAdapter
import com.example.kotlinnews.ViewModel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : BaseActivity() {

    private var dataList: MutableList<ChildrenData>? = mutableListOf()
    private lateinit var myAdapter: MyAdapter
    private var mViewModel: MyViewModel = MyViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mViewModel.init()
//        dataList = mViewModel.getList()

        myAdapter = MyAdapter(dataList)
        my_recycler_view.layoutManager = LinearLayoutManager(this)
        my_recycler_view.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))
        my_recycler_view.adapter = myAdapter

        val service = RetrofitClientInstance.retrofitInstance?.create(GetChildrenService::class.java)
        val call = service?.getAllChildren()

        call?.enqueue(object: Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val body = response?.body()
                val list = body?.data?.children?.toList()
                if (list != null) {
                    dataList?.addAll(list)
                }
                myAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Toast.makeText(applicationContext, "Error Json", Toast.LENGTH_LONG).show()
            }

        })
    }
}