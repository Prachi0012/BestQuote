package com.example.bestquotes.Database

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import android.util.Log
import androidx.room.Update
import com.example.bestquotes.ModelClass.CategoryModelclass
import com.example.bestquotes.ModelClass.FavouriteQuoteModelclass
import com.example.bestquotes.ModelClass.QuotesModelclass
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

class MyDatabase(context:Context): SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    private val mDataBase: SQLiteDatabase? = null
    private var mNeedUpdate = false
    private val mContext: Context

    private fun copyDataBase() {
        if (!checkDataBase()) {
            this.readableDatabase
            close()
            try {
                copyDBFile()
            } catch (mIOException: IOException) {
                throw Error("ErrorCopyingDataBase")
            }
        }
    }

    private fun checkDataBase(): Boolean {
        val dbFile = File(DB_PATH + DB_NAME)
        return dbFile.exists()
    }


    @Throws(IOException::class)
    private fun copyDBFile() {
        val mInput = mContext.assets.open(DB_NAME)
        val mOutput: OutputStream = FileOutputStream(DB_PATH + DB_NAME)
        val mBuffer = ByteArray(1024)
        var mLength: Int
        while (mInput.read(mBuffer).also { mLength = it } > 0) mOutput.write(mBuffer, 0, mLength)
        mOutput.flush()
        mOutput.close()
        mInput.close()
    }

    override fun onCreate(db: SQLiteDatabase) {}
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (newVersion > oldVersion) mNeedUpdate = true
    }


    @Throws(IOException::class)
    fun updateDataBase() {
        if (mNeedUpdate) {
            val dbFile = File(DB_PATH + DB_NAME)
            if (dbFile.exists()) dbFile.delete()
            copyDataBase()
            mNeedUpdate = false
        }
    }

    @Synchronized
    override fun close() {
        mDataBase?.close()

    }

    fun CategoryDisplay():ArrayList<CategoryModelclass>
    {
        var read = readableDatabase
        var displaylist = ArrayList<CategoryModelclass>()
        var query = "select * from CategoryTb "
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()
         do {
             var id = cursor.getInt(0)
             var name = cursor.getString(1)
             displaylist.add(CategoryModelclass(id,name))
         }while (cursor.moveToNext())
         return displaylist
    }

    fun AttitudeQuotesDisplay(): ArrayList<QuotesModelclass>
    {
        var read = readableDatabase
        var displayquote = ArrayList<QuotesModelclass>()
        var query = "select * from Quotes where Category_id= 1"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()
        do {
            var id = cursor.getInt(0)
            var Quotes = cursor.getString(1)
            var fav = cursor.getInt(2)
            displayquote.add(QuotesModelclass(id,Quotes,fav))
        }while (cursor.moveToNext())
        return displayquote
    }
    fun AwesomeQuotesDisplay(): ArrayList<QuotesModelclass>
    {
        var read = readableDatabase
        var displayquote = ArrayList<QuotesModelclass>()
        var query = "select * from Quotes where Category_id= 2"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()
        do {
            var id = cursor.getInt(0)
            var Quotes = cursor.getString(1)
            var fav = cursor.getInt(2)
            displayquote.add(QuotesModelclass(id,Quotes,fav))        }while (cursor.moveToNext())
        return displayquote
    }
    fun CoolQuotesDisplay(): ArrayList<QuotesModelclass>
    {
        var read = readableDatabase
        var displayquote = ArrayList<QuotesModelclass>()
        var query = "select * from Quotes where Category_id= 3"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()
        do {
            var id = cursor.getInt(0)
            var Quotes = cursor.getString(1)
            var fav = cursor.getInt(2)
            displayquote.add(QuotesModelclass(id,Quotes,fav))
        }while (cursor.moveToNext())
        return displayquote
    }
    fun FriendsQuotesDisplay(): ArrayList<QuotesModelclass>
    {
        var read = readableDatabase
        var displayquote = ArrayList<QuotesModelclass>()
        var query = "select * from Quotes where Category_id= 4"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()
        do {
            var id = cursor.getInt(0)
            var Quotes = cursor.getString(1)
            var fav = cursor.getInt(2)
            displayquote.add(QuotesModelclass(id,Quotes,fav))
        }while (cursor.moveToNext())
        return displayquote
    }
    fun HappyQuotesDisplay(): ArrayList<QuotesModelclass>
    {
        var read = readableDatabase
        var displayquote = ArrayList<QuotesModelclass>()
        var query = "select * from Quotes where Category_id= 5"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()
        do {
            var id = cursor.getInt(0)
            var Quotes = cursor.getString(1)
            var fav = cursor.getInt(2)
            displayquote.add(QuotesModelclass(id,Quotes,fav))
        }while (cursor.moveToNext())
        return displayquote
    }
    fun HurtQuotesDisplay(): ArrayList<QuotesModelclass>
    {
        var read = readableDatabase
        var displayquote = ArrayList<QuotesModelclass>()
        var query = "select * from Quotes where Category_id= 6"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()
        do {
            var id = cursor.getInt(0)
            var Quotes = cursor.getString(1)
            var fav = cursor.getInt(2)
            displayquote.add(QuotesModelclass(id,Quotes,fav))
        }while (cursor.moveToNext())
        return displayquote
    }
    fun InspirationalQuotesDisplay(): ArrayList<QuotesModelclass>
    {
        var read = readableDatabase
        var displayquote = ArrayList<QuotesModelclass>()
        var query = "select * from Quotes where Category_id= 7"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()
        do {
            var id = cursor.getInt(0)
            var Quotes = cursor.getString(1)
            var fav = cursor.getInt(2)
            displayquote.add(QuotesModelclass(id,Quotes,fav))
        }while (cursor.moveToNext())
        return displayquote
    }

    fun LifeQuotesDisplay(): ArrayList<QuotesModelclass>
    {
        var read = readableDatabase
        var displayquote = ArrayList<QuotesModelclass>()
        var query = "select * from Quotes where Category_id= 8"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()
        do {
            var id = cursor.getInt(0)
            var Quotes = cursor.getString(1)
            var fav = cursor.getInt(2)
            displayquote.add(QuotesModelclass(id,Quotes,fav))
        }while (cursor.moveToNext())
        return displayquote
    }

    fun MotivationalQuotesDisplay(): ArrayList<QuotesModelclass>
    {
        var read = readableDatabase
        var displayquote = ArrayList<QuotesModelclass>()
        var query = "select * from Quotes where Category_id= 9"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()
        do {
            var id = cursor.getInt(0)
            var Quotes = cursor.getString(1)
            var fav = cursor.getInt(2)
            displayquote.add(QuotesModelclass(id,Quotes,fav))
        }while (cursor.moveToNext())
        return displayquote
    }

    fun MovingonQuotesDisplay(): ArrayList<QuotesModelclass>
    {
        var read = readableDatabase
        var displayquote = ArrayList<QuotesModelclass>()
        var query = "select * from Quotes where Category_id= 10"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()
        do {
            var id = cursor.getInt(0)
            var Quotes = cursor.getString(1)
            var fav = cursor.getInt(2)
            displayquote.add(QuotesModelclass(id,Quotes,fav))
        }while (cursor.moveToNext())
        return displayquote
    }

    fun SadQuotesDisplay(): ArrayList<QuotesModelclass>
    {
        var read = readableDatabase
        var displayquote = ArrayList<QuotesModelclass>()
        var query = "select * from Quotes where Category_id= 11"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()
        do {
            var id = cursor.getInt(0)
            var Quotes = cursor.getString(1)
            var fav = cursor.getInt(2)
            displayquote.add(QuotesModelclass(id,Quotes,fav))
        }while (cursor.moveToNext())
        return displayquote
    }

    fun SelfloveQuotesDisplay(): ArrayList<QuotesModelclass>
    {
        var read = readableDatabase
        var displayquote = ArrayList<QuotesModelclass>()
        var query = "select * from Quotes where Category_id= 12"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()
        do {
            var id = cursor.getInt(0)
            var Quotes = cursor.getString(1)
            var fav = cursor.getInt(2)
            displayquote.add(QuotesModelclass(id,Quotes,fav))
        }while (cursor.moveToNext())
        return displayquote
    }
    fun SingleQuotesDisplay(): ArrayList<QuotesModelclass>
    {
        var read = readableDatabase
        var displayquote = ArrayList<QuotesModelclass>()
        var query = "select * from Quotes where Category_id= 13"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()
        do {
            var id = cursor.getInt(0)
            var Quotes = cursor.getString(1)
            var fav = cursor.getInt(2)
            displayquote.add(QuotesModelclass(id,Quotes,fav))
        }while (cursor.moveToNext())
        return displayquote
    }

    fun SmileQuotesDisplay(): ArrayList<QuotesModelclass>
    {
        var read = readableDatabase
        var displayquote = ArrayList<QuotesModelclass>()
        var query = "select * from Quotes where Category_id= 14"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()
        do {
            var id = cursor.getInt(0)
            var Quotes = cursor.getString(1)
            var fav = cursor.getInt(2)
            displayquote.add(QuotesModelclass(id,Quotes,fav))
        }while (cursor.moveToNext())
        return displayquote
    }

    fun SuccessQuotesDisplay(): ArrayList<QuotesModelclass>
    {
        var read = readableDatabase
        var displayquote = ArrayList<QuotesModelclass>()
        var query = "select * from Quotes where Category_id= 15"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()
        do {
            var id = cursor.getInt(0)
            var Quotes = cursor.getString(1)
            var fav = cursor.getInt(2)
            displayquote.add(QuotesModelclass(id,Quotes,fav))
        }while (cursor.moveToNext())
        return displayquote
    }

    fun TrueQuotesDisplay(): ArrayList<QuotesModelclass>
    {
        var read = readableDatabase
        var displayquote = ArrayList<QuotesModelclass>()
        var query = "select * from Quotes where Category_id= 16"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()
        do {
            var id = cursor.getInt(0)
            var Quotes = cursor.getString(1)
            var fav = cursor.getInt(2)
            displayquote.add(QuotesModelclass(id,Quotes,fav))
        }while (cursor.moveToNext())
        return displayquote
    }

    fun UpdateFavouriteQuote(status: Int, id: Int)
    {
        var write = writableDatabase
        Log.e("TAG", "UpdateFavouriteQuote: "+status+"   id    "+id )
        val strSQL = "UPDATE Quotes SET Favourite=$status WHERE Id = $id"
        write.execSQL(strSQL)

    }


    fun FavouriteQuoteDisplay(): ArrayList<FavouriteQuoteModelclass>
    {
        var read = readableDatabase
        var displayquote = ArrayList<FavouriteQuoteModelclass>()
        var query = "select * from Quotes where Favourite = 100"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()
        do {
            var id = cursor.getInt(0)
            var Quotes = cursor.getString(1)
            var status = cursor.getInt(2)
            displayquote.add(FavouriteQuoteModelclass(id,Quotes,status))
        }while (cursor.moveToNext())
        return displayquote
    }




    companion object {
        private const val TAG = "MyDatabase"
        private const val DB_NAME = "CategoryDatabase"
        private var DB_PATH = ""
        private const val DB_VERSION = 1
    }

    init {
        if (Build.VERSION.SDK_INT >= 17) DB_PATH =
            context.applicationInfo.dataDir + "/databases/" else DB_PATH =
            "/data/data/" + context.packageName + "/databases/"
        mContext = context
        copyDataBase()
        this.readableDatabase
    }
}
