package com.example.musicwiki

import com.google.gson.annotations.SerializedName

data class albums(
    @SerializedName("album")
    val albumlist:List<album>
)
data class album(
    val name:String,
    val url:String,
    val image:List<img>,
    @SerializedName("artist")
    val artistsalbum:artistofalbum

)
data class img(
    @SerializedName("size")
    val size:String,
    @SerializedName("#text")
    val urltoimg:String
)
data class artistofalbum(
    @SerializedName("name")
    val name: String
)
data class albumss(
    @SerializedName("albums")
    val albums: albums
)