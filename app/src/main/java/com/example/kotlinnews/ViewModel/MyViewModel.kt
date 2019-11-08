package com.example.kotlinnews.ViewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.kotlinnews.Model.ChildrenData

class MyViewModel : ViewModel() {

    val list: MutableLiveData<List<ChildrenData>>? = null

    fun init() {

    }
}
