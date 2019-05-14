package android.binh.foodook.views.main

import android.binh.foodook.views.category.CategoryFragment
import android.binh.foodook.views.pick.PickFragment
import android.binh.foodook.views.sale.SaleFragment
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class PageScreenAdapter(fm : FragmentManager, private val screens: List<String>?) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int = screens!!.size

    override fun getItem(p0: Int): Fragment {
        if (p0 == 0) return SaleFragment()
        else if (p0 == 1) return PickFragment()
        return CategoryFragment()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return screens!!.get(position)
    }
}