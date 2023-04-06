package com.example.musicwiki

import com.google.gson.annotations.SerializedName

data class tag(
    @SerializedName("name")
    val tagname: String,
)
data class toptags(
    @SerializedName("tag")
    val tags:List<tag>
)
data class tagss(
    @SerializedName("toptags")
    val toptags: toptags
)