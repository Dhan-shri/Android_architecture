package com.dhanshri.architecture.mvc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.dhanshri.architecture.R
import com.dhanshri.architecture.databinding.ActivityMvcBinding
import java.util.Observable
import java.util.Observer

class MvcActivity : AppCompatActivity(), Observer, View.OnClickListener {

    var myModel: Model? = null

    private lateinit var binding: ActivityMvcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_mvc)

        myModel = Model()
        myModel!!.addObserver(this)
        binding.button.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
    }

    @Deprecated("Deprecated in Java")
    @SuppressLint("SetTextI18n")
    override fun update(o: Observable?, arg: Any?) {
        binding.button.text ="Count: " + myModel!!.getValueAtIndex(0)
        binding.button2.text = "Count: "+ myModel!!.getValueAtIndex(1)
        binding.button3.text = "Count: "+ myModel!!.getValueAtIndex(2)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.button -> myModel!!.setValueAtIndex(0)
            R.id.button2 -> myModel!!.setValueAtIndex(1)
            R.id.button3 -> myModel!!.setValueAtIndex(2)
        }
    }
}