package com.example.kotlinnews.ViewModel

import android.arch.lifecycle.ViewModel
import com.example.kotlinnews.Model.ChildrenData
import com.example.kotlinnews.Model.Repository

class MyViewModel : ViewModel() {
    private var list: MutableList<ChildrenData>? = mutableListOf()
    private val repository: Repository? = Repository()

    fun init() {
        repository?.getInstance()
        list = repository?.getList()
    }

    fun getList(): MutableList<ChildrenData>? {
        return list
    }
}
