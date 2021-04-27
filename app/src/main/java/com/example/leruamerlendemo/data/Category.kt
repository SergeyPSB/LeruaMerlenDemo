package com.example.leruamerlendemo.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Category(
        val name: String,
        @SerialName("img_name") val img: String
)
