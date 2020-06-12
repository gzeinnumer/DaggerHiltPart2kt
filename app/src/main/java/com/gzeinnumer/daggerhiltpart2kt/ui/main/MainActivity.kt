package com.gzeinnumer.daggerhiltpart2kt.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.gzeinnumer.daggerhiltpart2kt.R
import com.gzeinnumer.daggerhiltpart2kt.network.ApiService
import com.gzeinnumer.daggerhiltpart2kt.network.model.ResponseCuaca
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

//todo 7
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity_"

    @Inject lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService.getCuaca("1642907", "03207a5afa25a1f6db2d2fcc6dd63fc1", "metric")
            .enqueue(object : Callback<ResponseCuaca> {
                override fun onFailure(call: Call<ResponseCuaca>, t: Throwable) {
                    Log.d(TAG, "onFailure: "+t.message)
                }

                override fun onResponse(
                    call: Call<ResponseCuaca>,
                    response: Response<ResponseCuaca>
                ) {
                    Log.d(TAG, "onResponse: "+ (response.body()?.list?.size ?: 0))
                }
            })
    }
}