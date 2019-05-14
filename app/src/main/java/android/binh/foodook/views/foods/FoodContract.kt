package android.binh.foodook.views.foods

import android.binh.foodook.base.BaseView
import android.binh.foodook.models.food.Food

interface FoodContract {

    interface View : BaseView {
        fun onLoadFoodsFinished(list : MutableList<Food>)
        fun onLoadFoodsFailed(error: String)
    }

    interface Presenter {
        fun loadFoods(url : String)
    }
}