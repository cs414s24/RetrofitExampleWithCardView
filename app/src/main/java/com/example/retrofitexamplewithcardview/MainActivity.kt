package com.example.retrofitexamplewithcardview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private val BASE_URL = "https://randomuser.me/api/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Define an array to store a list of users -- this will be the list storing information
        // coming from the API
        val userList = ArrayList<User>()

        // specify a viewAdapter for the dataset
        val adapter = UsersAdapter(userList)

        // Store the the recyclerView widget in a variable
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.adapter = adapter

        // use a linear layout manager for the recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)


        // Creating a Retrofit instance with specified base URL and Gson converter factory
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL) // Set the base URL for the REST API
            .addConverterFactory(GsonConverterFactory.create()) // Add Gson converter factory for JSON serialization/deserialization
            .build() // Build the Retrofit instance

        // Creating an instance of the RandomUserService interface using Retrofit
        val randomUserAPI = retrofit.create(RandomUserService::class.java)


        // Using enqueue method allows to make asynchronous call without blocking/freezing main thread
        // randomUserAPI.getUserInfo("us").enqueue  // this end point gets one user only
        // getMultipleUserInfoWithNationality end point gets multiple user info with nationality as parameters
        // Shortcut to write the object portion quickly: CTRL + Shift + Space
        randomUserAPI.getMultipleUserInfoWithNationality(20, "us").enqueue(object : Callback<UserData> {

            override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                Log.d(TAG, "onResponse: $response")

                // Get access to the body with response.body().
                val body = response.body()
                if (body == null) {
                    Log.w(TAG, "Valid response was not received")
                    return
                }

                // The following log messages are just for testing purpose
                // Normally we do not need to parse the data manually as the main benefit of using
                // "Gson converter factory" is to directly convert the response.body to a Kotlin object
                Log.d(TAG, ": ${body.results.get(0).name.first}")
                Log.d(TAG, ": ${body.results.get(0).name.last}")
                Log.d(TAG, ": ${body.results.get(0).email}")
                Log.d(TAG, ": ${body.results.get(0).gender}")
                Log.d(TAG, ": ${body.results.get(0).imageUrl.medium}")


                // Add all items from the API response (parsed using Gson) to the user list
                userList.addAll(body.results)
                // Update the adapter with the new data
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<UserData>, t: Throwable) {
                Log.d(TAG, "onFailure : $t")
            }

        })

    }
}
