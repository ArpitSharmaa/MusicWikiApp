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
private const val ARG_PARAM2 = "artistname"

class trackfrag : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
        viewModel.gettrackinfo(param1!!,param2!!)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        viewModel.gettrackinfo(param1!!,param2!!)
        return inflater.inflate(R.layout.fragment_track, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.gettrackinfo(param1!!,param2!!)

        val button = view.findViewById<Button>(R.id.trackbutton)
        val imagevie = view.findViewById<ImageView>(R.id.tracking)
        imagevie.visibility= View.INVISIBLE
        val tittle = view.findViewById<TextView>(R.id.textView10)
        tittle.visibility= View.INVISIBLE
        val textesum = view.findViewById<TextView>(R.id.tracktext)
        textesum.visibility = View.INVISIBLE
        button.setOnClickListener {


                viewModel.gettrackinfo(param1!!, param2!!)
                val data = viewModel.trackinfopass
                val recycler = view.findViewById<RecyclerView>(R.id.recyclerView).apply {
                    layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    adapter = TagListAdapter(data.value!!.tracktags.tracktagss) {
                        val bundle = Bundle()
                        bundle.putString("id", it.tagname)
                        findNavController().navigate(R.id.action_trackfrag_to_genreInfo2, bundle)
                    }


                }

//            Glide.with(requireContext())
//                .load(data.value?.imagee?.find { it.size == "large" }!!.urltoimg)
//                .into(imagevie)
            imagevie.visibility= View.VISIBLE
            tittle.text= data.value!!.name
            tittle.visibility= View.VISIBLE

            textesum.text= data.value!!.biotrack.sum
            textesum.visibility= View.VISIBLE
            button.visibility = View.INVISIBLE
        }

    }
}