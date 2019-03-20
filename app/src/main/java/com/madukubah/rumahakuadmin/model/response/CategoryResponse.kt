package com.madukubah.rumahakuadmin.model.response

import com.google.gson.annotations.SerializedName
import com.madukubah.rumahakuadmin.model.Category


data class CategoryResponse (
        @field:SerializedName("data")
        val categories : List<Category>
)