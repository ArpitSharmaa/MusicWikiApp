package com.example.musicwiki

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

private const val ARG_PARAM1 = "name"
private const val ARG_PARAM2 = "artistname"

class albumfrag : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
//        viewModel.gettrackinfo(param1!!,param2!!)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
//        viewModel.gettrackinfo(param1!!,param2!!)
        return inflater.inflate(R.layout.fragment_albumfrag, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.getinfoalbum(param1!!,param2!!)
        Log.d("hello", "onViewCreated: ${param2}")
        val button1 = view.findViewById<Button>(R.id.albumbutton)
        val imageview = view.findViewById<ImageView>(R.id.albuming)
        imageview.visibility= View.INVISIBLE
        val textview = view.findViewById<TextView>(R.id.albumtext)
        val tittle = view.findViewById<TextView>(R.id.textView8)
        tittle.visibility=View.INVISIBLE
        button1.setOnClickListener {


            viewModel.getinfoalbum(param1!!, param2!!)
            val data = viewModel.albuminfopass
            val recycler = view.findViewById<RecyclerView>(R.id.albumrecyclerView).apply {
                layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = data.value?.albumtags?.let { it1 ->
                    TagListAdapter(it1.albumtagss) {
                        val bundle = Bundle()
                        bundle.putString("id", it.tagname)
                        findNavController().navigate(R.id.action_albumfrag_to_genreInfo2, bundle)
                    }
                }


            }
            if (data.value != null) {
                Glide.with(requireContext())
                    .load(data.value?.imagee?.find { it.size == "large" }!!.urltoimg)
                    .into(imageview)
                imageview.visibility=View.VISIBLE
                tittle.text = data.value!!.name
                textview.text= data.value!!.bioalbum.sum
                tittle.visibility=View.VISIBLE
            }
            else{
                textview.text = "No data avialable on net"
            }

            button1.visibility = View.INVISIBLE
        }

    }
}