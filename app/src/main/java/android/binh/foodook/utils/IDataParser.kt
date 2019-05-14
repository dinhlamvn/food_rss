package android.binh.foodook.utils

import android.binh.foodook.base.BaseModel
import android.binh.foodook.models.food.Food

interface IDataParser {

    fun parseFood(string: String) : MutableList<Food>
}