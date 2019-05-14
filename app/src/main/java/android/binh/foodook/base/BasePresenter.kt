package android.binh.foodook.base

import android.binh.foodook.network.ApiManager

abstract class BasePresenter {

    protected lateinit var mBaseView: BaseView
    protected val mApiManager : ApiManager = ApiManager()

    fun onCreate(baseView : BaseView) {
        mBaseView = baseView
    }

    abstract fun getView() : BaseView
}