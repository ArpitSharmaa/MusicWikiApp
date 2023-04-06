package com.example.musicwiki

import androidx.core.app.NotificationCompat.Action.SemanticAction
import com.google.android.material.appbar.AppBarLayout.LayoutParams.ScrollEffect
import com.google.gson.annotations.SerializedName

data class tracks(
    @SerializedName("track")
    val tracklist:List<track>
)
data class track(
    @SerializedName("name")
    val name:String,
    @SerializedName("url")
    val url:String,
    @SerializedName("image")
    val image:List<imgtrack>,
    @SerializedName("artist")
    val artistaa:trackartist

)
data class imgtrack(
    @SerializedName("size")
    val size:String,
    @SerializedName("#text")
    val urltoimg:String
)
data class trackartist(
    @SerializedName("name")
    val trackartist :String
)
data class trackss(
    @SerializedName("tracks")
    val tracks: tracks
)