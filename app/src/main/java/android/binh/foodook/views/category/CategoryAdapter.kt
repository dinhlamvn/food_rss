package android.binh.foodook.views.category

import android.binh.foodook.models.category.CategoryModel
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class CategoryAdapter(items : List<CategoryModel>, clickListener: OnCategoryItemClickListener) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private val dataList : List<CategoryModel> = items
    private val listener : OnCategoryItemClickListener = clickListener

    override fun onCreateViewHolder(container: ViewGroup, p1: Int): CategoryViewHolder {
        val view = LayoutInflater.from(container.context).inflate(android.R.layout.simple_list_item_1, container, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: CategoryViewHolder, postion: Int) {
        val text = dataList[postion].title
        val url = dataList[postion].url

        val onClickListener : View.OnClickListener = View.OnClickListener {
            listener.onCategoryItemClick(text, url)
        }

        viewHolder.bind(text, onClickListener)
    }

    override fun getItemCount(): Int = dataList.size

    inner class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textView : TextView = view.findViewById<TextView>(android.R.id.text1)

        fun bind(text : String, listener : View.OnClickListener) {
            textView.text = text
            textView.setOnClickListener(listener)
        }
    }
}