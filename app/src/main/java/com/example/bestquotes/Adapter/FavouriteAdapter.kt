package com.example.bestquotes.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bestquotes.Activity.FavouriteQuoteActivity
import com.example.bestquotes.ModelClass.FavouriteQuoteModelclass
import com.example.bestquotes.R

class FavouriteAdapter(var favouriteQuoteActivity: FavouriteQuoteActivity, var favouritelist: ArrayList<FavouriteQuoteModelclass>
): RecyclerView.Adapter<FavouriteAdapter.MyViewHolder>() {

    class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView)
    {
        var txtQuotes: TextView = itemView.findViewById(R.id.txtQuotes)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteAdapter.MyViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.favourite_tem_file,parent,false)
        return FavouriteAdapter.MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.txtQuotes.text = favouritelist[position].quote

    }

    override fun getItemCount(): Int {

        return favouritelist.size
    }


}