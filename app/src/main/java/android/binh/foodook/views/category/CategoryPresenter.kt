package android.binh.foodook.views.category

import android.binh.foodook.base.BasePresenter
import android.binh.foodook.base.BaseView

class CategoryPresenter : BasePresenter() {

    override fun getView(): BaseView = mBaseView as CategoryContract.View
}