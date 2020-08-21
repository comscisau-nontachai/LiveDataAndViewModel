package com.dev.livedataandviewmodel

import android.os.Handler
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.collections.ArrayList


class MainActivityViewModel : ViewModel() {
    private val TAG = "LOG_TAG"

    private var fruitList: MutableLiveData<List<String>>? = null

    fun getFruitList(): MutableLiveData<List<String>>? {
        if (fruitList == null) {
            fruitList = MutableLiveData()
            loadFruits()
        }
        return fruitList
    }

    private fun loadFruits() {
        // do async operation to fetch users
        val myHandler = Handler()
        myHandler.postDelayed({
            val fruitsStringList: MutableList<String> = ArrayList()
            fruitsStringList.add("Mango")
            fruitsStringList.add("Apple")
            fruitsStringList.add("Orange")
            fruitsStringList.add("Banana")
            fruitsStringList.add("Grapes")
            val seed = System.nanoTime()
            fruitsStringList.shuffle(Random(seed))
            fruitList!!.setValue(fruitsStringList)
        }, 5000)
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "on cleared called");
    }
}