package com.example.musicwiki

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class ViewModel(context:Application):AndroidViewModel(Application()) {
//    val repository= repository(context)
//    fun tags(): List<tag>{
//        var list: List<tag> = listOf()
//        viewModelScope.launch {
//            withContext(Dispatchers.IO){
//              list =   repository.gettags()
//            }
//        }
//        return list
//    }
var list = MutableLiveData<List<tag>>()
    val listpass :LiveData<List<tag>>
    get()= list
    var listfetch:List<tag> = listOf()

    fun gettoptags(){

        viewModelScope.launch {
            withContext(Dispatchers.IO){
               listfetch= Services.retrofit.gettoptags(API_KEY).body()!!.toptags.tags
            }
        }
        list.value= listfetch
    }

    var listoftrack = MutableLiveData<List<track>>()
    val tracklistpass :LiveData<List<track>>
        get()= listoftrack
    var tracklistfetch:List<track> = listOf()

    fun gettoptracks(name:String){

        viewModelScope.launch {
            withContext(Dispatchers.IO){
                tracklistfetch= Services.retrofit.gettoptrackss(API_KEY,name).body()!!.tracks.tracklist
            }
        }
        listoftrack.value= tracklistfetch
    }
    var listofalbums = MutableLiveData<List<album>>()
    val albumlistpass :LiveData<List<album>>
        get()= listofalbums
    var albumlistfetch:List<album> = listOf()

    fun gettopalbums(name:String){

        viewModelScope.launch {
            withContext(Dispatchers.IO){
                albumlistfetch= Services.retrofit.gettopalbums(API_KEY,name).body()!!.albums.albumlist
            }
        }
        listofalbums.value= albumlistfetch
    }
    var listofartist = MutableLiveData<List<artist>>()
    val artistlistpass :LiveData<List<artist>>
        get()= listofartist
    var artistlistfetch:List<artist> = listOf()

    fun gettopartist(name:String){

        viewModelScope.launch {
            withContext(Dispatchers.IO){
                artistlistfetch= Services.retrofit.gettopartists(API_KEY,name).body()!!.topartists.artistlist
            }
        }
        listofartist.value= artistlistfetch
    }
    var infoo =MutableLiveData<wiki>()
    val infopass :LiveData<wiki>
    get() = infoo
    var wiki = wiki("")
    fun getinfo(name:String){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                wiki.summary = Services.retrofit.gettaginfo(API_KEY,name).body()!!.tagg.wiki.summary            }
        }
        infoo.value=wiki
    }

        var artistinfoo = MutableLiveData<artistinfo>()
        val artistinfopass: LiveData<artistinfo>
        get() = artistinfoo
        var listofinfoartist :artistinfo?= null
        fun getinfoartist(name: String) {
            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    listofinfoartist =
                        Services.retrofit.getartistinfo(API_KEY, name).body()?.artistinfo
                }
            }
            artistinfoo.value = listofinfoartist
        }
    var trackinfos = MutableLiveData<trackinfo>()
    val trackinfopass : LiveData<trackinfo>
    get()= trackinfos
    var listoftrackingo : trackinfo?= null
    fun gettrackinfo(trackname:String,artistname:String){

        viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    listoftrackingo = Services.retrofit.getrackinfo(API_KEY, trackname, artistname)
                        .body()!!.trackinfo
                }
        }
        trackinfos.value=listoftrackingo
    }
    var albuminfos = MutableLiveData<albuminfo>()
    val albuminfopass : LiveData<albuminfo>
    get()= albuminfos
    var listofalbumingo : albuminfo? = null
    @OptIn(ExperimentalCoroutinesApi::class)
    fun getinfoalbum(albumname:String, artistname1:String){
        Log.d("hello", "getinfoalbum: ${albumname}")
        val dataretrieve=viewModelScope.launch {
            withContext(Dispatchers.IO){
                listofalbumingo = Services.retrofit.getalbuminfo(API_KEY,albumname,artistname1).body()!!.albuminfo
                Log.d("hello", "getinfoalbum: ${listofalbumingo}")

            }
            albuminfos.value = listofalbumingo
        }
//        albuminfos.value=listofalbumingo
    }


}