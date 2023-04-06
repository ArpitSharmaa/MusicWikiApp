package com.example.musicwiki

import android.os.Bundle
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



class artistfrag : Fragment() {

    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
        viewModel.getinfoartist(param1!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.getinfoartist(param1!!)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_artistfrag, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.artistbutton)
        val tittle= view.findViewById<TextView>(R.id.textView9)
        tittle.visibility= View.INVISIBLE
        val image = view.findViewById<ImageView>(R.id.artisting)
        image.visibility=View.INVISIBLE
        val textsum = view.findViewById<TextView>(R.id.artisttext)
        textsum.visibility= View.INVISIBLE
        val count = view.findViewById<TextView>(R.id.textView11)
        count.visibility= View.INVISIBLE
        val listner = view.findViewById<TextView>(R.id.textView12)
        listner.visibility=View.INVISIBLE
        button.setOnClickListener {


            viewModel.getinfoartist(param1!!)
            val data = viewModel.artistinfopass
            val recycler = view.findViewById<RecyclerView>(R.id.artistrecyclerView).apply {
                layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = data.value?.artisttags?.let { it1 ->
                    TagListAdapter(it1.artisttagss) {
                        val bundle = Bundle()
                        bundle.putString("id", it.tagname)
                        findNavController().navigate(R.id.action_artistfrag2_to_genreInfo2, bundle)
                    }
                }


            }
            Glide.with(requireContext())
                .load(data.value?.imagee?.find { it.size == "large" }!!.urltoimg)
                .into(image)
            tittle.text= data.value!!.name
            textsum.text= data.value!!.bio.sum
            button.visibility = View.INVISIBLE
            tittle.visibility= View.VISIBLE
            count.text=data.value!!.stats.playcount.toString()
            count.visibility=View.VISIBLE
            image.visibility=View.VISIBLE
            listner.text=data.value!!.stats.listeners.toString()
            listner.visibility= View.VISIBLE
            textsum.visibility= View.VISIBLE
        }

    }
}