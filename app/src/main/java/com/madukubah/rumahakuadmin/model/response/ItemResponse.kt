package com.madukubah.rumahakuadmin.model.response

import com.google.gson.annotations.SerializedName
import com.madukubah.rumahakuadmin.model.Item

data class ItemResponse(
        @field:SerializedName("data")
        val items : List<Item>
)