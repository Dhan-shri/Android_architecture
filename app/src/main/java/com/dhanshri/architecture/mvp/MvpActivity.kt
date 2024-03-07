package com.dhanshri.architecture.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.dhanshri.architecture.R
import com.dhanshri.architecture.databinding.ActivityMvcBinding
import com.dhanshri.architecture.databinding.ActivityMvpBinding

class MvpActivity : AppCompatActivity(), Contract.View {
    private lateinit var binding: ActivityMvpBinding
    var presenter : Presenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this, R.layout.activity_mvp)

        presenter = Presenter(this, Model2())

        this.binding.searchGoBtn.setOnClickListener { presenter!!.onButtonClick() }

    }

    override fun onResume(){
        super.onResume()
    }

    override fun onDestroy(){
        super.onDestroy()
        presenter!!.onDestroy()
    }

    override fun showProgress() {
        binding.SHOWPROGRESS.visibility = View.VISIBLE
        binding.textView.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        binding.SHOWPROGRESS.visibility = View.GONE
        binding.textView.visibility = View.VISIBLE
    }

    override fun setString(string: String?) {
        binding.textView.text = string
    }
}