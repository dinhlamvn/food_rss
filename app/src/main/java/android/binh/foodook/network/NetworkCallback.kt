package android.binh.foodook.network

import android.binh.foodook.network.response.BaseResponse

interface NetworkCallback<in T : BaseResponse> {

    fun onLoadFinished(response: T)
}