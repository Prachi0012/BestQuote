package com.example.bestquotes.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.bestquotes.Activity.QuotesActivity
import com.example.bestquotes.ModelClass.QuotesModelclass
import com.example.bestquotes.R

class QuotesAdapter(
    var quotesActivity: QuotesActivity,
    var quotelist: ArrayList<QuotesModelclass>,
    var Copy: ((id: Int, quotes: String) -> Unit),
    var Share: ((id: Int, quotes: String) -> Unit),
    var Edit: ((id: Int, quotes: String) -> Unit),
    var Favourite: ((Int, String) -> Unit)
) : RecyclerView.Adapter<QuotesAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtQuotes: TextView = itemView.findViewById(R.id.txtQuotes)
        var imgcopy: ImageView = itemView.findViewById(R.id.imgcopy)
        var imgShare: ImageView = itemView.findViewById(R.id.imgShare)
        var imgedit: CardView = itemView.findViewById(R.id.imgedit)
        var imglike: ImageView = itemView.findViewById(R.id.imglike)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesAdapter.MyViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.quotes_item_file, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtQuotes.text = quotelist[position].id.toString()
        holder.txtQuotes.text = quotelist[position].Quotes
        holder.imgcopy.setOnClickListener {
            Copy.invoke(quotelist[position].id, quotelist[position].Quotes)
        }
        holder.imgShare.setOnClickListener {
            Share.invoke(quotelist[position].id, quotelist[position].Quotes)
        }
        holder.imgedit.setOnClickListener {
            Edit.invoke(quotelist[position].id, quotelist[position].Quotes)
        }


        if (quotelist[position].Favourite == 1) {
           holder.imglike.setImageResource(R.drawable.filllike)
        } else {
             holder.imglike.setImageResource(R.drawable.like)
        }


        //like
        holder.imglike.setOnClickListener {
            if (quotelist[position].Favourite == 1) {
                holder.imglike.setImageResource(R.drawable.like)
                quotelist[position].Favourite = 0
                Favourite.invoke(quotelist[position].Favourite, quotelist[position].id.toString())

            } else {

                holder.imglike.setImageResource(R.drawable.filllike)
                quotelist[position].Favourite = 1
                Favourite.invoke(quotelist[position].Favourite, quotelist[position].id.toString())
            }
        }


//        holder.imglike.setOnClickListener {
//            Like.invoke(1,quotelist[position].id)
//        }
    }

    override fun getItemCount(): Int {
        return quotelist.size
    }



    fun refresh(quotelist: ArrayList<QuotesModelclass>)
    {
        this.quotelist = ArrayList()
        this.quotelist.addAll(quotelist)
        notifyDataSetChanged()
    }




}