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


class BlankFragment2 : Fragment() {
    private val dataModel: DataModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var frag2Tw : TextView = requireView().findViewById(R.id.fragment_2_tw)
        var btnSend: Button = requireView().findViewById(R.id.fragment_2_btn_1)
        var btnSendToActivity: Button = requireView().findViewById(R.id.fragment_2_btn_2)

        dataModel.messageForFrag2.observe(activity as LifecycleOwner) { frag2Tw.text = it }

        btnSend.setOnClickListener {
            dataModel.messageForFrag1.value = "Hello Fragment 1 from Fragment 2"
        }
        btnSendToActivity.setOnClickListener {
            dataModel.messageForActivity.value = "Hello Activity from fragment 2 "
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() = BlankFragment2()

    }

}