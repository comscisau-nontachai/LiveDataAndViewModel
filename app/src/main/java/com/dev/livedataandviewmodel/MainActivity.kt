package com.dev.livedataandviewmodel

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listView: ListView = findViewById<View>(R.id.list) as ListView
        val progressBar = findViewById(R.id.progressbar) as ProgressBar
        progressBar.visibility = View.VISIBLE
        val model: MainActivityViewModel =
            ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        model.getFruitList()!!.observe(this,
            Observer { fruitlist: List<String>? ->
                // update UI
                val adapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, fruitlist!!
                )
                // Assign adapter to ListView
                listView.setAdapter(adapter)
                progressBar.visibility = View.GONE
            }
        )
    }
}