package com.madukubah.rumahakuadmin.model.response

import com.google.gson.annotations.SerializedName
import com.madukubah.rumahakuadmin.model.User

data class UserResponse
(
        @SerializedName("status")
        internal var status: Int? = null,
        @SerializedName("message")
        internal var message: String? = null,
        @field:SerializedName("data")
        val user : List<User>
)