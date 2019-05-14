package android.binh.foodook.network

import android.binh.foodook.network.response.BaseResponse

class ApiManager : ApiService {

    private lateinit var request : RequestApi

    override fun getFromUrl(url: String, callback: NetworkCallback<BaseResponse>) {
        request = RequestApi(url, callback)
        request.execute()
    }
}