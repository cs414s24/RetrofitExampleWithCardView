package com.example.retrofitexamplewithcardview

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserService {

    // Requesting a random User info based on specified  nationality, https://randomuser.me/api/?nat=us
    // Adding the nationality parameter to your request
    // get(".") indicates that your url is the same as the base url
    @GET(".")
    fun getUserInfo(@Query("nat") nationality: String) : Call<UserData>

    // Requesting Multiple Users, https://randomuser.me/api/?results=5000
    @GET(".")
    fun getMultipleUserInfo(@Query("results") amount: Int) : Call<UserData>


    // Requesting Multiple Users, https://randomuser.me/api/?results=5000&nat=us
    @GET(".")
    fun getMultipleUserInfoWithNationality(@Query("results") amount: Int,
                                           @Query("nat") nationality: String) : Call<UserData>
}