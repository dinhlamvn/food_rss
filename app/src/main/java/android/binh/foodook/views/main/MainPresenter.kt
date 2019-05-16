package android.binh.foodook.views.main

import android.binh.foodook.base.BasePresenter
import android.binh.foodook.base.BaseView

class MainPresenter : BasePresenter() {

    override fun getView(): MainContract.View = mBaseView as MainContract.View

}