package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFragment(BlankFragment.newInstance(), R.id.placeHolder)
        openFragment(BlankFragment2.newInstance(), R.id.placeHolder2)
        dataModel.message.observe(this, {
            binding.messageMain.text = it
        })
    }
        private fun openFragment(f: Fragment, idHolder: Int) {
            supportFragmentManager
                .beginTransaction()
                .replace(idHolder, f)
                .commit()

        }
    }