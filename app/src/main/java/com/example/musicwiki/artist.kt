package com.example.musicwiki

import com.google.gson.annotations.SerializedName

data class topartists(
    @SerializedName("artist")
    val artistlist:List<artist>
)
data class artist(
    @SerializedName("name")
    val name:String,
    @SerializedName("url")
    val url:String,
    @SerializedName("image")
    val image:List<imgartist>

)
data class imgartist(
    @SerializedName("size")
    val size:String,
    @SerializedName("#text")
    val urltoimg:String
)
data class artistss(
    @SerializedName("topartists")
    val topartists: topartists
)