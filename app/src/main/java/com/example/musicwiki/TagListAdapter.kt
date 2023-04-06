package com.example.musicwiki

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TagListAdapter(val list : List<tag>, val listner:(tag: tag)->Unit):RecyclerView.Adapter<TagListAdapter.viewholder> (){
    inner class viewholder(view: View):RecyclerView.ViewHolder(view){
        val name = view.findViewById<TextView>(R.id.textView4)
        init {
            itemView.setOnClickListener {
            listner.invoke(list[adapterPosition])
        }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val itemlayout = LayoutInflater.from(parent.context).inflate(R.layout.taglistview,parent,false)
        return viewholder(itemlayout)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        with(holder){
            name.text= list[position].tagname
        }
    }
}


