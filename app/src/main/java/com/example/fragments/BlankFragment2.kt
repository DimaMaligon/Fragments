package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragments.databinding.Fragment2Binding

class BlankFragment2 : Fragment() {
    lateinit var binding: Fragment2Binding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageFragment2.observe(activity as LifecycleOwner, {
            binding.messageText1.text = it
        })
        binding.bSendToFrag1.setOnClickListener {
            dataModel.messageFragment1.value = "Fragment 2"
        }
        binding.bsendToActivity2.setOnClickListener {
            dataModel.message.value = "Hello activity from frag 2"
        }
    }

    companion object {
        fun newInstance() = BlankFragment2()
    }
}