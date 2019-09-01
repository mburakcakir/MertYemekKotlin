package com.mburcak.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserModel(

    val id: Int,
    val title: String,
    val body: String
)