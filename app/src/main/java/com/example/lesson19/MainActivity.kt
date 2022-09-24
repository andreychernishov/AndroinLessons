package com.example.lesson19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment

 class MainActivity : AppCompatActivity() {
    private val dataModel : DataModel by viewModels()
    private lateinit var mainTw : TextView
    private lateinit var frag1 : TextView
    private lateinit var frag2 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        openFrag(BlankFragment.newInstance(), R.id.frame_id)
        openFrag(BlankFragment2.newInstance(),R.id.frame_2_id)

        dataModel.messageForActivity.observe(this) { mainTw.text = it }
        /*dataModel.messageForFrag1.observe(this){frag1.text = it}
        dataModel.messageForFrag2.observe(this){frag2.text = it }
 */
    }

    private fun openFrag(f : Fragment, idHolder: Int){
        supportFragmentManager.beginTransaction().replace(idHolder,f).commit()
    }
    private fun init(){
         mainTw = findViewById(R.id.hello_world_tw)

    }

}