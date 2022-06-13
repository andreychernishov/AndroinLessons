package com.example.lesson19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var user = User("Sergey","222222",12)
        var user1 = User("Andrii","121212",32)
        user.addAge(11)
        user1.addAge(1)
        user.printInfo()
        user1.printInfo()
    }
}