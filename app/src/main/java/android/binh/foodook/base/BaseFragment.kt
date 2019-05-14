package android.binh.foodook.base

import android.binh.foodook.views.category.CategoryContract
import android.binh.foodook.views.category.SaleContract
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment() {

    protected val REQUEST_LIST_FOOD_OF_CATEGORY : Int = 1000

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(getLayoutResource(), container, false)
        return renderLayout(view)
    }

    abstract fun getLayoutResource() : Int

    abstract fun renderLayout(view : View) : View
}