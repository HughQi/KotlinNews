package com.example.kotlinnews.Model

import android.util.Log
import com.example.kotlinnews.Service.GetChildrenService
import com.example.kotlinnews.Service.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    var getChildrenService: GetChildrenService? = null

    private var instance: Repository? = null
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
        val res: MutableList<ChildrenData> = mutableListOf()
        getChildrenService?.getAllChildren()?.enqueue(object: Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val body = response?.body()
                val list = body?.data?.children?.toList()
                if (list != null) {
                    res.addAll(list)
                }

//                res.value = dataList
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.e("error JSON", "throw an error")
            }
        })

        return res
    }
}

