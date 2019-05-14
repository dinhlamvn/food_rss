package android.binh.foodook.models.food

import android.binh.foodook.base.BaseModel

data class Food(var image : String = "", var name : String = "", var time : String = "", var rate : Int = 0) : BaseModel()