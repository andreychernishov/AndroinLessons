package com.example.lesson19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

/*


Получить в панелеLogCat результат который указан ниже.
У нас есть интервалы которые обозначают качество оценки:
bad, normal, nice, excellent. еще у нас есть массив с оценками gradeArray и массив с учениками nameArray.
Ваша задача используя цикл отсортировать учеников с оценками по группам, в результате выход в панели
LogCat должен получится такой:
Плохие оценки: Ученик: Маша – 3
Плохие оценки: Ученик: Семен – 2
Нормальные оценки: Ученик: Антон – 4
Нормальные оценки: Ученик: Светлана – 6
Хорошие оценки: Ученик: Егор – 7
Отличные оценки: Ученик: Юля – 10
*/
class MainActivity : AppCompatActivity() {
    val LOG_TAG = "@@@"
    val badMarks = 0..3
    val normalMarks = 4..6
    val niceMarks = 7..9
    val excellentMark = 10          // grades of marks

    val gradeArray = arrayOf(4, 7, 3, 6, 10, 2) //student's marks array
    val namesArray = arrayOf("Антон", "Егор", "Маша", "Светлана", "Юля", "Семен")// student's names

    val badStudentsArray = ArrayList<String>()
    val normalStudentsArray = ArrayList<String>()
    val niceStudentsArray = ArrayList<String>()
    val excellentStudentsArray = ArrayList<String>() // array list for every grade

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        for ((i,name) in namesArray.withIndex()){
            when(gradeArray[i]){
                in badMarks -> badStudentsArray.add("Плохие оценки : Ученик : $name – ${gradeArray[i]}")
                in normalMarks ->  normalStudentsArray.add("Хорошие оценки : Ученик : $name – ${gradeArray[i]}")
                in niceMarks -> niceStudentsArray.add("Нормальные оценки : Ученик : $name – ${gradeArray[i]}")

                else -> excellentStudentsArray.add("Отличные оценки : Ученик : $name – ${gradeArray[i]}")
            }
        }

            badStudentsArray.forEach {
                Log.d(LOG_TAG,"$it")
            }
            normalStudentsArray.forEach {
                Log.d(LOG_TAG, "$it")
            }
            niceStudentsArray.forEach {
            Log.d(LOG_TAG,"$it")
            }
            excellentStudentsArray.forEach {
              Log.d(LOG_TAG,"$it")
            }



    }
}