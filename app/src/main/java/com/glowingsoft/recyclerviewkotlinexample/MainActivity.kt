package com.glowingsoft.recyclerviewkotlinexample

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), CustomAdapter.Callback {


    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //getting recyclerview from xml

        val recyclerView = findViewById(R.id.rv) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        //crating an arraylist to store users using the data class user

        val users = ArrayList<User>()
        //adding some dummy data to the list
        users.add(User("Belal Khan", "Ranchi Jharkhand"))
        users.add(User("Ramiz Khan", "Ranchi Jharkhand"))
        users.add(User("Faiz Khan", "Ranchi Jharkhand"))
        users.add(User("Yashar Khan", "Ranchi Jharkhand"))

        //creating our adapter
        val adapter = CustomAdapter(users, this)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter
    }

    @SuppressLint("ShowToast")
    override fun onItemClicked(pos: Int) {
        Toast.makeText(this@MainActivity, "Its toast!" + " " + pos, Toast.LENGTH_SHORT).show()
    }
}
