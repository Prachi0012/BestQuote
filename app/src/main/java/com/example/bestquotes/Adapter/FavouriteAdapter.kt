package com.example.bestquotes.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bestquotes.Activity.FavouriteQuoteActivity
import com.example.bestquotes.ModelClass.FavouriteQuoteModelclass
import com.example.bestquotes.R

class FavouriteAdapter(
    var favouriteQuoteActivity: FavouriteQuoteActivity,
    var favouritelist: ArrayList<FavouriteQuoteModelclass>,var like: (Int, Int) -> Unit
) : RecyclerView.Adapter<FavouriteAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtQuotes: TextView = itemView.findViewById(R.id.txtQuotes)
        var imglike: ImageView = itemView.findViewById(R.id.imglike)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavouriteAdapter.MyViewHolder {

        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.quotes_item_file, parent, false)
        return FavouriteAdapter.MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.txtQuotes.text = favouritelist[position].quote

        //like
        holder.imglike.setImageResource(R.drawable.filllike)


        //like
        holder.imglike.setOnClickListener {


            like.invoke(0,favouritelist[position].id)
            favouritelist[position].status = 0



            //click button and set unlike
            deleteItem(position)  //create function and set position
        }
    }

    override fun getItemCount(): Int {

        return favouritelist.size
    }

    fun updateList(list: ArrayList<FavouriteQuoteModelclass>) {
        this.favouritelist = list
        notifyDataSetChanged()

    }

    private fun deleteItem(position: Int) {
        favouritelist.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, favouritelist.size)
    }

}
