package com.example.lesson19

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
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
    private var editLauncher:ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                adapter.addPlant(it.data?.getSerializableExtra("plant") as Plant)
            }
        }

    }
    private fun init(){
        binding.apply {
            rcView.layoutManager =  GridLayoutManager(this@MainActivity,3)
            rcView.adapter = adapter
            mainBtn.setOnClickListener{
                editLauncher?.launch(Intent(this@MainActivity,EditActivity::class.java))
            }
        }

    }
}