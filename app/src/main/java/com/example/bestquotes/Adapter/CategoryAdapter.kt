package com.example.bestquotes.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.bestquotes.Activity.CategoryActivity
import com.example.bestquotes.Adapter.CategoryAdapter.*
import com.example.bestquotes.ModelClass.CategoryModelclass
import com.example.bestquotes.R

class CategoryAdapter(var categoryActivity: CategoryActivity, var categorylist : ArrayList<CategoryModelclass>
      ,var OnclickItem :((id:Int,name:String)-> Unit)): RecyclerView.Adapter<MyViewHolder>() {
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var txtCategory : TextView = itemView.findViewById(R.id.txtCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.category_item_file,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtCategory.text= categorylist[position].id.toString()
        holder.txtCategory.text= categorylist[position].name
        holder.txtCategory.setOnClickListener {

            OnclickItem.invoke(categorylist[position].id,categorylist[position].name)
        }
    }

    override fun getItemCount(): Int {
        return categorylist.size
    }

}


