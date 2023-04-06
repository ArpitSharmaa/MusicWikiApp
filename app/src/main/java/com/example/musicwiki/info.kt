package com.example.musicwiki

import com.google.gson.annotations.SerializedName

data class info(
    @SerializedName("tag")
    val tagg: tagg
)
data class tagg(
    @SerializedName("wiki")
    val wiki: wiki
)
data class wiki(
    @SerializedName("summary")
    var summary :String
)

