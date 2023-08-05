package com.example.bestquotes.Activity

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bestquotes.Adapter.QuotesAdapter
import com.example.bestquotes.Database.MyDatabase
import com.example.bestquotes.ModelClass.QuotesModelclass
import com.example.bestquotes.databinding.ActivityQuotesBinding

class QuotesActivity : AppCompatActivity() {

    var quotelist = ArrayList<QuotesModelclass>()
    lateinit var binding : ActivityQuotesBinding
    lateinit var quoteadapter : QuotesAdapter
    lateinit var database : MyDatabase
    var id : Int = 0
    lateinit var title : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database= MyDatabase(this)
        initview()
    }

    private fun initview() {

        if(intent!=null) {
            id = intent.getIntExtra("Id",id)
            title = intent.getStringExtra("name").toString()

            binding.txttitle.text = title
        }    

            if (id == 1) {
                quotelist = database.AttitudeQuotesDisplay()
            }

            else if (id == 2) {
                quotelist = database.AwesomeQuotesDisplay()
            }

            else if (id == 3) {
                quotelist = database.CoolQuotesDisplay()
            }

            else if (id == 4) {
                quotelist = database.FriendsQuotesDisplay()
            }

            else if (id == 5) {
                quotelist = database.HappyQuotesDisplay()
            }

            else if (id == 6) {
                quotelist = database.HurtQuotesDisplay()
            }

            else if (id == 7) {
                quotelist = database.InspirationalQuotesDisplay()
            }

            else if (id == 8) {
                quotelist = database.LifeQuotesDisplay()
            }

            else if (id == 9) {
                quotelist = database.MotivationalQuotesDisplay()
            }

            else if (id == 10) {
                quotelist = database.MovingonQuotesDisplay()
            }
            else if (id == 11) {
                quotelist = database.SadQuotesDisplay()
            }

            else if (id == 12) {
                quotelist = database.SelfloveQuotesDisplay()
            }

            else if (id == 13) {
                quotelist = database.SingleQuotesDisplay()
            }

            else if (id == 14) {
                quotelist = database.SmileQuotesDisplay()
            }

            else if (id == 15) {
                quotelist = database.SuccessQuotesDisplay()
            }

            else if (id == 16) {
                quotelist = database.TrueQuotesDisplay()
            }



        quoteadapter = QuotesAdapter(this,quotelist, Copy = {id , quotes ->

                Toast.makeText(this@QuotesActivity, "Copied", Toast.LENGTH_SHORT).show()
                val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("quote", quotes)
                clipboard.setPrimaryClip(clip)

        }, Share = {id, quotes ->

                var datashare = quotes
                var shareIntent = Intent(Intent.ACTION_SEND).apply {
                    type= "text/plain"
                    putExtra(Intent.EXTRA_TEXT,datashare)
                }
            startActivity(Intent.createChooser(shareIntent,"Share via"))
        }, Edit = {id, quotes ->

            var i = Intent(this, EditActivity::class.java)
            i.putExtra("Id",id)
            i.putExtra("quotes",quotes)
            i.putExtra("title",title)
            startActivity(i)

        }, Favourite = {Favourite, id ->
//                database.UpdateFavouriteQuote(id, Category_id =id)
            Log.e("TAG", "get id: "+Favourite)
            database.UpdateFavouriteQuote(Favourite,id.toInt())

        })
        var manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rcv.adapter = quoteadapter
        binding.rcv.layoutManager = manager

        quoteadapter.refresh(quotelist)
    }

}