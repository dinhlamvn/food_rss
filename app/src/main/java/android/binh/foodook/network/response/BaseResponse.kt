package android.binh.foodook.network.response

abstract class BaseResponse {

    var responseCode : Int = 0
    var response : String = ""

    fun isSucceed() : Boolean = responseCode == statusOk()

    fun isFailed() : Boolean = responseCode != statusOk()

    private fun statusOk() = 200

    fun parse() {
        parseResponse(this.response)
    }

    protected abstract fun parseResponse(response: String) : Boolean
}