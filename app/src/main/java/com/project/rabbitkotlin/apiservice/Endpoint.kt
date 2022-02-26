package com.project.rabbitkotlin.apiservice



import com.project.rabbitkotlin.apiservice.pojos.fetch_employ.ResponseBase
import retrofit2.Call

import retrofit2.http.GET


interface Endpoint {


    @GET("v2/5d565297300000680030a986")
    fun fetchEmployees(): Call<MutableList<ResponseBase>>

}