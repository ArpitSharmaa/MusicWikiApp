package com.example.musicwiki

import com.google.gson.annotations.SerializedName

data class albuminfofetch(
    @SerializedName("album")
    val albuminfo:albuminfo
)


data class albuminfo(
    @SerializedName("name")
    val name:String,
    @SerializedName("playcount")
    val playcounttrack: Long,
    @SerializedName("wiki")
    val bioalbum: bioalbum,

    @SerializedName("tags")
    val albumtags: albumtags,
    @SerializedName("image")
    val imagee:List<imagealbum>
)
data class albumtags(
    @SerializedName("tag")
    val albumtagss:List<tag>
)

data class bioalbum(
    @SerializedName("summary")
    val sum:String
)

data class imagealbum(
    @SerializedName("size")
    val size:String,
    @SerializedName("#text")
    val urltoimg:String
)
