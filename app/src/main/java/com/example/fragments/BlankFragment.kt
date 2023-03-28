package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragments.databinding.Fragment1Binding

class BlankFragment : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageFragment1.observe(activity as LifecycleOwner, {
            binding.messageText.text = it
        })

        binding.bSendToFrag2.setOnClickListener {
            dataModel.messageFragment2.value = "Fragment 1"
        }
        binding.bsendToActivity.setOnClickListener {
            dataModel.message.value = "Hello activity from frag 1"
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}