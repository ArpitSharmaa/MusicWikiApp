package com.example.musicwiki

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class GenreView : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_genre_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val switch = view.findViewById<Switch>(R.id.switch1)
        switch.visibility= View.INVISIBLE
        val list = viewModel.listpass

        list.observe(viewLifecycleOwner, Observer {
            switch.setOnCheckedChangeListener { compoundButton, b ->
                if (b){
                    val recycler= view.findViewById<RecyclerView>(R.id.genrelist).apply {
                        layoutManager = GridLayoutManager(context,2)
                        adapter = TagListAdapter(list.value!!) {
                            val bundle = Bundle()
                            bundle.putString("id",it.tagname)
                            findNavController().navigate(R.id.action_genreView_to_genreInfo2,bundle)
                        }
                    }
                    switch.text = "Top 10 Genre"
                }
                else{
                    val recycler= view.findViewById<RecyclerView>(R.id.genrelist).apply {
                        layoutManager = GridLayoutManager(context,2)
                        adapter = TagListAdapter(list.value!!.take(10)) {
                            val bundle = Bundle()
                            bundle.putString("id",it.tagname)
                            findNavController().navigate(R.id.action_genreView_to_genreInfo2,bundle)
                        }
                        switch.text = "All Genre"

                    }

                }
            }

        })
        val button = view.findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            viewModel.gettoptags()
            val recycler= view.findViewById<RecyclerView>(R.id.genrelist).apply {
                layoutManager = GridLayoutManager(context,2)
                adapter = TagListAdapter(list.value!!.take(10)) {
                    val bundle = Bundle()
                    bundle.putString("id",it.tagname)
                    viewModel.gettopartist(it.tagname)
                    viewModel.gettopalbums(it.tagname)
                    viewModel.gettoptracks(it.tagname)
                    viewModel.getinfo(it.tagname)
                    findNavController().navigate(R.id.action_genreView_to_genreInfo2,bundle)
                }


                }
            switch.visibility= View.VISIBLE

            }
    }


}