package android.binh.foodook.views.foods

import android.binh.foodook.R
import android.binh.foodook.models.food.Food
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class FoodAdapter(private var items : List<Food>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): FoodViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.food_item_row, parent, false)
        return FoodViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: FoodViewHolder, position: Int) {
        val food : Food = items[position]
        viewHolder.bind(food)
    }

    override fun getItemCount(): Int = items.size


    inner class FoodViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val textName : TextView = view.findViewById(R.id.text_name)
        private val imageView : ImageView = view.findViewById(R.id.image_view)

        fun bind(food : Food) {
            textName.text = food.name

            Glide.with(itemView).load(food.image).centerCrop().skipMemoryCache(false).into(imageView)
        }
    }
}