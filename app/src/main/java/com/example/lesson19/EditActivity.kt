package com.example.lesson19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson19.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private var indexImage = 0
    private var imageId =  R.drawable.i1
    private var imageList = listOf(
        R.drawable.i1,
        R.drawable.i2,
        R.drawable.i3,
        R.drawable.i4,
        R.drawable.i5
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()





    }

    private fun initButtons() = with(binding){
        nextImageBtn.setOnClickListener {
            indexImage++
            if (indexImage > imageList.size - 1){
                indexImage = 0
            }
            imageId = imageList[indexImage]
            imageView.setImageResource(imageId)
        }
        doneBtn.setOnClickListener{
            val plant = Plant(imageId,editTextTitle.text.toString(),editTextDescription.text.toString())
            val editIntent = Intent().apply {
                putExtra("plant", plant)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }

}