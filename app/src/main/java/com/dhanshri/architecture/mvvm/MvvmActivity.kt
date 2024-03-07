package com.dhanshri.architecture.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.dhanshri.architecture.R
import com.dhanshri.architecture.databinding.ActivityMainBinding
import com.dhanshri.architecture.databinding.ActivityMvvmBinding

class MvvmActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMvvmBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm)

        prepareRecyclerView()
        viewModel = androidx.lifecycle.ViewModelProvider(this)[MovieViewModel::class.java]
        viewModel.getPopularMovies()
        viewModel.observeMovieLiveData().observe(this, Observer { movieList ->
            movieAdapter.setMovieList(movieList)
        })
    }


    private fun prepareRecyclerView(){
        movieAdapter= MovieAdapter()
        binding.rvMovies.apply {
            layoutManager = GridLayoutManager(applicationContext, 2)
            adapter = movieAdapter
        }
    }
}