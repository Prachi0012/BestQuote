package com.example.bestquotes.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bestquotes.Adapter.FavouriteAdapter
//import com.example.bestquotes.Adapter.FavouriteQuoteAdapter
import com.example.bestquotes.Database.MyDatabase
import com.example.bestquotes.ModelClass.FavouriteQuoteModelclass
import com.example.bestquotes.databinding.ActivityFavouriteQuoteBinding

class FavouriteQuoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityFavouriteQuoteBinding
    var favouritelist = ArrayList<FavouriteQuoteModelclass>()
    lateinit var favouriteadapter: FavouriteAdapter
    lateinit var db: MyDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavouriteQuoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = MyDatabase(this)
        initview()
    }
    private fun initview() {
        favouritelist = db.FavouriteQuoteDisplay()
        favouriteadapter = FavouriteAdapter(this, favouritelist, like = {
                status, id ->
            db.UpdateFavouriteQuote(
                status,
                id
            )
        })
        var manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rcv.adapter =favouriteadapter
        binding.rcv.layoutManager = manager

        favouriteadapter.updateList(favouritelist)
    }

}