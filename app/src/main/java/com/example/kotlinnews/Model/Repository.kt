package com.example.kotlinnews

import com.example.kotlinnews.Model.ChildrenData
import com.example.kotlinnews.Model.News
import com.example.kotlinnews.Service.GetChildrenService
import com.example.kotlinnews.Service.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    var getChildrenService: GetChildrenService? = null

    private var instance: Repository? = null

//    private var myAdapter: MyAdapter = MyAdapter(dataList = )

    fun getInstance(): Repository {
        if (instance == null) {
            instance = Repository()
        }

        repository()
        return instance as Repository
    }

    fun repository() {
        getChildrenService = RetrofitClientInstance.retrofitInstance?.create(GetChildrenService::class.java)

    }

    fun getList(): MutableList<ChildrenData> {
        val dataList: MutableList<ChildrenData> = mutableListOf()
        getChildrenService?.getAllChildren()?.enqueue(object: Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val body = response?.body()
                val list = body?.data?.children?.toList()
                if (list != null) {
                    dataList.addAll(list)
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
//                Toast.makeText(, "Error Json", Toast.LENGTH_LONG).show()
            }
        })

        return dataList
    }
}

