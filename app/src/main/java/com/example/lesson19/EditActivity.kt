package com.example.lesson19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class EditActivity : AppCompatActivity() {

    private var indexImage = 1
    private var imageId = R.drawable.plant1
    private val imageIdArrayList = listOf(
        R.drawable.plant1,
        R.drawable.plant2,
        R.drawable.plant3,
        R.drawable.plant4,
        R.drawable.plant5
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        initView()
        nextImage()
        done()


    }
    private fun nextImage(){
        nextImBtn.setOnClickListener {
             indexImage++
            if (indexImage > imageIdArrayList.size-1){
                indexImage = 0
            }
        imageId = imageIdArrayList[indexImage]
        image.setImageResource(imageId)
        }
    }

    private fun done(){
        doneBtn.setOnClickListener {
            val plant = Plant(imageId,edTitle.text.toString(),edDesc.text.toString())
            val editIntent = Intent().apply {
                putExtra("plant", plant)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }


     private fun initView(){
         image = findViewById(R.id.edit_act_im)
         nextImBtn= findViewById(R.id.next_im_btn)
         doneBtn = findViewById(R.id.edit_plant_btn)
         edTitle = findViewById(R.id.ed_title)
         edDesc = findViewById(R.id.ed_description)
    }

    lateinit var image: ImageView
    lateinit var nextImBtn: Button
    lateinit var doneBtn: Button
    lateinit var edTitle : EditText
    lateinit var edDesc : EditText


}