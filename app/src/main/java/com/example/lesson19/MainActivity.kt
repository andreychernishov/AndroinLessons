package com.example.lesson19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(), PlantAdapter.Listener {

    lateinit var rcView: RecyclerView
    lateinit var btnAdd: Button


    private val adapter = PlantAdapter(this)
    private var editLauncher: ActivityResultLauncher<Intent>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        init()
        launcher()

    }

    private fun launcher(){
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                adapter.addPlant(it.data?.getSerializableExtra("plant") as Plant)
            }
        }
        btnAdd.setOnClickListener {
            editLauncher?.launch(Intent(this@MainActivity,EditActivity::class.java))
        }
    }

    private fun init(){
        rcView.layoutManager = GridLayoutManager(this,3)
        rcView.adapter = adapter
    }

    private fun initView(){
        rcView = findViewById(R.id.rc_view)
        btnAdd = findViewById(R.id.add_plant_btn)
    }
    override fun onClick(plant: Plant) {
        startActivity(Intent(this, ContentActivity::class.java).apply {
            putExtra("item",plant)
        })
    }

}