package com.example.lesson19

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner

class BlankFragment : Fragment() {

    private val dataModel : DataModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var buttonSend: Button = requireView().findViewById(R.id.fragment_1_btn_1)
        var btnSendToActivity: Button = requireView().findViewById(R.id.fragment_1_btn_2)
        var frag1Tw : TextView = requireView().findViewById(R.id.fragment_1_tw)
        dataModel.messageForFrag1.observe(activity as LifecycleOwner,{
            frag1Tw.text = it
        })

        buttonSend.setOnClickListener {
            dataModel.messageForFrag2.value = "Hello Fragment 2 from fragment 1"
        }
        btnSendToActivity.setOnClickListener {
            dataModel.messageForActivity.value = "Hello Activity from fragment 1"
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() = BlankFragment()
    }


}