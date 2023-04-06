package com.example.musicwiki

import com.google.gson.annotations.SerializedName

data class trackinfofetch(
    @SerializedName("track")
    val trackinfo:trackinfo
)


data class trackinfo(
    val name:String,
    @SerializedName("listener")
    val listenerstrack: Long,
    @SerializedName("playcount")
    val playcounttrack: Long,
    @SerializedName("wiki")
    val biotrack: biotrack,

    @SerializedName("toptags")
    val tracktags: tracktags,
    @SerializedName("image")
    val imagee:List<imagetrack>
)
data class tracktags(
    @SerializedName("tag")
    val tracktagss:List<tag>
)

data class biotrack(
    @SerializedName("summary")
    val sum:String
)

data class imagetrack(
    @SerializedName("size")
    val size:String,
    @SerializedName("#text")
    val urltoimg:String
)