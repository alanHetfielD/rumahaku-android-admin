package com.madukubah.rumahakuadmin.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class User (
        @SerializedName("user_id") internal var user_id: Long? = null,
        @SerializedName("user_status") internal var user_status: Long? = null,
        @SerializedName("user_level") internal var user_level: Long? = null,

        @SerializedName("user_username") internal var user_username: String? = null,
        @SerializedName("user_profile_fullname") internal var user_profile_fullname: String? = null,
        @SerializedName("user_profile_address") internal var user_profile_address: String? = null,
        @SerializedName("user_profile_phone") internal var user_profile_phone: String? = null,
        @SerializedName("user_profile_email") internal var user_profile_email: String? = null,
        @SerializedName("user_profile_image_path") internal var user_profile_image_path: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readValue(Long::class.java.classLoader) as? Long,
            parcel.readValue(Long::class.java.classLoader) as? Long,
            parcel.readValue(Long::class.java.classLoader) as? Long,
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(user_id)
        parcel.writeValue(user_status)
        parcel.writeValue(user_level)
        parcel.writeString(user_username)
        parcel.writeString(user_profile_fullname)
        parcel.writeString(user_profile_address)
        parcel.writeString(user_profile_phone)
        parcel.writeString(user_profile_email)
        parcel.writeString(user_profile_image_path)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}