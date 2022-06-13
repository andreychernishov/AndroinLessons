package com.example.lesson19

import android.util.Log


class User( var name: String, var id: String, var age: Int) {

    fun addAge(years: Int){
        age += years
    }
    fun printInfo(){
        Log.d("@@@","User name: $name, id: $id, age: $age")
    }
}