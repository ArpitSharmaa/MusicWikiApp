package com.example.musicwiki

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Objects
import kotlin.coroutines.coroutineContext

//class repository(context:Application) {
//    suspend fun gettags() :LiveData<List<tag>>{
//        val toptags = Services.retrofit.gettoptags(API_KEY)
//        if (toptags.isSuccessful){
//            return toptags.body()?.toptags?.tags ?: emptyList()
//        }else{
//            return listOf(tag("failed",9836))
//        }
////        var list:tagss?=null
////
////        toptags.enqueue(object : Callback<tagss>{
////            override fun onResponse(call: Call<tagss>, response: Response<tagss>) {
////               list = response.body()!!
////            }
////
////            override fun onFailure(call: Call<tagss>, t: Throwable) {
////                list.toptags.tags= listOf<tag>(tag("fail",9872))
////            }
////
////
////
////
////        }
////
////        )
//    }
//}