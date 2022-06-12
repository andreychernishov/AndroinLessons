package com.example.lesson19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    val lostArray = arrayOf(1000,2300,45000,65000,6500,400)     //created array with lost money
    val salaryArray = arrayOf(15000,300,345000,5000,16500,3400) //created array with salary money
    val resultArray = ArrayList<String>()                       //created arraylist for result
    val TAG = "@@@"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val names = resources.getStringArray(R.array.names)      //created array as string resource with names

        for ((i, name) in names.withIndex()){

            resultArray.add("$name - прибыль = ${salaryArray[i] - lostArray[i]}")
            Log.d(TAG,resultArray[i])

        }



    }
}