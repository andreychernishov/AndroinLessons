package com.example.lesson19

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lesson19.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    private val adapter = PlantAdapter()
    private val imageIdList = listOf(
        R.drawable.i1,
        R.drawable.i2,
        R.drawable.i3,
        R.drawable.i4,
        R.drawable.i5
    )
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

    }

    private fun init(){
        binding.apply {
            rcView.layoutManager =  GridLayoutManager(this@MainActivity,3)
            rcView.adapter = adapter
            mainBtn.setOnClickListener {
                if (counter > 4){
                    counter = 0
                }
                val plant = Plant(imageIdList[counter], " Plant $counter")
                adapter.addPlant(plant)
                counter++
            }
        }
    }
}