package com.example.kotlinnews.Service

//class ServiceCall(private val dataList:MutableList<ChildrenData> ) {
//
//    val service = RetrofitClientInstance.retrofitInstance?.create(GetChildrenService::class.java)
//    val call = service?.getAllChildren()




//    call?.enqueue(object: Callback<News> {
//        override fun onResponse(call: Call<News>, response: Response<News>) {
//            val body = response?.body()
//            val list = body?.data?.children?.toList()
////            if (list != null) {
////                dataList.addAll(list)
////            }
////            myAdapter.notifyDataSetChanged()
//        }
//
//        override fun onFailure(call: Call<News>, t: Throwable) {
//            Toast.makeText(applicationContext, "Error Json", Toast.LENGTH_LONG).show()
//        }
//
//    })
//}