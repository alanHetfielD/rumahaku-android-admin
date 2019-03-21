package com.madukubah.rumahakuadmin.api.retrofit

import com.madukubah.rumahakuadmin.model.response.UserResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface loginService {
    @POST("user/login")
    @FormUrlEncoded
    fun loginPost(
            @Field("user_username") user_username: String,
            @Field("user_password") user_password: String
    ): Call<UserResponse>


    @POST("user/edit_user")
    @FormUrlEncoded
    fun editUserPost(
            @Field("user_id") user_id: Long,
            @Field("user_profile_fullname") user_profile_fullname: String,
            @Field("user_profile_address") user_profile_address: String,
            @Field("user_profile_phone") user_profile_phone: String,
            @Field("user_profile_email") user_profile_email: String
    ): Call<UserResponse>
}