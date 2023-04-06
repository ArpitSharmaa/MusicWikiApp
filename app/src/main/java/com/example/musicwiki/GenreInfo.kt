package com.example.musicwiki

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView


private const val ARG_PARAM1 = "id"



class GenreInfo : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
        viewModel.getinfo(param1!!)




    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_genre_info, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val heading = view.findViewById<TextView>(R.id.textView2)
        val description = view.findViewById<TextView>(R.id.textView3)
        heading.text = param1.toString()
        val welcome = view.findViewById<TextView>(R.id.textView7)
        val button=view.findViewById<Button>(R.id.button)
        button.setOnClickListener{
            viewModel.getinfo(param1!!)
            val infooo= viewModel.infopass
            description.text= infooo.value!!.summary
            infooo.observe(viewLifecycleOwner, Observer {
                description.text= it.summary
            })
            button.visibility=View.INVISIBLE
        }
//        val infooo= viewModel.infopass
//        description.text= infooo.value!!.summary
//        infooo.observe(viewLifecycleOwner, Observer {
//            description.text= it.summary
//        })
        val menu = view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        menu.setOnItemSelectedListener {
            when(it.itemId){
                    R.id.trackss->{ gettrackslist(param1,view)
                        welcome.setVisibility(View.INVISIBLE)
                         true}
                R.id.albumms->{
                    getalbumnlist(param1,view)
                    welcome.setVisibility(View.INVISIBLE)
                    true
                }
                R.id.artistts->{
                    getartistlist(param1,view)
                    welcome.setVisibility(View.INVISIBLE)
                    true
                }


                else -> {

                    false
                }
            }

        }


    }
    fun gettrackslist(tag:String?,view: View){
        viewModel.gettoptracks(tag!!)
        val list = viewModel.tracklistpass
        list.observe(viewLifecycleOwner, Observer {
            val recyclerview = view.findViewById<RecyclerView>(R.id.listview).apply {
                layoutManager= GridLayoutManager(context,2)
                adapter = CommonAddapter(context,it){
                    val tracks= it
                        val bundle = Bundle()
                        bundle.putString("name",tracks.name)
                        bundle.putString("artistname",tracks.artistaa.trackartist)

                        findNavController().navigate(R.id.action_genreInfo2_to_trackfrag,bundle)

                }
            }
        })

    }
    fun getalbumnlist(tag:String?,view: View){
        viewModel.gettopalbums(tag!!)
        val list = viewModel.albumlistpass
        list.observe(viewLifecycleOwner, Observer {
            val recyclerview = view.findViewById<RecyclerView>(R.id.listview).apply {
                layoutManager= GridLayoutManager(context,2)
                adapter = albumAddapter(context,it){
                    viewModel.getinfoalbum(it.name,it.artistsalbum.name)
                    Log.d("hello", "getalbumnlist: ${ it.artistsalbum.name}")
                    val album = it
                    val bundle = Bundle()
                    bundle.putString("name",album.name)
                    bundle.putString("artistname",album.artistsalbum.name)

                    findNavController().navigate(R.id.action_genreInfo2_to_albumfrag,bundle)

                }
            }
        })

    }
    fun getartistlist(tag:String?,view: View){
        viewModel.gettopartist(tag!!)
        val list = viewModel.artistlistpass
        list.observe(viewLifecycleOwner, Observer {
            val recyclerview = view.findViewById<RecyclerView>(R.id.listview).apply {
                layoutManager= GridLayoutManager(context,2)
                adapter = artistAddapter(context,it){
                    val bundle = Bundle()
                    bundle.putString("name",it.name)

                    findNavController().navigate(R.id.action_genreInfo2_to_artistfrag2,bundle)

                }
            }
        })

    }

}