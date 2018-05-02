package com.project2.myphotoapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.view.Menu
import android.view.MenuItem
import com.project2.myphotoapp.API.PhotoRetriever
import com.project2.myphotoapp.models.Photo
import com.project2.myphotoapp.models.PhotoList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {


    var photos : List<Photo>? = null
    var mainAdapter : MainAdapter? = null
    // no need to init
    lateinit var recyclerView : RecyclerView

    override fun onClick(view: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.


    }

    // special keyword "fun" to define a function
    // default modifier is "Public"
    // Internal is a new modifier and makes the variable visible in the same modal (same as package?)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // "as" keyword is the type casting variable!
        // encourage to use "val" as much as possible for the mutability
        // var myname:string ="nonta the cat"
        // myname ="nonta the rat"
        // if the type is nullable, add the ? after the type
        // var name2:String? = null
        //val len = name2?.length (implicitly check if it is not null we get the length to avoid nullpointerexception
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        var photoRetriever = PhotoRetriever()
        var callback = object : Callback<PhotoList> {
            override fun onResponse(call: Call<PhotoList>?, response: Response<PhotoList>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                response?.isSuccessful.let {

                    this@MainActivity.photos = response?.body()?.photoList
                    mainAdapter = MainAdapter(this@MainActivity.photos!!, this@MainActivity)
                    recyclerView.adapter = mainAdapter

                }
            }

            override fun onFailure(call: Call<PhotoList>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Log.e("MainActivity", "Call back failure", t)
            }

        }

        photoRetriever.getPhotos(callback)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }
}
