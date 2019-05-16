package android.binh.foodook.views.foods

import android.binh.foodook.base.BasePresenter
import android.binh.foodook.base.BaseView
import android.binh.foodook.models.food.Food
import android.binh.foodook.network.NetworkCallback
import android.binh.foodook.network.response.BaseResponse
import android.binh.foodook.utils.IDataParser
import android.binh.foodook.utils.XMLParser

class FoodPresenter : BasePresenter(), FoodContract.Presenter {

    private val parser : IDataParser = XMLParser()

    override fun getView(): FoodContract.View = mBaseView as FoodContract.View

    override fun loadFoods(url: String) {
        mApiManager.getFromUrl(url, object : NetworkCallback<BaseResponse> {
            override fun onLoadFinished(response: BaseResponse) {
                if (response.isFailed()) {
                    getView().onLoadFoodsFailed(response.response)
                } else if (response.isSucceed()) {
                    // do some thing
                    val lists : MutableList<Food> = parser.parseFood(response.response)
                    getView().onLoadFoodsFinished(lists)
                }
            }
        })
    }
}