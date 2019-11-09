package com.example.kotlinnews.Model

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.kotlinnews.Service.GetChildrenService
import com.example.kotlinnews.Service.RetrofitClientInstance
import com.example.kotlinnews.View.RecycleView.MyAdapter.Companion.TAG
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

    private fun repository() {
        getChildrenService = RetrofitClientInstance.retrofitInstance?.create(GetChildrenService::class.java)

    }

    fun getList(): MutableLiveData<List<ChildrenData>> {
        val res: MutableLiveData<List<ChildrenData>> = MutableLiveData()
        getChildrenService?.getAllChildren()?.enqueue(object: Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val body = response.body()
                val list = body?.data?.children?.toList()
                if (list != null) {
                    res.postValue(list)
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.e(TAG, "throw an exception")
            }
        })

        return res
    }
}

