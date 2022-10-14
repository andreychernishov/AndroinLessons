package com.example.lesson19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ContentActivity : AppCompatActivity() {

    lateinit var contentIm: ImageView
    lateinit var contentTv: TextView
    lateinit var contentTv2 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        init()
        val item = intent.getSerializableExtra("item") as Plant

        contentIm.setImageResource(item.imageId)
        contentTv.text = item.title
        contentTv2.text = item.description

    }
    fun init(){

        contentIm = findViewById(R.id.content_im_view)
        contentTv = findViewById(R.id.content_tv_1)
        contentTv2 = findViewById(R.id.content_tv_2)

    }
}