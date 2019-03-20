package com.madukubah.rumahakuadmin.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Item (
        @SerializedName("item_id") val item_id : Int,
        @SerializedName("item_name") val item_name : String,
        @SerializedName("item_price") val item_price : Int,
        @SerializedName("item_description") val item_description : String,
        @SerializedName("item_images") val item_images : String,
        @SerializedName("item_facility") val item_facility : String,

        @SerializedName("user_profile_fullname") val user_profile_fullname : String,
        @SerializedName("user_profile_image_path") val user_profile_image_path : String,
        @SerializedName("user_profile_phone") val user_profile_phone : String,

        @SerializedName("store_name") val store_name : String,
        @SerializedName("store_address") val store_address : String,

        @SerializedName("store_id") val store_id : Int,
        @SerializedName("category_id") val category_id : Int,
        @SerializedName("create_date") val create_date : String
):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(item_id)
        parcel.writeString(item_name)
        parcel.writeInt(item_price)
        parcel.writeString(item_description)
        parcel.writeString(item_images)
        parcel.writeString(item_facility)
        parcel.writeString(user_profile_fullname)
        parcel.writeString(user_profile_image_path)
        parcel.writeString(user_profile_phone)
        parcel.writeString(store_name)
        parcel.writeString(store_address)
        parcel.writeInt(store_id)
        parcel.writeInt(category_id)
        parcel.writeString(create_date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }
}