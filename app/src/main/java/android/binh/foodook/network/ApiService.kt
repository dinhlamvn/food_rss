package android.binh.foodook.network

import android.binh.foodook.network.response.BaseResponse

interface ApiService {
    fun getFromUrl(url: String, callback: NetworkCallback<BaseResponse>)
}