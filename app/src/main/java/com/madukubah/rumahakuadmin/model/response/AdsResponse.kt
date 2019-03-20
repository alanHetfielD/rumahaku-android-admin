package com.madukubah.rumahakuadmin.model.response

import com.google.gson.annotations.SerializedName
import com.madukubah.rumahakuadmin.model.Ad

data class AdsResponse (
        @field:SerializedName("value")
        val Ads : List<Ad>
)