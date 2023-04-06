package com.example.musicwiki

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
// url trackinfo https://ws.audioscrobbler.com/2.0/?method=track.getInfo&api_key=7917fe7261795f38e7b9a59826a1a835&artist=cher&track=believe&format=json
//url https://ws.audioscrobbler.com/2.0/?method=tag.getTopTags&api_key=7917fe7261795f38e7b9a59826a1a835&format=jsonn
//url album https://ws.audioscrobbler.com/2.0/?method=tag.gettopalbums&tag=disco&api_key=7917fe7261795f38e7b9a59826a1a835&format=json
//url artist https://ws.audioscrobbler.com/2.0/?method=tag.gettopartists&tag=disco&api_key=7917fe7261795f38e7b9a59826a1a835&format=json
//url tracks https://ws.audioscrobbler.com/2.0/?method=tag.gettoptracks&tag=disco&api_key=7917fe7261795f38e7b9a59826a1a835&format=json
// https://ws.audioscrobbler.com/2.0/?method=tag.getinfo&tag=disco&api_key=7917fe7261795f38e7b9a59826a1a835&format=json
val API_KEY:String= "7917fe7261795f38e7b9a59826a1a835"
val BASE_URL:String="https://ws.audioscrobbler.com/2.0/"

interface Services {
    @GET("?method=tag.getTopTags&format=json")
    suspend fun gettoptags(@Query("api_key") apiKey: String):Response<tagss>
    @GET("?method=tag.gettopalbums&format=json")
    suspend fun gettopalbums(@Query("api_key") apiKey: String, @Query("tag") tag:String):Response<albumss>
    @GET("?method=tag.gettopartists&format=json")
    suspend fun gettopartists(@Query("api_key") apiKey: String,@Query("tag") tag:String):Response<artistss>
    @GET("?method=tag.gettoptracks&format=json")
    suspend fun gettoptrackss(@Query("api_key") apiKey: String, @Query("tag") tag:String):Response<trackss>
    @GET("?method=tag.getinfo&format=json")
    suspend fun gettaginfo(@Query("api_key") apiKey: String, @Query("tag") tag:String):Response<info>
    @GET("?method=track.getInfo&format=json")
    suspend fun getrackinfo(@Query("api_key") apiKey: String,@Query("track") track:String,@Query("artist") artist: String):Response<trackinfofetch>
    @GET("?method=album.getInfo&format=json")
    suspend fun getalbuminfo(@Query("api_key") apiKey: String,@Query("album") album:String,@Query("artist") artist: String):Response<albuminfofetch>
    @GET("?method=artist.getInfo&format=json")
    suspend fun getartistinfo(@Query("api_key") apiKey: String,@Query("artist") artist: String):Response<infoartist>
    companion object {
        val retrofit by lazy {
            Retrofit.Builder().baseUrl(BASE_URL).client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Services::class.java)

        }
    }
}