package android.binh.foodook.network

import android.binh.foodook.network.response.BaseResponse
import android.binh.foodook.network.response.FoodsResponse
import android.os.AsyncTask
import okhttp3.*
import java.io.IOException

class RequestApi(private val url : String, private val callback: NetworkCallback<BaseResponse>)
    : AsyncTask<String, Int, BaseResponse>() {

    private val client : OkHttpClient = OkHttpClient()

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg params: String?): BaseResponse {
        val baseResponse : BaseResponse = FoodsResponse()
        val request = Request.Builder().url(url).build()
        val call = client.newCall(request)
        val response : Response = call.execute()
        baseResponse.responseCode = response.code()
        baseResponse.response = response.body()!!.string()
        return baseResponse
    }

    override fun onPostExecute(result: BaseResponse?) {
        super.onPostExecute(result)
        if (result != null) callback.onLoadFinished(result)
    }
}