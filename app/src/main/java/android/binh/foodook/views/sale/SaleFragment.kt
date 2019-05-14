package android.binh.foodook.views.sale

import android.binh.foodook.R
import android.binh.foodook.base.BaseFragment
import android.binh.foodook.models.category.CategoryModel
import android.binh.foodook.views.category.*
import android.binh.foodook.views.foods.FoodActivity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

class SaleFragment : BaseFragment(), SaleContract.View, OnCategoryItemClickListener {

    private val presenter : SalePresenter = SalePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onCreate(this)
    }

    override fun getLayoutResource(): Int = R.layout.fragment_category

    override fun renderLayout(view: View): View {
        val titles : List<String> = context!!.resources.getStringArray(R.array.category).toList()
        val urls : List<String> = context!!.resources.getStringArray(R.array.food_urls).toList()

        val size = (titles.size - 5)
        val items : MutableList<CategoryModel> = ArrayList<CategoryModel>()

        for (i in 0..size) {
            val title = titles[i]
            val url = urls[i]
            val it = CategoryModel(title, url)
            items.add(it)
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycle_view)
        val adapter = CategoryAdapter(items, this)
        recyclerView!!.adapter = adapter
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, LinearLayoutManager.VERTICAL))
        return view
    }

    override fun onCategoryItemClick(title: String, url: String) {
        val intent = Intent(this.context, FoodActivity::class.java)
        intent.putExtra("title", title)
        intent.putExtra("url", url)
        startActivityForResult(intent, REQUEST_LIST_FOOD_OF_CATEGORY)
    }
}