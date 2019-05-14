package android.binh.foodook.views.category

import android.binh.foodook.base.BasePresenter
import android.binh.foodook.base.BaseView

class PickPresenter : BasePresenter() {

    override fun getView(): BaseView = mBaseView as PickContract.View
}