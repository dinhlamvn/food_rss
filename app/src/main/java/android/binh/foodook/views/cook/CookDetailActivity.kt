package android.binh.foodook.views.cook

import android.binh.foodook.R
import android.binh.foodook.base.BaseActivity
import android.os.Bundle
import android.view.MenuItem

class CookDetailActivity : BaseActivity(), CookDetailContract.View {

    private val presenter : CookDetailPresenter = CookDetailPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.onCreate(this)

        if (intent != null) {
            val title = intent.getStringExtra("food_name")
            setUpActionBarTitle(title)
        }
    }

    private fun setUpActionBarTitle(title : String) {
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.title = title
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }

    override fun getLayoutResource(): Int = R.layout.activity_cook_detail
}