package com.dhanshri.architecture

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dhanshri.architecture.databinding.ActivityMainBinding
import com.dhanshri.architecture.mvc.MvcActivity
import com.dhanshri.architecture.mvp.MvpActivity
import com.dhanshri.architecture.mvvm.MvvmActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)



        binding.btnMVC.setOnClickListener {
           val intent = Intent(this, MvcActivity::class.java)
            startActivity(intent)
        }

        binding.btnMVP.setOnClickListener {
            val intent = Intent(this, MvpActivity::class.java)
            startActivity(intent)
        }

        binding.btnMVVM.setOnClickListener {
            val intent = Intent(this, MvvmActivity::class.java)
            startActivity(intent)
        }
    }
}