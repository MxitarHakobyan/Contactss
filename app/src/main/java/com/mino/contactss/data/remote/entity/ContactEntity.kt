package com.mino.contactss.data.remote.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ContactEntity(

    @SerializedName("_id")
    @Expose
    val id: String,

    @SerializedName("firstName")
    @Expose
    val firstName: String,

    @SerializedName("lastName")
    @Expose
    val lastName: String,

    @SerializedName("phone")
    @Expose
    val phone: String,

    @SerializedName("email")
    @Expose
    val email: String,

    @SerializedName("notes")
    @Expose
    val notes: String,

    @SerializedName("images")
    @Expose
    val images: List<String>
)