package android.binh.foodook.views.foods

import android.binh.foodook.R
import android.binh.foodook.base.BaseActivity
import android.binh.foodook.models.food.Food
import android.binh.foodook.views.main.MainContract
import android.os.Bundle
import android.support.v7.widget.DialogTitle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_foods.*

class FoodActivity : BaseActivity(), FoodContract.View {

    private val presenter : FoodPresenter = FoodPresenter()
    private var items : MutableList<Food> = ArrayList<Food>()
    private var adapter : FoodAdapter = FoodAdapter(items)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.onCreate(this)

        val title : String = intent!!.getStringExtra("title")
        val url : String = intent!!.getStringExtra("url")

        showActionBarTitle(title)

        initListFood()

        showProgress("Loading...")
        presenter.loadFoods(url)
    }

    override fun getLayoutResource(): Int = R.layout.activity_foods

    override fun onResume() {
        super.onResume()
    }

    private fun initListFood() {
        recycle_view.setHasFixedSize(true)
        recycle_view.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        recycle_view.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        dismissProgress()
        finish()
    }

    private fun showActionBarTitle(title: String) {
        supportActionBar!!.title = title
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onLoadFoodsFinished(list: MutableList<Food>) {
        items.clear()
        items.addAll(list)
        adapter.notifyDataSetChanged()
        dismissProgress()
    }

    override fun onLoadFoodsFailed(error: String) {
        dismissProgress()
        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
    }

}