package com.example.musicwiki

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET

data class infoartist (
    @SerializedName("artist")
    val artistinfo:artistinfo
    )
data class artistinfo(
    val name:String,
    val bio: bio,
    val stats: stats,
    @SerializedName("tags")
    val artisttags: artisttags,
    @SerializedName("image")
    val imagee:List<image>
)
data class artisttags(
    @SerializedName("tag")
    val artisttagss:List<tag>
)
data class bio(
    @SerializedName("summary")
    val sum:String
)
data class stats(
    val listeners:Long,
    val playcount:Long
)
data class image(
    @SerializedName("size")
    val size:String,
    @SerializedName("#text")
    val urltoimg:String
)