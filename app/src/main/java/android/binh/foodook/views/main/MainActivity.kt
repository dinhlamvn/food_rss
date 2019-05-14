package android.binh.foodook.views.main

import android.binh.foodook.R
import android.binh.foodook.base.BaseActivity
import android.binh.foodook.base.BaseView
import android.os.Bundle
import android.support.design.widget.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity(), MainContract.View {

    private lateinit var pageAdapter : PageScreenAdapter
    private val presenter: MainPresenter = MainPresenter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPage()

        presenter.onCreate(this)
    }

    override fun getLayoutResource(): Int = R.layout.activity_main

    private fun initPage() {
        val titles = resources.getStringArray(R.array.screens).toList()
        pageAdapter = PageScreenAdapter(supportFragmentManager, titles)
        view_pager.adapter = pageAdapter
        view_pager.offscreenPageLimit = 1

        tab_layout.setupWithViewPager(view_pager, true)
        tab_layout.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(view_pager))
    }

    override fun show() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
