package com.example.bestquotes.Activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bestquotes.Adapter.CategoryAdapter
import com.example.bestquotes.Database.MyDatabase
import com.example.bestquotes.ModelClass.CategoryModelclass
import com.example.bestquotes.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
    var Categorylist = ArrayList<CategoryModelclass>()
    lateinit var binding: ActivityCategoryBinding
    lateinit var categoryadapter: CategoryAdapter
    lateinit var Database: MyDatabase
    var unit = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        Database = MyDatabase(this)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {
        Categorylist = Database.CategoryDisplay()
        binding.imgmenu.setOnClickListener {
            binding.drawerlayout.openDrawer(GravityCompat.START)
        }
        binding.layouthome.setOnClickListener {
            binding.drawerlayout.closeDrawer(GravityCompat.START)
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
        }
        binding.layoutfavourite.setOnClickListener {
            binding.drawerlayout.closeDrawer(GravityCompat.START)
            val i = Intent(this, FavouriteQuoteActivity::class.java)
            startActivity(i)
        }
        binding.layoutshare.setOnClickListener {
            binding.drawerlayout.closeDrawer(GravityCompat.START)
            val share = Intent(Intent.ACTION_SEND)
            share.type = "text/plain"
            share.putExtra(
                Intent.EXTRA_TEXT,
                "https://play.google.com/store/apps/details?id=saptak.statusquotes"
            )
            startActivity(share)
        }
        binding.layoutexit.setOnClickListener {
            onBackPressed()
        }
        binding.txtprivacy.setOnClickListener {
            val url =
                "https://shrutichodvadiya.blogspot.com/2023/04/policy-terms-conditions-privacy-policy.html"
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(i)
        }
        binding.layoutsetting.setOnClickListener {
            val i = Intent(Intent(Settings.ACTION_SETTINGS))
            startActivity(i)
        }

        binding.layoutfavourite.setOnClickListener {
            val i = Intent(this,FavouriteQuoteActivity::class.java)
            startActivity(i)
        }
        categoryadapter = CategoryAdapter(this, Categorylist, OnclickItem = { id, name ->
            var i = Intent(this, QuotesActivity::class.java)
            i.putExtra("Id", id)
            i.putExtra("name", name)
            startActivity(i)

        })
        var manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rcv.adapter = categoryadapter
        binding.rcv.layoutManager = manager

    }
}