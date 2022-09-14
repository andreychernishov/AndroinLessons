package com.example.lesson19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


import com.example.lesson19.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         val button : Button = findViewById(R.id.btn1)

        button.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_id, BlankFragment2.newInstance())
                .commit()
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_id,BlankFragment.newInstance())
            .commit()

    }
}