package com.example.musicwiki

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class albumAddapter(val context: Context, val listof:List<album>,val listner:(album:album)->Unit): RecyclerView.Adapter<albumAddapter.Viewholder>() {
    inner class Viewholder (view: View): RecyclerView.ViewHolder(view){
        val head = view.findViewById<TextView>(R.id.textView5)
        val url = view.findViewById<TextView>(R.id.textView6)
        val img= view.findViewById<ImageView>(R.id.imageView2)
        init {
            itemView.setOnClickListener{
                listner.invoke(listof.get(adapterPosition))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val laypout = LayoutInflater.from(parent.context).inflate(R.layout.imagelist,parent,false)
        return Viewholder(laypout)
    }


    override fun getItemCount(): Int {
        return listof.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        with(holder){
            head.text = listof.get(position).name
            url.text= listof[position].url
            Glide.with(context).load(listof.get(position).image.find { it.size == "small" }!!.urltoimg).into(img)
        }
    }
}